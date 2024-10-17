package common;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExceptionHandler {
    private final static Scanner sc = new Scanner(System.in);

    // Kiểm tra kiểu dữ liệu số nguyên
    public static int checkParseInt(){
        int value;
        while (true){
            try {
                value = Integer.parseInt(sc.nextLine());
                return value;
            }catch (NumberFormatException e){
                System.out.println("Nhap lai");
            }
        }
    }
    // Kiểm tra kiểu dữ liệu double
    public static int checkParseDouble(){
        int value;
        while (true){
            try {
                value = (int) Double.parseDouble(sc.nextLine());
                return value;
            }catch (NumberFormatException e){
                System.out.println("Nhập lại :");
            }
        }
    }
    //Kiểm tra ngày tháng năm
    public static LocalDate checkParseLocaDate(){
        LocalDate date = null;
        while (date == null) {
//            System.out.println("Nhập ngày (yyyy-MM-dd):");
            String input = sc.nextLine();
            try {
                date = LocalDate.parse(input);
            } catch (DateTimeParseException e ) {
                System.out.println("Định dạng ngày không hợp lệ. Vui lòng nhập theo định dạng yyyy-MM-dd.");
            }
        }
        return date;
    }
    public static void checkEmail(String email){
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
//        while (true) {
        try {
            if (matcher.matches()) {
                System.out.println("Email hợp lệ : " + email);
            } else {
                throw new IllegalArgumentException("Email không đúng định dạng");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi nhập lại : " );
        }
//        }
    }
    public static int CheckAge(){
        int value ;
        while (true){
            try {
                value= sc.nextInt();
                if (value > 18 ){
                    return value;
                }else {
                    System.out.println("Phải lớn hơn 18 tuổi " );
                }
            }catch (InputMismatchException e){
                System.out.println("Nhập lại ");
            }
        }
    }



}
