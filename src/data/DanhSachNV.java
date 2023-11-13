/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author CrisKun
 */
public class DanhSachNV {
    

    private ArrayList<NhanVien> list = new ArrayList();
    private Scanner sc = new Scanner(System.in);

    public void adđNVHopDong() {
        String cmnd, hoTen, phongBan, ngayVaoLam;
        int tongGioLam;
        double tienCong1h;
        System.out.print("Nhập CMND : ");
        cmnd = sc.nextLine().trim();
        
        System.out.print("Nhập họ tên : ");
        hoTen = sc.nextLine().toUpperCase();
        
        System.out.print("Nhập phòng ban : ");
        phongBan = sc.nextLine().trim().toUpperCase();
        
        while (true) {
            try {
                System.out.print("Nhập ngày vào làm (dd/MM/yyyy)");
                ngayVaoLam = sc.nextLine();
                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                df.setLenient(false);
                Date d = df.parse(ngayVaoLam);
                
                Date now = NhanVien.getTimeNow();
                if(d.after(now)){
                  throw new Exception("Sai ngày tháng năm");
                }
                
                break;
            } catch (Exception e) {
                System.out.println("Định dạng không hợp lệ , Vui lòng nhập chuẩn (dd/MM/yyyy)");
            }
        }
        System.out.print("Nhập tổng giờ làm : ");
        tongGioLam = Integer.parseInt(sc.nextLine());
        
        System.out.print("Nhập lương 1 giờ : ");
        tienCong1h = Double.parseDouble(sc.nextLine());
        list.add(new NVHopDong(cmnd, hoTen, phongBan, ngayVaoLam, tongGioLam, tienCong1h));
        System.out.println("Thêm Nhân Viên Hợp Đồng Thành Công");
    }
    public void addNVBienChe() {
        String cmnd, hoTen, phongBan, ngayVaoLam;
   
        double heSoLuong;
        System.out.print("Nhập CMND : ");
        cmnd = sc.nextLine().trim();
        
        System.out.print("Nhập Họ Tên:");
        hoTen = sc.nextLine().toUpperCase();
        
        System.out.print("Nhập Phòng Ban:");
        phongBan = sc.nextLine().trim().toUpperCase();
        
        // nhập ngày chuẩn format dd/MM/yyyy
       while (true) {
            try {
                System.out.print("Nhập ngày vào làm (dd/MM/yyyy)");
                ngayVaoLam = sc.nextLine();
                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                df.setLenient(false);
                Date d = df.parse(ngayVaoLam);
                
                Date now = NhanVien.getTimeNow();
                if(d.after(now)){
                  throw new Exception("Sai ngày tháng năm");
                }
                
                break;
            } catch (Exception e) {
                System.out.println("Định dạng không hợp lệ , Vui lòng nhập chuẩn (dd/MM/yyyy)");
            }
        }
        System.out.print("Nhập hệ số lương : ");
        heSoLuong = Double.parseDouble(sc.nextLine());
        list.add(new NVBienChe(cmnd, hoTen, phongBan, ngayVaoLam, heSoLuong));
        System.out.println("Thêm Nhân Viên Biên Chế Thành Công");
    }
    
    public void showList() {
        if (list.isEmpty()) {
            System.out.println("Employees List");
        } else {
            System.out.println("The Employees List #" + (list.size() + 1));
            for (NhanVien x : list) {
                x.showProfile();
            }
        }
    }
    
    public NhanVien checkCMND(String ID) {
        if(list.isEmpty()) {
            System.out.println("Danh Sách Trống");
            return null;
        }
        
        for (NhanVien x : list) {
            if(x.getCmnd().equalsIgnoreCase(ID)) {
                return x;
            }
        }
        return null;
    }
    public void removeAEmp() {
        String cmnd;
        System.out.print("Nhập CMND Nhân Viên cần xóa : ");
        cmnd = sc.nextLine().trim().toUpperCase();
        NhanVien xxx = checkCMND(cmnd);
        if (xxx == null) {
            System.out.println("Không tìm thấy Nhân viên có CMND " + cmnd);
        }
        else {
            list.remove(xxx);
            System.out.println("Nhân Viên đã được xóa Thành Công");
            showList();
        }
    }
    
    
     public void searchAEmp() {
         String cmnd;
         System.out.println("Nhập CMND Nhân viên cần tìm:");
         cmnd = sc.nextLine().trim().toUpperCase();
         NhanVien xxx = checkCMND(cmnd);
         if(xxx == null) {
               System.out.println("Không tìm thấy Nhân viên có CMND " + cmnd);
         }
         else {
             System.out.println("Đã tìm thấy Nhân Viên có CMND " + cmnd);
             xxx.showProfile();
         }
     }
     
     
     public void tongLuongTraNhanVien() {
         double sum = 0;
         for (NhanVien x : list) {
             sum += x.tinhLuong();
         }
         System.out.println("Tổng lương phải trả cho nhân viên : " + sum);
     }
     
     
     public void nhanVienTopLuong() {
         double min = 0;
         int index = 0;
         for (NhanVien x : list) {
             if (x.tinhLuong() > min) {
                 min = x.tinhLuong();
                 index++;
             }
         }
          list.get(index).showProfile();
          System.out.print("Lương : " + list.get(index).tinhLuong() );
     }
     
     
     public ArrayList checkGroupNhanVien(String nameG) {
         if (list.isEmpty()) {
             System.out.println("Danh Sách Trống");
             return null;
         }
         ArrayList<NhanVien> listG = new ArrayList<>();
         for (NhanVien x : list) {
             if(x.GroupName().toUpperCase().equalsIgnoreCase(nameG)) {
                 listG.add(x);
             }
         }
         return listG;
     }
     public void groupNhanVien() {
         String nameG;
         System.out.print("Nhập Tên Nhóm Nhân Viên (BC or HD) : ");
         nameG = sc.nextLine().trim().toUpperCase();
         ArrayList<NhanVien> xxx = checkGroupNhanVien(nameG);
         if (xxx.isEmpty()) {
             System.out.println("Không tìm thấy Nhóm Nhân Viên " + nameG);
         }
         else {
             System.out.println("Đã tìm thấy ");
             for (NhanVien x : xxx) {
                 x.showProfile();
             }
         }
     }
     public List checkYearStartWork(int yearCheck) {
         if(list.isEmpty()) {
             System.out.println("Danh Sách Rỗng");
             return null;
         }
         ArrayList<NhanVien> listEmpYearStartWork = new ArrayList<>();
         for (NhanVien x : list) {
             if(x.getYear() == yearCheck) {
                 listEmpYearStartWork.add(x);
             }
         }
         return listEmpYearStartWork;
     }
     public void searchListEmp_YearStartWork() {
         int year;
         System.out.print("Nhập Năm Cần tìm : ");
         year = Integer.parseInt(sc.nextLine());
         List<NhanVien> xxx = checkYearStartWork(year);
         if (xxx == null)
         {
             System.out.println("Không tìm thấy");
         }
         else {
             System.out.println("ĐÃ TÌM THẤY ");
             for (NhanVien x : xxx) {
                 x.showProfile();
             }
         }
     }
     public void updateNhanVien() {
         String cmnd;
         System.out.print("Nhập CMND Nhân Viên Cần Tìm :");
         cmnd = sc.nextLine().trim().toUpperCase();
         NhanVien xxx = checkCMND(cmnd);
         if(xxx == null) {
             System.out.println("Không tìm thấy ");
         }
         else {
             System.out.println("Đã tìm Thấy");
             xxx.showProfile();
             System.out.println("%100 Bắt Đầu Cập Nhật Profile");
             String id, name , phongBan , ngayVaoLam;
             
             System.out.printf("Nhập CMND : ");
             id = sc.nextLine().trim().toUpperCase();
             xxx.setCmnd(id);
             
             System.out.printf("Nhập tên mới : ");
             name = sc.nextLine().toUpperCase();
             xxx.setHoTen(name);
             
             System.out.print("Nhập Phòng ban mới :");
             phongBan = sc.nextLine();
             xxx.setPhongBan(phongBan);
             
            while (true) {
            try {
                System.out.print("Nhập ngày vào làm (dd/MM/yyyy)");
                ngayVaoLam = sc.nextLine();
                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                df.setLenient(false);
                Date d = df.parse(ngayVaoLam);
                
                Date now = NhanVien.getTimeNow();
                if(d.after(now)){
                  throw new Exception("Sai ngày tháng năm");
                }
                
                break;
            } catch (Exception e) {
                System.out.println("Định dạng không hợp lệ , Vui lòng nhập chuẩn (dd/MM/yyyy)");
            }
        }
        
            
        
         }
     }
    
}
