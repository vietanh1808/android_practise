package com.example.democonnectdb;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    MyDatabase myDatabase;
    Cursor cs;
    final String TableName = "Books";
    private static final int DATABASE_VERSION = 2;
    TextView txtvBookId, txtvBookName, txtvBookPage, txtvBookPrice, txtvBookDescription;
    Button btnNext, btnLast, btnPre, btnFirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();

        // Create Database
        myDatabase = new MyDatabase(MainActivity.this, "Book.sqlite", null, DATABASE_VERSION);
        String sqlCreateTable_Books = "create table if not exists Books (id integer primary key autoincrement," +
                                        "BookID integer," +
                                        "BookName varchar(100)," +
                                        "Page integer," +
                                        "Price float," +
                                        "Description text)";
        myDatabase.excuteSQL(sqlCreateTable_Books);

//        Book book1 = new Book(0, 123 , "Sách lập trình Java", 100, 30000, "Đây là sách lập trình");
//        Book book2 = new Book(1, 234 , "Sách lập trình Android", 111, 30000, "Đây là sách lập trình");
//        Book book3 = new Book(2, 345, "Sách lập trình C", 222, 40000, "Đây là sách lập trình");
//        Book bookUpdate = new Book(2, 352, "Sách lập trình nâng cao", 333, 50000, "Đây là sách lập trình");

//        insertData("Books", book1);
//        insertData("Books", book2);
//        insertData("Books", book3);
//        deleteData("Books", 4);
//        upateData("Books", bookUpdate);
//        printData("Books");

        loadFirstRecord(); // lấy Cursor trỏ về bản ghi đầu tiên
        updateData();

    }
    private void loadFirstRecord() {
        String sqlSelect = "select * from " + TableName;
        cs = myDatabase.selectData(sqlSelect);
        cs.moveToNext();
    }
    private void mapping() {
        txtvBookId = findViewById(R.id.txtvBookId);
        txtvBookName = findViewById(R.id.txtvBookName);
        txtvBookPage = findViewById(R.id.txtvBookPage);
        txtvBookPrice = findViewById(R.id.txtvBookPrice);
        txtvBookDescription = findViewById(R.id.txtvBookDescription);
        btnNext = findViewById(R.id.btnNext);
        btnLast = findViewById(R.id.btnLast);
        btnPre = findViewById(R.id.btnPre);
        btnFirst = findViewById(R.id.btnFirst);
    }
    private void updateData() {
//        List<Book> list = getAll();
        txtvBookId.setText("Mã sách: " + cs.getInt(1));
        txtvBookName.setText("Tên sách: " + cs.getString(2));
        txtvBookPage.setText("Số trang sách: " + cs.getInt(3));
        txtvBookPrice.setText("Giá sách: " + cs.getInt(4));
        txtvBookDescription.setText("Mô tả sách: " + cs.getString(5));

        btnPre.setEnabled(!cs.isFirst());
        btnNext.setEnabled(!cs.isLast());
    }
    public List<Book> getAll() {
        List<Book> list = new ArrayList<>();
        String sqlSelect = "select * from " + TableName;
        Cursor c = myDatabase.selectData(sqlSelect);

        while (c.moveToNext()) {
            int id = c.getInt(0);
            int bookId = c.getInt(1);
            String bookName = c.getString(2);
            int page = c.getInt(3);
            float price = c.getFloat(4);
            String description = c.getString(5);

            Book book = new Book(id, bookId, bookName, page, price, description);
            list.add(book);
            Toast.makeText(this, book.toString(), Toast.LENGTH_SHORT).show();
        }

        return list;
    }
    public void printTable(String TableName) {
        String sqlSelect = "select * from " + TableName;
        Cursor c = myDatabase.selectData(sqlSelect);

        while (c.moveToNext()) {
            int id = c.getInt(0);
            int bookId = c.getInt(1);
            String bookName = c.getString(2);
            int page = c.getInt(3);
            float price = c.getFloat(4);
            String description = c.getString(5);

            Book book = new Book(id, bookId, bookName, page, price, description);
            Toast.makeText(this, book.toString(), Toast.LENGTH_SHORT).show();
        }
    }
    public boolean insertTable(String TableName, Book book) {
        try {
            String sqlInsert1 = "insert into "+TableName+" values("+"null"+", "+book.getBookId()+", '"+book.getBookName()+"', "+book.getPage()+", "+book.getPrice()+", '"+book.getDescription()+"')";
            myDatabase.excuteSQL(sqlInsert1);
            Toast.makeText(this, "Insert "+book.getBookName()+" thành công", Toast.LENGTH_SHORT).show();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Insert Failed", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
    public boolean deleteTable(String TableName, Book book) {
        try {
            String sqlDel = "delete from " + TableName + " where id="+book.getBookId()+"";
            myDatabase.excuteSQL(sqlDel);
            Toast.makeText(this, "Delete OK", Toast.LENGTH_SHORT).show();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Delete Failed", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
    public boolean deleteTable(String TableName, int id) {
        try {
            String sqlDel = "delete from " + TableName + " where id="+id+"";
            myDatabase.excuteSQL(sqlDel);
            Toast.makeText(this, "Delete OK", Toast.LENGTH_SHORT).show();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Delete Failed", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
    public boolean upateTable(String TableName, Book book) {
        try {
            String sqlUpdate = "update " + TableName +" set BookId="+book.getBookId()+ ", BookName='"+book.getBookName()+"', Page="+book.getPage()+", Price="+book.getPrice()+", Description='"+book.getDescription()+"' where id="+book.getId()+"";
            myDatabase.excuteSQL(sqlUpdate);
            Toast.makeText(this, "Update OK", Toast.LENGTH_SHORT).show();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Update Failed", Toast.LENGTH_SHORT).show();
            return false;
            }
    }
    public void first(View view) {
        cs.moveToFirst();
        updateData();
    }
    public void previous(View view) {
        cs.moveToPrevious();
        updateData();
    }
    public void next(View view) {
        cs.moveToNext();
        updateData();
    }
    public void last(View view) {
        cs.moveToLast();
        updateData();
    }
}