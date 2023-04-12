package com.example.ptit.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.ptit.model.User;

public class SQLiteHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "saq";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "users";

    private static final String KEY_ID = "uid";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";

    public SQLiteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
                String sql = "CREATE TABLE users(" +
                "uid INTEGER PRIMARY KEY AUTOINCREMENT," +
                "user TEXT," +
                "password TEXT" + ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_students_table = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        db.execSQL(drop_students_table);

        onCreate(db);
    }
    public void addUser(User user){
        String sql = "INSERT INTO users(user,password) values(?,?)";
        String[] args = {user.getUsername(),user.getPassword()};
        SQLiteDatabase statement = getWritableDatabase();
        statement.execSQL(sql, args);
    }
    public User getUser(String  username){
        String []args = {username};
        SQLiteDatabase statement = this.getWritableDatabase();
        Cursor cursor = statement.rawQuery("SELECT * FROM users WHERE user = ?",args);
        try {
            if (cursor != null && cursor.moveToFirst()) {
                User user = new User(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
                return user;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        User user1 = new User();
        return user1;
    }
}