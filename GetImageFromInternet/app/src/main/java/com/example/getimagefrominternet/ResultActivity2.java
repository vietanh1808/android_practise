package com.example.getimagefrominternet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class ResultActivity2 extends AppCompatActivity {
    Button btnBack, btnSend;
    EditText edtName, edtAge, edtPoint;
    RadioButton rdNam, rdNu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result2);
        mapping();
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hoten = edtName.getText().toString();
                int tuoi = Integer.parseInt(edtAge.getText().toString());
                boolean gioitinh = rdNam.isSelected() ? true : false;
                float diemtb = Float.parseFloat(edtPoint.getText().toString());
                Intent intent = new Intent(ResultActivity2.this, ConfirmActivity2.class);
//                intent.putExtra("hoten", hoten);
//                intent.putExtra("tuoi", tuoi);
//                intent.putExtra("gioitinh", gioitinh);
//                intent.putExtra("diemtb", diemtb);

//                Student s = new Student(hoten, tuoi, gioitinh, diemtb);
//                intent.putExtra("student", s);

                Bundle bundle = new Bundle();
                bundle.putString("hoten", hoten);
                bundle.putInt("tuoi", tuoi);
                bundle.putBoolean("gioitinh", gioitinh);
                bundle.putFloat("diemtb", diemtb);
                Student s = new Student(hoten, tuoi, gioitinh, diemtb);
                bundle.putSerializable("student", s);
                intent.putExtra("thongtinsv", bundle);
                startActivity(intent);
            }
        });
    }

    public void mapping() {
        btnBack = (Button) findViewById(R.id.btnBack);
        btnSend = (Button) findViewById(R.id.btnSend);
        edtName = (EditText) findViewById(R.id.edtName);
        edtAge = (EditText) findViewById(R.id.edtAge);
        edtPoint = (EditText) findViewById(R.id.edtPoint);
        rdNam = (RadioButton) findViewById(R.id.rdNam);
        rdNu = (RadioButton) findViewById(R.id.rdNu);
    }
}