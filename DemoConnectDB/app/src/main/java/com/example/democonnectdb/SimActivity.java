package com.example.democonnectdb;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

public class SimActivity extends AppCompatActivity {
    MyDatabase myDatabase;
    Cursor cs;
    String TABLE_NAME = "sim";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sim);

        myDatabase = new MyDatabase(SimActivity.this, "sim.sqlite", null, 1);
        myDatabase.excuteSQL("create table if not exists " + TABLE_NAME +
                " (id integer primary key autoincrement, " +
                " so varchar(20), " +
                " gia float)");
        Sim sim1 = new Sim(1, "0936231123", 10000);
        Sim sim2 = new Sim(1, "0936021156", 20000);
        Sim sim3 = new Sim(3, "0923621189", 40000);
//        insertTable(sim1);
//        insertTable(sim2);
//        insertTable(sim3);
//        deleteTable(2);
//        updateTable(sim3);
        printTable();
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