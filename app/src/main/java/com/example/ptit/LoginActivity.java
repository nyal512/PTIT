package com.example.ptit;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ptit.Database.SQLiteHelper;
import com.example.ptit.model.User;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    private TextInputEditText username, password;
    Button btnLogin;
    TextView txtRegis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.editUser);
        password = findViewById(R.id.editPassword);
        btnLogin = findViewById(R.id.btnLogin);
        txtRegis = findViewById(R.id.txtRegis);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if(user.isEmpty()){
                    Toast toast = Toast.makeText(LoginActivity.this, "Vui lòng nhập tên đăng nhập", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if(pass.isEmpty()){
                    Toast toast = Toast.makeText(LoginActivity.this, "Vui lòng nhập mật khẩu", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    SQLiteHelper sqLiteHelper = new SQLiteHelper(LoginActivity.this);
                    User users = sqLiteHelper.getUser(user);
                    System.out.println("user: "+users.getUsername());
                    System.out.println("pass: "+users.getPassword());
                    if(users.getUsername()==null){
                        Toast toast = Toast.makeText(LoginActivity.this, "Tên đăng nhập không tồn tại", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    else if(users.getPassword().equals(pass)){
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast toast = Toast.makeText(LoginActivity.this, "Mật khẩu không đúng", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
            }
        });
        txtRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}