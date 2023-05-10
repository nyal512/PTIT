package com.example.ptit;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ptit.Database.UserDB;
import com.example.ptit.model.User;

public class RegisterActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.addUser);
        password = findViewById(R.id.addPassword);

        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(v -> onClickRegister());
    }

    public void onClickRegister() {
        User u = new User();
        u.setUsername(username.getText().toString());
        u.setPassword(password.getText().toString());

        int fieldCheck = checkRegistrationFields(u.getUsername(), u.getPassword());

        if (fieldCheck == 0) {
            Toast.makeText(RegisterActivity.this, "Vui lòng nhập tên đăng nhập", Toast.LENGTH_SHORT).show();
        } else if (fieldCheck == 1) {
            Toast.makeText(RegisterActivity.this, "Vui lòng nhập mật khẩu", Toast.LENGTH_SHORT).show();
        } else if (fieldCheck == 2) {
            Toast.makeText(RegisterActivity.this, "Tên đăng nhập không phù hợp", Toast.LENGTH_SHORT).show();
        } else if (fieldCheck == 3) {
            Toast.makeText(RegisterActivity.this, "Mật khẩu quá ngắn", Toast.LENGTH_SHORT).show();
        } else {
            UserDB userDB = new UserDB(RegisterActivity.this);
            userDB.addUser(u);
            Toast.makeText(RegisterActivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }

    public int checkRegistrationFields(String username, String password) {
        if (username.isEmpty()) {
            return 0;
        } else if (password.isEmpty()) {
            return 1;
        } else if (username.length() < 4) {
            return 2;
        } else if (password.length() < 3) {
            return 3;
        } else {
            return -1;
        }
    }
}
