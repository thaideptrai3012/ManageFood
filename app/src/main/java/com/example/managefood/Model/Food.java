package com.example.managefood.Model;

public class Food {
    private String ma,ten,moTa ;
    private int gia,soLuong,hinhAnh;

    public Food() {
    }

    public Food(String ma, String ten, int gia, int soLuong, int hinhAnh,String moTa) {
        this.ma = ma;
        this.ten = ten;
        this.moTa = moTa;
        this.gia = gia;
        this.soLuong = soLuong;
        this.hinhAnh = hinhAnh;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
