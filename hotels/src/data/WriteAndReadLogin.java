package data;

import model.Login;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteAndReadLogin {
    private File file = new File("C:\\CodeGym\\CaseStudy2\\hotels\\src\\users.csv");
    private static String currentuserName;
    private static String currentName;
    private static int currentAge;
    private static String currentPhone;

    // Phương thức ghi danh sách Login vào tệp CSV
    public void writeToFile(List<Login> loginList) {
        try (FileWriter fw = new FileWriter(this.file, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            for (Login login : loginList) {
                bw.write(login.getUserName() + "," +
                        login.getPassWord() + "," +
                        login.getPhone() + "," +
                        login.getAddress() + "," +
                        login.getEmail() + "," +
                        login.getName() + "," +
                        login.getAge());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

      public List<Login> readFromFile() {
        List<Login> loginList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(this.file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userInfo = line.split(",");
                if (userInfo.length == 7) {
                    Login login = new Login(
                            userInfo[0],
                            userInfo[1],
                            userInfo[2],
                            userInfo[3],
                            userInfo[4],
                            userInfo[5],
                            Integer.parseInt(userInfo[6])
                    );
                    loginList.add(login);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return loginList;
    }


    public boolean verifyLogin(String userName, String passWord) {
        List<Login> loginList = readFromFile();
        for (Login login : loginList) {
            if (login.getUserName().equals(userName) && login.getPassWord().equals(passWord)) {
                currentuserName = login.getUserName();
                currentName = login.getName();
                currentAge = login.getAge();
                currentPhone = login.getPhone();
                return true;
            }
        }
        return false;
    }

    public static void showAllAccount() {
        if (currentuserName != null) {
            System.out.println("=========THÔNG TIN TÀI KHOẢN===========");
            System.out.println("Họ tên của người dùng là: " + currentName);
            System.out.println("Tài khoản người dùng là: " + currentuserName);
            System.out.println("Tuổi của người dùng là: " + currentAge);
            System.out.println("Số điện thoại của người dùng là: " + currentPhone);
        } else {
            System.out.println("Không có người dùng nào đang đăng nhập.");
        }
    }
}
