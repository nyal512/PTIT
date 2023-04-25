package com.example.ptit;

import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ptit.Database.SQLiteHelper;
import com.example.ptit.model.User;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {
    private TextInputEditText username, password;
    Button btnLogin;
    TextView txtRegis;

    private final String[] MISSING_INPUT_WARNING = {"Vui lòng nhập tên đăng nhập", "Vui lòng nhập mật khẩu", "Vui lòng nhập username và password"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.editUser);
        password = findViewById(R.id.editPassword);
        btnLogin = findViewById(R.id.btnLogin);
        txtRegis = findViewById(R.id.txtRegis);

        btnLogin.setOnClickListener(view -> {
            String user = username.getText().toString();
            String pass = password.getText().toString();
            int check = checkLoginFields(user, pass);
            if(check > 0){
                Toast warning = Toast.makeText(LoginActivity.this, MISSING_INPUT_WARNING[check], Toast.LENGTH_SHORT);
                warning.show();
            }
            else{
                if(checkLogin(user,pass)){
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast result = Toast.makeText(LoginActivity.this,"Sai thông tin tài khoản và mất khẩu", Toast.LENGTH_LONG);
                    result.show();
                }
            }
        });
        txtRegis.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });

    }
    public int checkLoginFields(String username, String password){
        if(username.isBlank() && password.isBlank()){
            return 2;
        }
        else if (username.isBlank()){
            return 0;
        } else if (password.isBlank()) {
            return 1;
        }
        else {
            return -1;
        }

    }
    public boolean checkLogin(String username, String password){
        SQLiteHelper sqLiteHelper = new SQLiteHelper(LoginActivity.this);
        User user = sqLiteHelper.getUser(username);
        return password.equals(user.getPassword());
    }
}