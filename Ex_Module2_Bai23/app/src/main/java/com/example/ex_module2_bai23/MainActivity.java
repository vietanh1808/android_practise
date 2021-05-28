package com.example.ex_module2_bai23;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    final Calendar calendar = Calendar.getInstance();
    EditText edtName, edtNote;
    TextView txtDate, txtTime;
    Button btnDate, btnTime, btnAdd;
    ArrayAdapter adapter;
    List<String> list = new ArrayList<>();
    ListView lvlJobs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        lvlJobs.setAdapter(adapter);

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Date Picker
                DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        txtDate.setText(day + "/" + month + "/" + year);
                    }
                };
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, dateSetListener,
                        calendar.YEAR, calendar.MONTH, calendar.DAY_OF_MONTH);
                datePickerDialog.show();
            }
        });
        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Time Set Listener.
                TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hour, int minute) {
                        String am_pm = (hour < 12) ? "AM" : "PM";
                        txtTime.setText(hour + ":" + minute + " " + am_pm);
                    }
                };
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, timeSetListener,
                        calendar.HOUR_OF_DAY, calendar.MINUTE, true);
                timePickerDialog.show();
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String workName = edtName.getText().toString();
                String workDate = txtDate.getText().toString();
                String workTime = txtTime.getText().toString();
                list.add(workName + " - " + workDate + " - " + workTime);
                adapter.notifyDataSetChanged();

                edtName.setText("");
                edtNote.setText("");
            }
        });

    }
    public void mapping() {
        edtName = (EditText) findViewById(R.id.edtName);
        edtNote = (EditText) findViewById(R.id.edtNote);
        txtDate = (TextView) findViewById(R.id.txtDate);
        txtTime = (TextView) findViewById(R.id.txtTime);
        btnDate = (Button) findViewById(R.id.btnDate);
        btnTime = (Button) findViewById(R.id.btnTime);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        lvlJobs = (ListView) findViewById(R.id.lvlJobs);
    }
}