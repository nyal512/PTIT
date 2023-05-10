package com.example.ptit.Database;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.ptit.model.Point;

import java.util.ArrayList;
import java.util.List;

public class PointDB extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "saq";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "points";

    private static final String KEY_PID = "pid";
    private static final String KEY_HOCKY = "HocKy";
    private static final String KEY_subjectCode = "subjectCode";
    private static final String KEY_subjectName = "subjectName";
    private static final String KEY_credits = "credits";
    private static final String KEY_ptCC = "ptCC";
    private static final String KEY_ptKT = "ptKT";
    private static final String KEY_ptTH = "ptTH";
    private static final String KEY_ptBT = "ptBT";
    private static final String KEY_ptThi = "ptThi";
    private static final String KEY_CC = "CC";
    private static final String KEY_KT = "KT";
    private static final String KEY_TH = "TH";
    private static final String KEY_BT = "BT";
    private static final String KEY_ThiL1 = "ThiL1";
    private static final String KEY_ThiL2 = "ThiL2";
    private static final String KEY_TK10 = "TK10";
    private static final String KEY_TKChu = "TKChu";
    private static final String KEY_KQ = "KQ";
    private static final String KEY_UID = "uid";
    public PointDB(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE points(" +
                "pid INTEGER PRIMARY KEY AUTOINCREMENT," +
                "HocKy INTEGER," +
                "subjectCode TEXT," +
                "subjectName TEXT," +
                "credits INTEGER," +
                "ptCC INTEGER," +
                "ptKT INTEGER," +
                "ptTH INTEGER," +
                "ptBT INTEGER," +
                "ptThi INTEGER," +
                "CC FLOAT," +
                "KT FLOAT," +
                "TH FLOAT," +
                "BT FLOAT," +
                "ThiL1 FLOAT," +
                "ThiL2 FLOAT," +
                "TK10 FLOAT," +
                "TKChu TEXT," +
                "KQ TEXT," +
                "uid INTEGER,"
                + "FOREIGN KEY(uid) REFERENCES users(uid));";
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_students_table = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        db.execSQL(drop_students_table);
        onCreate(db);
    }
    public void addPoint(Point point){
        String sql = "INSERT INTO points(HocKy, subjectCode, subjectName, credits, " +
                "ptCC, ptKT, ptTH, ptBT, ptThi, CC, KT, TH, BT," +
                "ThiL1, ThiL2, TK10, TKChu, KQ, uid) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String[] args = {String.valueOf(point.getHocKy()),
                String.valueOf(point.getSubjectCode()),
                String.valueOf(point.getSubjectName()),
                String.valueOf(point.getCredits()),
                String.valueOf(point.getPtCC()),
                String.valueOf(point.getPtKT()),
                String.valueOf(point.getPtTH()),
                String.valueOf(point.getPtBT()),
                String.valueOf(point.getPtThi()),
                String.valueOf(point.getCC()),
                String.valueOf(point.getKT()),
                String.valueOf(point.getTH()),
                String.valueOf(point.getBT()),
                String.valueOf(point.getThiL1()),
                String.valueOf(point.getThiL2()),
                String.valueOf(point.getTK10()),
                String.valueOf(point.getTKChu()),
                String.valueOf(point.getKQ()),
                String.valueOf(point.getUid())};
        SQLiteDatabase statement = getWritableDatabase();
        statement.execSQL(sql, args);
    }
    @SuppressLint("Range")
    public List<Point> getPointBySemester(int hocky){
        List<Point> pointList =new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + KEY_HOCKY + "=" + hocky;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                Point point = new Point();
                point.setpId(cursor.getInt(cursor.getColumnIndex(KEY_PID)));
                point.setHocKy(cursor.getInt(cursor.getColumnIndex(KEY_HOCKY)));
                point.setSubjectCode(cursor.getString(cursor.getColumnIndex(KEY_subjectCode)));
                point.setSubjectName(cursor.getString(cursor.getColumnIndex(KEY_subjectName)));
                point.setCredits(cursor.getInt(cursor.getColumnIndex(KEY_credits)));
                point.setPtCC(cursor.getInt(cursor.getColumnIndex(KEY_ptCC)));
                point.setPtKT(cursor.getInt(cursor.getColumnIndex(KEY_ptKT)));
                point.setPtTH(cursor.getInt(cursor.getColumnIndex(KEY_ptTH)));
                point.setPtBT(cursor.getInt(cursor.getColumnIndex(KEY_ptBT)));
                point.setPtThi(cursor.getInt(cursor.getColumnIndex(KEY_ptThi)));
                point.setCC(cursor.getFloat(cursor.getColumnIndex(KEY_CC)));
                point.setKT(cursor.getFloat(cursor.getColumnIndex(KEY_KT)));
                point.setTH(cursor.getFloat(cursor.getColumnIndex(KEY_TH)));
                point.setBT(cursor.getFloat(cursor.getColumnIndex(KEY_BT)));
                point.setThiL1(cursor.getFloat(cursor.getColumnIndex(KEY_ThiL1)));
                point.setThiL2(cursor.getFloat(cursor.getColumnIndex(KEY_ThiL2)));
                point.setTK10(cursor.getFloat(cursor.getColumnIndex(KEY_TK10)));
                point.setTKChu(cursor.getString(cursor.getColumnIndex(KEY_TKChu)));
                point.setKQ(cursor.getString(cursor.getColumnIndex(KEY_KQ)));
                point.setUid(cursor.getInt(cursor.getColumnIndex(KEY_UID)));
                pointList.add(point);
            } while (cursor.moveToNext());
        }
        return pointList;
    }
    public int getMaxHocKy() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT MAX(HocKy) FROM points", null);
        int maxHocKy = 0;

        if (cursor.moveToFirst()) {
            maxHocKy = cursor.getInt(0);
        }

        cursor.close();
        db.close();

        return maxHocKy;
    }
}
