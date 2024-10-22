package view;

import common.ExceptionHandler;
import common.ExceptionLogin;
import data.WriteAndReadLogin;
import model.Login;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginView {
    private static Scanner sc = new Scanner(System.in);
    private MainView personView = new MainView();
    private WriteAndReadLogin writeAndReadLogin = new WriteAndReadLogin();
    private List<Login> loginList;

    public LoginView() {
        this.loginList = writeAndReadLogin.readFromFile();
    }

    int choice;

    public void showLogin() {
        do {
            System.out.println("====== ĐĂNG KÍ HOẶC ĐĂNG NHẬP ======");
            System.out.println("1. Đăng nhập");
            System.out.println("2. Đăng kí");
            System.out.println("0. Thoát");
            System.out.printf("Nhập lựa chọn của bạn: ");
            choice = ExceptionHandler.checkParseInt();
            switch (choice) {
                case 1:
                    showAllLogin();
                    break;
                case 2:
                    showAllSignUp();
                    break;
                case 0:
                    System.out.println("========= THOÁT =========");
                    break;
                default:
                    System.out.println("Vui lòng nhập lại");
                    break;
            }
        } while (choice != 0);
    }

    private void showAllLogin() {
        System.out.println("========== ĐĂNG NHẬP ===========");

        String userName;
        do {
            System.out.println("Nhập tài khoản:");
            userName =sc.nextLine().toLowerCase();
            if (userName.isEmpty()){
                System.out.println("Tài khoản bắt buộc phải nhập.");
            }
        }while (userName.isEmpty());

        String passWord;
        do {
            System.out.println("Nhập mật khẩu:");
            passWord = sc.nextLine();
            if (passWord.isEmpty()){
                System.out.println("Vui lòng nhập mật khẩu.");
            }
        }while (passWord.isEmpty());

        // Kiểm tra thông tin đăng nhập
        if (!writeAndReadLogin.verifyLogin(userName, passWord)) {
            System.out.println("Sai tài khoản hoặc mật khẩu");
        } else {
            System.out.println("Đăng nhập thành công!");
            personView.renderMenu();
        }
    }

    private void showAllSignUp() {
        System.out.println("========= ĐĂNG KÍ ===========");
        System.out.println("Nhập tài khoản:");
        String userName = sc.nextLine().toLowerCase();

        for (Login login : loginList) {
            if (login.getUserName().equals(userName)) {
                System.out.println("Tài khoản đã tồn tại. Vui lòng nhập tài khoản khác.");
                return;
            }
        }

        System.out.println("Nhập mật khẩu:");
        String passWord = ExceptionLogin.checkPassWord();

        System.out.printf("Nhập số điện thoại:");
        String phone = ExceptionLogin.checkPhoneNumber();

        String address ;
        do {
            System.out.println("Nhập nơi ở:");
            address = sc.nextLine();
            if (address.isEmpty()){
                System.out.println("Nơi ở không được bor trống vui lòng nhập lai");
            }
        }while (address.isEmpty());


        System.out.println("Nhập email:");
        String email = ExceptionLogin.checkEmail();

        String name;
        do {
            System.out.println("Nhập tên:");
            name = sc.nextLine();
            if (name.isEmpty()){
                System.out.println("Tên không được bỏ trống. Vui lòng nhập lại. ");
            }
        }while (name.isEmpty());

        System.out.println("Nhập tuổi:");
        int age = ExceptionHandler.CheckAge();

        Login newLogin = new Login(userName, passWord, phone, address, email, name, age);

        List<Login> newLoginList = new ArrayList<>();
        newLoginList.add(newLogin);
        writeAndReadLogin.writeToFile(newLoginList);

        System.out.println("Đăng kí thành công!");
    }
}
