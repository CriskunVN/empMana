/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author CrisKun
 */
public abstract class NhanVien {

    protected String cmnd;
    protected String hoTen;
    protected String phongBan;
    protected String ngayVaoLam;

    public NhanVien(String cmnd, String hoTen, String phongBan, String ngayVaoLam) {
        this.cmnd = cmnd;
        this.hoTen = hoTen;
        this.phongBan = phongBan;
        this.ngayVaoLam = ngayVaoLam;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }

    public String getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(String ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "cmnd=" + cmnd + ", hoTen=" + hoTen + ", phongBan=" + phongBan + ", ngayVaoLam="
                + ngayVaoLam + '}';
    }

    public int getYear() {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cld = Calendar.getInstance();
        int year = 0;
        try {
            Date date = df.parse(ngayVaoLam);
            cld.setTime(date);
            year = cld.get(Calendar.YEAR);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return year;
    }

    public static int getYearNow() {
        Date date = new Date();
        Calendar cld = Calendar.getInstance();
        cld.setTime(date);
        int yearNow = cld.get(Calendar.YEAR);
        return yearNow;
    }

    public static Date getTimeNow() {
        Date date = new Date();
        Calendar cld = Calendar.getInstance();
        cld.setTime(date);
        Date now = cld.getTime();
        return now;
    }

    public abstract double tinhPhuCap();

    public abstract double tinhLuong();

    public abstract void showProfile();

    public abstract String GroupName();
}
