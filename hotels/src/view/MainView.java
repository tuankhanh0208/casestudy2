package view;

import common.ExceptionHandler;
import data.WriteAndReadLogin;

public class MainView {
//    private Scanner sc = new Scanner(System.in);
//    private Scanner scString = new Scanner(System.in);
    private RoomView roomView = new RoomView();
    private BillView billView= new BillView();
    int choice;

    public void renderMenu(){
        mainMenu();
    }

    public void mainMenu(){
        do {
            System.out.println("======SHOW HOTEL======");
            System.out.println("1.Quản lí phòng khách sạn");
            System.out.println("2.Quản lí hóa đơn");
            System.out.println("3.Xem thông tin tài khoản");
            System.out.println("0.Thoát");
            System.out.print("Nhập lựa chọn của bạn:");
            choice = ExceptionHandler.checkParseInt();
            switch (choice) {
                case 1:
                    roomView.renderRoom();
                    break;
                case 2:
                    billView.renderBill();
                    break;
                case 3:
                    showAllCurrent();
                    break;
                case 0:
                    System.out.println("=======THOAT========");
                    break;
                default:
                    System.out.println("Vui long nhap lai");
            }
        } while (choice !=0);
    }

    private void showAllCurrent() {
        System.out.println("Danh sách tài khoản của bạn ");
        WriteAndReadLogin.showAllAccount();
    }




}
