package com.example.customlistview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FruitsAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<Fruits> list;

    public FruitsAdapter(Context context, int layout, List<Fruits> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);

        // ánh xạ các control trên view đấy
        ImageView imgOrange = convertView.findViewById(R.id.imgOrange);
        TextView txtHoten = convertView.findViewById(R.id.txtHoten);
        TextView txtMota = convertView.findViewById(R.id.txtMota);
        ImageView imgHoaqua = convertView.findViewById(R.id.imgHoaqua);

        Fruits fruit = list.get(position);
        imgOrange.setImageResource(fruit.getImgAvatar());
        txtHoten.setText(fruit.getHoten());
        txtMota.setText(fruit.getClub());
        imgHoaqua.setImageResource(fruit.getFlag());

        return convertView;
    }
}
