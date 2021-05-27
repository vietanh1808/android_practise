package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lvFruits;
    List<Fruits> list;
    FruitsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvFruits = findViewById(R.id.listFruits);
        list = new ArrayList<>();
        list.add(new Fruits(R.drawable.orange, "Quả Cam", "Có màu cam", R.drawable.hoaqua1));
        list.add(new Fruits(R.drawable.banana, "Quả Chuối", "Có màu vàng", R.drawable.hoaqua2));
        list.add(new Fruits(R.drawable.tao, "Quả Táo", "Có màu đỏ", R.drawable.hoaqua3));
        list.add(new Fruits(R.drawable.duachuot, "Quả dưa chuột", "Có màu xanh", R.drawable.hoaqua3));
        list.add(new Fruits(R.drawable.catim, "Quả cà tím", "Có màu tím", R.drawable.hoaqua2));
        list.add(new Fruits(R.drawable.chanh, "Quả chanh", "Có màu xanh", R.drawable.hoaqua1));

        adapter = new FruitsAdapter(this, R.layout.fruits, list);
        lvFruits.setAdapter(adapter);
    }
}