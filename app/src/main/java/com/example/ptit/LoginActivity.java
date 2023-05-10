package com.example.ptit;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ptit.Database.PointDB;
import com.example.ptit.Database.UserDB;
import com.example.ptit.model.Point;
import com.example.ptit.model.User;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {
    private TextInputEditText username, password;
    Button btnLogin, btnAdd;
    TextView txtRegis;
    PointDB pointDB;
    private Point point1, point2, point3;

    private final String[] MISSING_INPUT_WARNING = {"Vui lòng nhập tên đăng nhập", "Vui lòng nhập mật khẩu", "Vui lòng nhập username và password"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.editUser);
        password = findViewById(R.id.editPassword);
        btnLogin = findViewById(R.id.btnLogin);
        txtRegis = findViewById(R.id.txtRegis);
        btnAdd = findViewById(R.id.btnAddPoint);
        pointDB = new PointDB(getBaseContext());
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
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                point1 = new Point(3, "INT1340", "Nhập môn công nghệ phần mềm", 3, 10, 20, 0, 20, 50, 8.0F,
                        7.0F, 0.0F, 7.7F, 4.5F, 0.0F, 6.0F, "C", "Đạt", 1);
                point2 = new Point(3, "INT1341", "Nhập môn trí tuệ nhân tạo", 3, 10, 10, 0, 10, 70, 10.0F,
                        4.0F, 0.0F, 5.0F, 8.0F, 0.0F, 7.5F, "B", "Đạt", 1);
                point3 = new Point(3, "INT1303", "An toàn và bảo mật hệ thống thông tin", 3, 10, 10, 0, 20, 10, 10.0F,
                        8.0F, 0.0F, 8.0F, 7.5F, 0.0F, 7.9F, "B", "Đạt", 1);
                Point point5 = new Point(3, "INT1434", "Lập trình Web", 3, 10, 20, 20, 0, 50, 8.0F,
                        7.0F, 7.0F, 0.0F, 1.0F, 0.0F, 4.1F, "D", "Đạt", 1);
                Point point6 = new Point(3, "INT14148", "Cơ sở dữ liệu phân tán", 3, 10, 10, 0, 20, 60, 9.0F,
                        8.3F, 0.0F, 6.2F, 5.8F, 0.0F, 6.5F, "C+", "Đạt", 1);
                Point point7 = new Point(3, "INT13147", "Thực tập cơ sở", 3, 10, 20, 20, 0, 50, 10.0F,
                        8.0F, 9.0F, 0.0F, 8.0F, 0.0F, 8.4F, "B+", "Đạt", 1);
                pointDB.addPoint(point1);
                pointDB.addPoint(point2);
                pointDB.addPoint(point3);
                pointDB.addPoint(point5);
                pointDB.addPoint(point6);
                pointDB.addPoint(point7);
//                pointDB.onUpgrade(pointDB.getReadableDatabase(),1, 2);
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
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
        UserDB sqLiteHelper = new UserDB(LoginActivity.this);
        User user = sqLiteHelper.getUser(username);
        return password.equals(user.getPassword());
    }
}