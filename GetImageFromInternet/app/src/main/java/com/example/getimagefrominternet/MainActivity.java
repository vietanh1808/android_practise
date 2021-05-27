package com.example.getimagefrominternet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {
    TextView txtStatus;
    ImageView img;
    Button btnDownload, btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ResultActivity2.class);
                startActivity(intent);
            }
        });
    }
    public void abc(View v) {
        String url = "https://suckhoedoisong.vn/Images/nguyenkhanh/2017/01/20/ga_trong_y_duoc.jpg";
        new DownloadImage().execute(url);
    }

    public class DownloadImage extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            Bitmap bm = null;
            URL url = null;
            try {
                url = new URL(strings[0]);
                URLConnection connection = url.openConnection();
                InputStream is = connection.getInputStream();
                bm = BitmapFactory.decodeStream(is);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bm;
        }

        @Override
        protected void onPostExecute(Bitmap s) {
            super.onPostExecute(s);
            img.setImageBitmap(s);
            txtStatus.setText("Đã tải xong!");
        }
    }

    public void mapping() {
        txtStatus = (TextView) findViewById(R.id.txtStatus);
        img = (ImageView) findViewById(R.id.img);
        btnDownload = (Button) findViewById(R.id.btnDownload);
        btnNext = (Button) findViewById(R.id.btnNext);
    }
}