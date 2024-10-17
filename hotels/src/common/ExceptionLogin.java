package common;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ExceptionLogin {
    public static String checkPassWord(){
        Scanner sc = new Scanner(System.in);
        String passWord;
        boolean isValid;

        do {
            isValid = true;
            passWord = sc.nextLine();

            if (passWord.length() < 8) {
                System.out.println("Mật khẩu phải trên 8 kí tự");
                isValid = false;
            } else if (!passWord.matches(".*[A-Z].*")) {
                System.out.println("Mật khẩu phải chứa ít nhất một ký tự viết hoa");
                isValid = false;
            }

        } while (!isValid);

        System.out.println("Mật khẩu hợp lệ.");
        return passWord;
    }
    public static boolean isVaildPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("\\d{10,11}");
    }
    public static String checkPhoneNumber() {
        Scanner sc = new Scanner(System.in);
        String phoneNumber;
        boolean isValid;

        do {
            phoneNumber = sc.nextLine();
            isValid = isVaildPhoneNumber(phoneNumber);
            if (!isValid) {
                System.out.println("Số điện thoại không hợp lệ. Vui lòng nhập lại.");
            }

        } while (!isValid);

        System.out.println("Số điện thoại hợp lệ.");
        return phoneNumber;
    }

    public static boolean isVaildEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        return Pattern.matches(emailRegex, email);
    }

    public static String checkEmail() {
        Scanner sc = new Scanner(System.in);
        String email;
        boolean isValid;

        do {

            email = sc.nextLine();

            isValid = isVaildEmail(email);
            if (!isValid) {
                System.out.println("Địa chỉ email không hợp lệ. Vui lòng nhập lại.");
            }

        } while (!isValid);

        System.out.println("Địa chỉ email hợp lệ.");
        return email;
    }
}
