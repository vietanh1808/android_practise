package com.example.democonnectdb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SimActivity extends AppCompatActivity {
    public static MyDatabase myDatabase;
    Cursor cs;
    public static String TABLE_NAME = "sim";
    public static final String ID_FIELD = "id";
    public static final String SO_FIELD = "so";
    public static final String GIA_FIELD = "gia";
    ArrayAdapter adapter;
    ListView lvlSim;
    List<Sim> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sim);
        mapping();
        myDatabase = new MyDatabase(SimActivity.this, "sim.sqlite", null, 1);
        String sql_createTable = "create table if not exists " + TABLE_NAME +
                " (id integer primary key autoincrement, " +
                SO_FIELD + " varchar(20), " +
                GIA_FIELD + " float)";
        myDatabase.excuteSQL(sql_createTable);

        list = getAll();
        adapter = new ArrayAdapter(SimActivity.this, android.R.layout.simple_list_item_1, list);
        lvlSim.setAdapter(adapter);

        Sim sim1 = new Sim(1, "0936231123", 10000);
        Sim sim2 = new Sim(1, "0936021156", 20000);
        Sim sim3 = new Sim(3, "0923621189", 40000);
//        insertTable(sim1);
//        insertTable(sim2);
//        insertTable(sim3);
//        deleteTable(2);
//        updateTable(sim3);

//        ContentValues values = new ContentValues();
//        values.put(SO_FIELD, "0345678901");
//        values.put(GIA_FIELD, "1111111");
//        myDatabase.insert(TABLE_NAME, null, values);
//        String whereClause = "id = ?";
//        String[] whereArgs = {"4"};
//        myDatabase.update(TABLE_NAME, values, whereClause, whereArgs);
//        myDatabase.delete(TABLE_NAME, whereClause, whereArgs);
//        printTable();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menubar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnuAdd) {
            startActivity(new Intent(SimActivity.this, AddNumberActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    private void mapping() {
        lvlSim = findViewById(R.id.lvlSim);
    }
    public List<Sim> getAll() {
        List<Sim> list = new ArrayList<>();
        String sqlSelect = "select * from " + TABLE_NAME;
        Cursor c = myDatabase.selectData(sqlSelect);

        while (c.moveToNext()) {
            int id = c.getInt(0);
            String so = c.getString(1);
            float gia = c.getFloat(2);

            Sim sim = new Sim(id, so, gia);
            list.add(sim);
            Toast.makeText(this, sim.toString(), Toast.LENGTH_SHORT).show();
        }

        return list;
    }
    public void printTable() {
        String sqlSelect = "select * from " + TABLE_NAME;
        Cursor c = myDatabase.selectData(sqlSelect);

        while (c.moveToNext()) {
            int id = c.getInt(0);
            String so = c.getString(1);
            float gia = c.getFloat(2);

            Sim sim = new Sim(id, so, gia);
            Toast.makeText(this, sim.toString(), Toast.LENGTH_SHORT).show();
        }
    }
    public boolean insertTable(Sim sim) {
        try {
            String insertQuery = "insert into " +TABLE_NAME+ " values (null, '" +sim.getSo() +"', "+ sim.getGia()+ ")";
            myDatabase.excuteSQL(insertQuery);
            Toast.makeText(this, "insert success", Toast.LENGTH_SHORT).show();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "insert failed", Toast.LENGTH_SHORT).show();
            return false;
        }

    }
    public boolean deleteTable(int id) {
        try {
            String sqlDel = "delete from " + TABLE_NAME + " where id="+id+"";
            myDatabase.excuteSQL(sqlDel);
            Toast.makeText(this, "Delete OK", Toast.LENGTH_SHORT).show();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Delete Failed", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
    public boolean deleteTable(Sim sim) {
        try {
            String sqlDel = "delete from " + TABLE_NAME + " where id="+sim.getId()+"";
            myDatabase.excuteSQL(sqlDel);
            Toast.makeText(this, "Delete OK", Toast.LENGTH_SHORT).show();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Delete Failed", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
    public boolean updateTable(Sim sim) {
        try {
            String sqlUpdate = "update " + TABLE_NAME +" set so='" +sim.getSo()+"', gia="+sim.getGia()+" where id="+sim.getId()+"";
            myDatabase.excuteSQL(sqlUpdate);
            Toast.makeText(this, "Update OK", Toast.LENGTH_SHORT).show();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Update Failed", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

}