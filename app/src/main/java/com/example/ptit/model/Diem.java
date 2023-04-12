package com.example.ptit.model;

public class Diem {
    private int dId;
    private String MaMon;
    private String TenMon;
    private int TC;
    private int ptCC;
    private int ptKT;
    private int ptTH;
    private int ptBT;
    private int ptThi;
    private int CC;
    private int KT;
    private int TH;
    private int BT;
    private int ThiL1;
    private int ThiL2;
    private int TK10;
    private int TKChu;
    private String KQ;

    public Diem(int dId, String maMon, String tenMon,
                int TC, int ptCC, int ptKT, int ptTH,
                int ptBT, int ptThi, int CC, int KT,
                int TH, int BT, int thiL1, int thiL2,
                int TK10, int TKChu, String KQ) {
        this.dId = dId;
        MaMon = maMon;
        TenMon = tenMon;
        this.TC = TC;
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
    }

    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }

    public String getMaMon() {
        return MaMon;
    }

    public void setMaMon(String maMon) {
        MaMon = maMon;
    }

    public String getTenMon() {
        return TenMon;
    }

    public void setTenMon(String tenMon) {
        TenMon = tenMon;
    }

    public int getTC() {
        return TC;
    }

    public void setTC(int TC) {
        this.TC = TC;
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

    public int getCC() {
        return CC;
    }

    public void setCC(int CC) {
        this.CC = CC;
    }

    public int getKT() {
        return KT;
    }

    public void setKT(int KT) {
        this.KT = KT;
    }

    public int getTH() {
        return TH;
    }

    public void setTH(int TH) {
        this.TH = TH;
    }

    public int getBT() {
        return BT;
    }

    public void setBT(int BT) {
        this.BT = BT;
    }

    public int getThiL1() {
        return ThiL1;
    }

    public void setThiL1(int thiL1) {
        ThiL1 = thiL1;
    }

    public int getThiL2() {
        return ThiL2;
    }

    public void setThiL2(int thiL2) {
        ThiL2 = thiL2;
    }

    public int getTK10() {
        return TK10;
    }

    public void setTK10(int TK10) {
        this.TK10 = TK10;
    }

    public int getTKChu() {
        return TKChu;
    }

    public void setTKChu(int TKChu) {
        this.TKChu = TKChu;
    }

    public String getKQ() {
        return KQ;
    }

    public void setKQ(String KQ) {
        this.KQ = KQ;
    }
}
