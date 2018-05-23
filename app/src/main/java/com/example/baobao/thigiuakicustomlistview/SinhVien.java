package com.example.baobao.thigiuakicustomlistview;

/**
 * Created by BaoBao on 4/15/2018.
 */

public class SinhVien {
    private String key;
    private String hoten;
    private String sdt;
    private String diachi;

    public SinhVien() {

    }

    public SinhVien(String key, String hoten, String sdt, String diachi) {
        this.key = key;
        this.hoten = hoten;
        this.sdt = sdt;
        this.diachi = diachi;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
}
