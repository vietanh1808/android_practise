package com.example.democonnectdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNumberActivity extends AppCompatActivity {
    EditText edtNumber, edtPrice;
    Button btnAdd, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_number);
        mapping();
    }
    private void mapping() {
        edtNumber = findViewById(R.id.edtNumber);
        edtPrice = findViewById(R.id.edtPrice);
        btnAdd = findViewById(R.id.btnAdd);
        btnCancel = findViewById(R.id.btnCancel);

    }
    public void Add(View view) {
        String so = edtNumber.getText().toString();
        Float gia = Float.parseFloat(edtPrice.getText().toString());

        ContentValues values = new ContentValues();
        values.put(SimActivity.SO_FIELD, so);
        values.put(SimActivity.GIA_FIELD, gia);
        SimActivity.myDatabase.insert(SimActivity.TABLE_NAME, null, values);
        startActivity(new Intent(AddNumberActivity.this, SimActivity.class));
    }
    public void Cancel(View view) {
        startActivity(new Intent(AddNumberActivity.this, SimActivity.class));
    }
}