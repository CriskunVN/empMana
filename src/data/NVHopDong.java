/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.Date;

/**
 *
 * @author CrisKun
 */
public class NVHopDong extends NhanVien {
    public String nameG = "hd";
    private int tongGioLam;
    private double tienCong1h;

    public NVHopDong(String cmnd, String hoTen, String phongBan, String ngayVaoLam, int tongGioLam, double tienCong1h) {
        super(cmnd, hoTen, phongBan, ngayVaoLam);
        this.tongGioLam = tongGioLam;
        this.tienCong1h = tienCong1h;
    }

    public String getNameG() {
        return nameG;
    }
    
    @Override
    public double tinhPhuCap() {
        if (tongGioLam > 170) {
            return 500.000;
        } else if (tongGioLam < 80) {
            return 0;
        } else {
            return 300.000;
        }
    }

    @Override
    public double tinhLuong() {
            return (tinhPhuCap()+tongGioLam)*tienCong1h;
    }

    @Override
    public void showProfile() {
        System.out.printf("|Nhân Viên Hợp Đồng|%10s|%20s|%10s|%10s|%5d|%4.3f|\n",cmnd,hoTen,phongBan,ngayVaoLam,tongGioLam,tienCong1h);

    }

    @Override
    public String GroupName() {
        return getNameG();
    }

}
