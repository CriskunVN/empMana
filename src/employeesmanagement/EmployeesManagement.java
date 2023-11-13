/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package employeesmanagement;

import data.DanhSachNV;
import data.NVBienChe;
import data.NhanVien;
import java.util.Scanner;

/**
 *
 * @author CrisKuna
 */
public class EmployeesManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DanhSachNV list = new DanhSachNV();
        int choice = 0;
        while(true) {
            menu();
            System.out.print("Nhập lựa chọn của bạn : ");
            choice = Integer.parseInt(sc.nextLine());
            
            OUTER:
            switch (choice) {
                case 1:
                    int choiceAdd = 0;
                    menuAddAEmp();
                    System.out.print("Nhập lựa chọn của bạn : ");
                    choiceAdd = Integer.parseInt(sc.nextLine());
                    switch (choiceAdd) {
                        case 1:
                            list.addNVBienChe();
                            break;
                        case 2:
                            list.adđNVHopDong();
                            break;
                        default:
                            System.out.print("Nhập không đúng");
                    }
                case 2:
                    list.showList();
                    break;
                case 3:
                    list.removeAEmp();
                    break;
                case 4:
                    list.searchAEmp();
                    break;
                case 5:
                    list.updateNhanVien();
                    break;
                case 6:
                    menuManagerment();
                    int choice2 = 0;
                    System.out.print("Nhập lựa chọn của bạn : ");
                    choice2 = Integer.parseInt(sc.nextLine());
                    switch (choice2) {
                        case 1:
                            list.tongLuongTraNhanVien();
                            break;
                        case 2:
                            list.nhanVienTopLuong();
                            break;
                        case 3:
                           list.groupNhanVien();
                            break;      
                        case 4:
                            list.searchListEmp_YearStartWork();
                            break;
                        default:
                            System.out.println("Erro");
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Vui lòng Nhập từ 1 - 6 ");
            }
        }
        
    }
    public static void menuManagerment() {
        System.out.println("1. Xuất tổng tiền lương cần trả");
        System.out.println("2. Xuất Nhân viên lương cao nhất");
        System.out.println("3. Xuất danh sách nhân viên theo loại nhân viên");
        System.out.println("4. Xuất danh sách nhân viên có năm làm việc ");
        
    }
    public static void menu() {
        System.out.println("===========Menu==========");
        System.out.println("1.Thêm nhân viên");
        System.out.println("2.Xuất danh sách Nhân viên");
        System.out.println("3.Xóa nhân viên");
        System.out.println("4.Tìm nhân viên bằng CMND");
        System.out.println("5.Cập nhật Nhân viên bằng CMND");
        System.out.println("6.Quản Lí Nhân Viên");
        System.out.println("0.Kết thúc");
    }
    public static void menuAddAEmp() {
        System.out.println("1. Thêm Nhân Viên Biên Chế");
        System.out.println("2. Thêm Nhân Viên Hợp Đồng");
    }
    
}
