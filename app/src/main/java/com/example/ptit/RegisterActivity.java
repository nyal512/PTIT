package com.example.ptit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ptit.Database.SQLiteHelper;
import com.example.ptit.model.User;

public class RegisterActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    Button btnRegister;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.addUser);
        password = findViewById(R.id.addPassword);
        String tmp = username.getText().toString();

        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User u = new User();
                u.setUsername(username.getText().toString());
                u.setPassword(password.getText().toString());
                if(u.getUsername().isEmpty()){
                    Toast toast = Toast.makeText(RegisterActivity.this, "vui lòng nhập tên đăng nhập", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if(u.getPassword().isEmpty()){
                    Toast toast = Toast.makeText(RegisterActivity.this, "vui lòng nhập mật khẩu", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if(u.getUsername().length()<4){
                    Toast toast = Toast.makeText(RegisterActivity.this, "tên đăng nhập không phù hợp", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if(u.getPassword().length()<3){
                    Toast toast = Toast.makeText(RegisterActivity.this,"mật khẩu quá ngắn", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    SQLiteHelper sqLiteHelper=new SQLiteHelper(RegisterActivity.this);
                    sqLiteHelper.addUser(u);
                    Toast toast = Toast.makeText(RegisterActivity.this,"đăng ký thành công" ,Toast.LENGTH_SHORT);
                    toast.show();
                    Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}