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
public class NVBienChe extends NhanVien{
    private String nameG = "Biên Chế";
    private double heSoLuong;
    private double phuCap = 200000;
    public NVBienChe(String cmnd, String hoTen, String phongBan, String ngayVaoLam, double heSoLuong) {
        super(cmnd, hoTen, phongBan, ngayVaoLam);
        this.heSoLuong = heSoLuong;
    }

    public String getNameG() {
        return nameG;
    }
    
    @Override
    public double tinhPhuCap() {
        
        return (getYearNow()-getYear())*phuCap;
       
    }

    @Override
    public double tinhLuong() {
        return (long)115000000*(double)(phuCap+heSoLuong);
    }

    @Override
    public void showProfile() {
        System.out.printf("|%10s|%20s|%10s|%10s|%4.3f|",cmnd,hoTen,phongBan,ngayVaoLam,heSoLuong);
    }

    @Override
    public String GroupName() {
        return getNameG();
    }
    
}
