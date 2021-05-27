package com.example.getimagefrominternet;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class IntentPlicitActivity2 extends AppCompatActivity {
    private static final int PICK_IMAGE = 100;
    private static final int REQUEST_ID_READ_WRITE_PERMISSION = 100;
    private static final int MY_CAMERA_REQUEST_CODE = 100;
    int REQUEST_ID_IMAGE_CAPTURE = 100;
    ImageView imgChrome, imgPhone, imgGallery, imgCamera, imgMessage, imgItentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_plicit2);
        mapping();
    }

    public void camera(View v) {
        ActivityCompat.requestPermissions(this, new
                        String[] { Manifest.permission.CAMERA },
                1);
    }

    public void chrome(View v) {
        ActivityCompat.requestPermissions(this, new
                        String[] { Manifest.permission.INTERNET },
                2);
    }

    public void phone(View v) {
        ActivityCompat.requestPermissions(this, new
                        String[] { Manifest.permission.CALL_PHONE },
                3);
    }

    public void message(View v) {
        ActivityCompat.requestPermissions(this, new
                        String[] { Manifest.permission.SEND_SMS },
                4);
    }

    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Intent intent = new Intent();
        switch (requestCode) {
            case 1:
                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
                break;
            case 2:
                String urlString = "https://www.google.com.vn/?hl=vi";
                intent.setAction(intent.ACTION_VIEW);
                intent.setData(Uri.parse(urlString));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setPackage("com.android.chrome");
                startActivity(intent);
                break;
            case 3:
                intent.setAction(intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:0988888888"));
                startActivity(intent);
                break;
            case 4:
                intent.setAction(intent.ACTION_VIEW);
                intent.setData(Uri.parse("sms:"));
                intent.putExtra("sms_body", "123");
                startActivity(intent);
                break;
        }
    }

    public void gallery(View v) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(intent, 2);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode == RESULT_OK && requestCode == 2){
            try {
                Uri imageUri = intent.getData();
                InputStream imageStream = getContentResolver().openInputStream(imageUri);
                Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                imgItentView.setImageBitmap(selectedImage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void mapping() {
        ImageView imgChrome = (ImageView) findViewById(R.id.imgChrome);
        ImageView imgPhone = (ImageView) findViewById(R.id.imgPhone);
        ImageView imgGallery = (ImageView) findViewById(R.id.imgGallery);
        ImageView imgCamera = (ImageView) findViewById(R.id.imgCamera);
        ImageView imgMessage = (ImageView) findViewById(R.id.imgMessage);
        ImageView imgItentView = (ImageView) findViewById(R.id.imgItentView);
    }
}