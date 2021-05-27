package com.example.getimagefrominternet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class ConfirmActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm2);

        Intent intent = getIntent();
//        String hoten = intent.getStringExtra("hoten");
//        int tuoi = intent.getIntExtra("tuoi", 0);
//        boolean gioitinh = intent.getBooleanExtra("gioitinh", false);
//        float diemtb = intent.getFloatExtra("diemtb", 0);
//
//        Student s1 = new Student(hoten, tuoi, gioitinh, diemtb);
//        Student s2 = (Student) intent.getSerializableExtra("student");
//        Toast.makeText(this, s2+"", Toast.LENGTH_LONG).show();

        Bundle bundle = intent.getBundleExtra("thongtinsv");
        String hoten = bundle.getString("hoten");
        int tuoi = bundle.getInt("tuoi", 0);
        boolean gioitinh = bundle.getBoolean("gioitinh", false);
        float diemtb = bundle.getFloat("diemtb", 0);
//        Student s1 = new Student(hoten, tuoi, gioitinh, diemtb);
        Student s2 = (Student) bundle.getSerializable("student");
        Toast.makeText(this, s2+"", Toast.LENGTH_LONG).show();

    }
}