package com.example.practise_8x;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WrtieAndReadFile extends AppCompatActivity implements View.OnClickListener{
    EditText edtTextSave, edtTextRead;
    Button btnSave, btnRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrtie_and_read_file);

        mapping();
        btnSave.setOnClickListener(this);
        btnRead.setOnClickListener(this);
    }
    private void mapping() {
        edtTextRead = findViewById(R.id.edtTextRead);
        edtTextSave = findViewById(R.id.edtTextSave);
        btnSave = findViewById(R.id.btnSave);
        btnRead = findViewById(R.id.btnRead);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSave:
                String text = edtTextSave.getText().toString();
//                WriteData(text);
                WriteDataCache(text);
                break;
            case R.id.btnRead:
//                String text1 = readData();
                String text1 = readDataCache();
                edtTextRead.setText(text1);
                break;
        }
    }

    private void WriteData(String text) {
        try {
            FileOutputStream fos = openFileOutput("testData.txt", MODE_PRIVATE);
            fos.write(text.getBytes());
            fos.close();
            Toast.makeText(this, "Ghi dữ liệu thành công", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readData() {
        FileInputStream fis = null;
        String retval = "";
        try {
            byte[] buffer = new byte[1024];
            fis = openFileInput("testData.txt");
            int count = fis.read(buffer);
            retval = new String(buffer);
            fis.close();
            Toast.makeText(this, "Đóng File thành công", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.getMessage();
        }

        return retval;
    }

    private void WriteDataCache(String text) {
        File f = getCacheDir();
        String cacheDir = f.getPath();
        File mediaFile = new File(cacheDir, "mediaFile.dat");
        System.out.println("mediaFile = " + mediaFile.getPath());
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(mediaFile);
            fos.write(text.getBytes());
            Toast.makeText(this, "Ghi File Cache thành công", Toast.LENGTH_SHORT).show();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readDataCache() {
        FileInputStream fis = null;
        String retval = "";

        try {
            String cacheDir = getCacheDir().getPath() + "/mediaFile.dat";
            System.out.println("cacheDir = " + cacheDir);
            byte[] buffer = new byte[1024];
            fis = openFileInput(cacheDir);
            int count = fis.read(buffer);
            retval = new String(buffer);
            Toast.makeText(this, "Đọc File Cache thành công", Toast.LENGTH_SHORT).show();
            fis.close();
        } catch (Exception e) {
            e.getMessage();
        }

        return retval;
    }
}