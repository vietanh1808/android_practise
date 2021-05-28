package com.example.practise_8x;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtUsername, edtPassword;
    Button btnLogin, btnCancel;
    CheckBox chkLuuTT;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();
        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
        edtUsername.setText(sharedPreferences.getString("username", ""));
        edtPassword.setText(sharedPreferences.getString("password", ""));
        chkLuuTT.setChecked(sharedPreferences.getBoolean("isCheck", false));
    }

    private void mapping() {
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnCancel = findViewById(R.id.btnCancel);
        chkLuuTT = findViewById(R.id.chkLuuTT);
    }
    public void login(View v) {
        String username = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();
        boolean isCheck = chkLuuTT.isChecked();

        if (username.equals("admin") && password.equals("1")) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            if (isCheck) {
                editor.putString("username", username);
                editor.putString("password", password);
                editor.putBoolean("isCheck", isCheck);
                editor.commit();
            } else {
                editor.remove("username");
                editor.remove("password");
                editor.remove("isCheck");
                editor.commit();
            }

            Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
        }
    }
    public void cancel(View v) {

    }
}