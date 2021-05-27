package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txtHello;
    ConstraintLayout constraintLayout;
    Button btnConfirm, btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();

        txtHello.setOnClickListener(this);
        btnConfirm.setOnClickListener(this);
        btnLogin.setOnClickListener(this);

        this.registerForContextMenu(constraintLayout);

    }

    private void mapping() {
        constraintLayout = findViewById(R.id.layoutMain);
        txtHello = findViewById(R.id.txtHello);
        btnConfirm = findViewById(R.id.btnConfirm);
        btnLogin = findViewById(R.id.btnLogin);
    }

    // Hiển thị Menu ở nền
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // Bắt sự kiện cho menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnuAdd:
                Toast.makeText(this, "Bạn click vào Add", Toast.LENGTH_LONG).show();
                break;
            case R.id.mnuFeedback:
                Toast.makeText(this, "Bạn click vào Feedback", Toast.LENGTH_LONG).show();
                break;
            case R.id.mnuHelp:
                Toast.makeText(this, "Bạn click vào Help", Toast.LENGTH_LONG).show();
                break;
            case R.id.mnuLogin:
                Toast.makeText(this, "Bạn click vào Login", Toast.LENGTH_LONG).show();
                break;
            case R.id.mnuLogout:
                Toast.makeText(this, "Bạn click vào Logout", Toast.LENGTH_LONG).show();
                break;
            case R.id.mnuSearch:
                Toast.makeText(this, "Bạn click vào Search", Toast.LENGTH_LONG).show();
                break;
            case R.id.mnuSetting:
                Toast.makeText(this, "Bạn click vào Setting", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    // Hiển thị Context Menu với Long Click
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
        menu.setHeaderTitle("Chọn màu nền");
        menu.setHeaderIcon(R.mipmap.ic_launcher);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnuRed:
                constraintLayout.setBackgroundColor(Color.RED);
                break;
            case R.id.mnuBlue:
                constraintLayout.setBackgroundColor(Color.BLUE);
                break;
            case R.id.mnuYellow:
                constraintLayout.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.mnuNau:
                constraintLayout.setBackgroundColor(Color.GRAY);
                break;
            case R.id.mnuPurple:
                constraintLayout.setBackgroundColor(Color.MAGENTA);
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnConfirm:
                showConfirm();
                break;
            case R.id.txtHello:
                showPopupMenu();
                break;
            case R.id.btnLogin:
                showDialogLogin();
        }
    }

    // Hàm hiện menu với sự kiện Button
    private void showPopupMenu() {
        PopupMenu popupMenu = new PopupMenu(this, txtHello);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.mnuOne:
                        Toast.makeText(MainActivity.this, "Bạn đã chọn 1", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.mnuTwo:
                        Toast.makeText(MainActivity.this, "Bạn đã chọn 2", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.mnuThree:
                        Toast.makeText(MainActivity.this, "Bạn đã chọn 3", Toast.LENGTH_LONG).show();
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }
    private void showConfirm() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Cảnh báo!!");
        builder.setMessage("Đây là thông báo xác nhận ...");
        builder.setIcon(R.mipmap.ic_launcher);
        // thiết lập 2 nút khác nhau
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Bạn đã click vào OK", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Bạn đã click vào Cancel", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }
    private void showDialogLogin() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.login);
        dialog.setTitle("CustomDialog");
        dialog.setCanceledOnTouchOutside(false);

        EditText edtUsername = dialog.findViewById(R.id.edtUsername);
        EditText edtPassword = dialog.findViewById(R.id.edtPassword);
        Button btnLoginDialog = dialog.findViewById(R.id.btnLoginDialog);
        Button btnCancelDialog = dialog.findViewById(R.id.btnCancelDialog);

        btnCancelDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        btnLoginDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();
                if (username.equals("admin") && password.equals("admin")) {
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
            }
        });
        dialog.show();
    }
}