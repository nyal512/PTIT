package com.example.ptit.model;

public class Point {
    private int pId;
    private int HocKy;
    private String subjectCode;
    private String subjectName;
    private int credits;
    private int ptCC;
    private int ptKT;
    private int ptTH;
    private int ptBT;
    private int ptThi;
    private float CC;
    private float KT;
    private float TH;
    private float BT;
    private float ThiL1;
    private float ThiL2;
    private float TK10;
    private String TKChu;
    private String KQ;
    private int uid;

    public Point(int pId, int hocKy, String subjectCode, String subjectName,
                 int credits, int ptCC, int ptKT, int ptTH, int ptBT, int ptThi,
                 float CC, float KT, float TH, float BT, float thiL1, float thiL2,
                 float TK10, String TKChu, String KQ, int uid) {
        this.pId = pId;
        HocKy = hocKy;
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.credits = credits;
        this.ptCC = ptCC;
        this.ptKT = ptKT;
        this.ptTH = ptTH;
        this.ptBT = ptBT;
        this.ptThi = ptThi;
        this.CC = CC;
        this.KT = KT;
        this.TH = TH;
        this.BT = BT;
        ThiL1 = thiL1;
        ThiL2 = thiL2;
        this.TK10 = TK10;
        this.TKChu = TKChu;
        this.KQ = KQ;
        this.uid = uid;
    }

    public Point(int hocKy, String subjectCode, String subjectName,
                 int credits, int ptCC, int ptKT, int ptTH, int ptBT,
                 int ptThi, float CC, float KT, float TH, float BT,
                 float thiL1, float thiL2, float TK10, String TKChu,
                 String KQ, int uid) {
        HocKy = hocKy;
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.credits = credits;
        this.ptCC = ptCC;
        this.ptKT = ptKT;
        this.ptTH = ptTH;
        this.ptBT = ptBT;
        this.ptThi = ptThi;
        this.CC = CC;
        this.KT = KT;
        this.TH = TH;
        this.BT = BT;
        ThiL1 = thiL1;
        ThiL2 = thiL2;
        this.TK10 = TK10;
        this.TKChu = TKChu;
        this.KQ = KQ;
        this.uid = uid;
    }

    public Point() {
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public int getHocKy() {
        return HocKy;
    }

    public void setHocKy(int hocKy) {
        HocKy = hocKy;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getPtCC() {
        return ptCC;
    }

    public void setPtCC(int ptCC) {
        this.ptCC = ptCC;
    }

    public int getPtKT() {
        return ptKT;
    }

    public void setPtKT(int ptKT) {
        this.ptKT = ptKT;
    }

    public int getPtTH() {
        return ptTH;
    }

    public void setPtTH(int ptTH) {
        this.ptTH = ptTH;
    }

    public int getPtBT() {
        return ptBT;
    }

    public void setPtBT(int ptBT) {
        this.ptBT = ptBT;
    }

    public int getPtThi() {
        return ptThi;
    }

    public void setPtThi(int ptThi) {
        this.ptThi = ptThi;
    }

    public float getCC() {
        return CC;
    }

    public void setCC(float CC) {
        this.CC = CC;
    }

    public float getKT() {
        return KT;
    }

    public void setKT(float KT) {
        this.KT = KT;
    }

    public float getTH() {
        return TH;
    }

    public void setTH(float TH) {
        this.TH = TH;
    }

    public float getBT() {
        return BT;
    }

    public void setBT(float BT) {
        this.BT = BT;
    }

    public float getThiL1() {
        return ThiL1;
    }

    public void setThiL1(float thiL1) {
        ThiL1 = thiL1;
    }

    public float getThiL2() {
        return ThiL2;
    }

    public void setThiL2(float thiL2) {
        ThiL2 = thiL2;
    }

    public float getTK10() {
        return TK10;
    }

    public void setTK10(float TK10) {
        this.TK10 = TK10;
    }

    public String getTKChu() {
        return TKChu;
    }

    public void setTKChu(String TKChu) {
        this.TKChu = TKChu;
    }

    public String getKQ() {
        return KQ;
    }

    public void setKQ(String KQ) {
        this.KQ = KQ;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Point{" +
                "subjectCode='" + subjectCode + '\'' +
                '}';
    }
}
