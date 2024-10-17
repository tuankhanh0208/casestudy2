package view;

import common.ExceptionHandler;
import controller.BillController;
import model.Bill;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class BillView {
    private BillController billController = new BillController();
    private Scanner scString = new Scanner(System.in);
    int choice;

    public void renderBill(){
        showAllBill();
    }
    private void showAllBill() {
        do {
            System.out.println("======QUẢN LÍ HÓA ĐƠN KHÁCH SẠN=========");
            System.out.println("1.Tạo hóa đơn mới");
            System.out.println("2.Sửa hóa đơn ");
            System.out.println("3.Xem danh sách hóa đơn");
            System.out.println("4.Xem tổng thu nhập của tháng ");
            System.out.println("5.Xóa hóa đơn ");
            System.out.println("0.Quay lại menu chính");
            System.out.print("Nhập lựa chọn của bạn : ");
            choice = ExceptionHandler.checkParseInt();
            switch (choice){
                case 1:
                    showAddBills();
                    break;
                case 2:
                    showEditBills();
                    break;
                case 3:
                    showAllBills();
                    break;
                case 4:
                    showAllRevenueByMonth();
                    break;
                case 5:
                    showAllDeleteBills();
                    break;
                case 0:
                    System.out.println("Quay lại trang chủ");
                    break;
                default:
                    System.out.println("Nhập lại :");
            }
        }while (choice!=0);
    }

    private void showAllDeleteBills() {
        System.out.println("====XÓA HÓA ĐƠN====");
        int id;
        do {
            System.out.print("Nhập ID hóa đơn cần xóa (nhấn Enter để quay lại Menu): ");
            id = ExceptionHandler.checkParseInt();
            if (id == 0) {
                System.out.println("Quay lại Menu chính.");
                return;
            }
            Bill directory = (Bill) billController.searchBillById(id);
            if (directory != null) {
                System.out.println("Bạn có chắc muốn xóa hóa đơn với số ID " + id + " không? (Nhập 'Y' để xác nhận): ");
                String confirm = scString.nextLine();
                if (confirm.equalsIgnoreCase("Y")) {
                    billController.delete(id);
                    System.out.println("Hóa đơn với số ID " + id + " đã được xóa.");
                } else {
                    System.out.println("Hủy thao tác xóa. Quay lại Menu.");
                }
                return;
            } else {
                System.out.println("Không tìm thấy hóa đơn với số ID này. Vui lòng nhập lại.");
            }
        } while (true);

    }

    private void showAllRevenueByMonth() {

        System.out.println("Nhập tháng :");
        int month =ExceptionHandler.checkParseInt();

        System.out.println("Nhập năm :");
        int year = ExceptionHandler.checkParseInt() ;

        double totalRevenue= this.billController.revenueByMonth(month, year);
        System.out.println("Tổng doanh thu cho tháng " + month + "/" + year + " là: " + totalRevenue);
    }

    private void showAllBills() {
        List<Bill> billsList = this.billController.getAll();
        if (billsList.isEmpty()) {
            System.out.println("Không có hóa đơn nào trong hệ thống.");
        } else {
            for (Bill bill : billsList) {
                System.out.println(bill);
            }
        }
    }

    private void showEditBills() {

        System.out.println("Nhập id bạn cần sửa thông tin bill");
        int idIndex = ExceptionHandler.checkParseInt() ;
        Bill index = billController.searchBillById(idIndex);
        if (index == null){
            System.out.println("Khong tim thay id nay trong danh sach");
            return;
        }
        String nameRoom ;
        do {
            System.out.println("Nhập tên phòng :");
            nameRoom=scString.nextLine();
            if (nameRoom.isEmpty() ){
                System.out.println("Tên phòng không được để trống. Vui lòng nhập lại. ");
            }
        }while (nameRoom.isEmpty());


        String tenantName ;
        do {
            System.out.println("Nhập người thuê");
            tenantName= scString.nextLine();
            if (tenantName.isEmpty()){
                System.out.println("Người thuê không được bỏ trống. Vui lòng nhập lại");
            }
        }while (tenantName.isEmpty());

        String employeeName ;
        do {
            System.out.println("Nhập tên nhân viên :");
            employeeName=scString.nextLine();
            if (employeeName.isEmpty()){
                System.out.println("Tên nhân viên không đuược bỏ trống. Vui lòng nhập lại");
            }
        }while (employeeName.isEmpty());

        System.out.println("Nhập ngày bắt đầu thuê (YYYY--MM-DD) :");
        LocalDate startDate =ExceptionHandler.checkParseLocaDate();

        System.out.println("Nhập ngày kết thúc thuê (YYYY-MM-DD) :");
        LocalDate endDate = ExceptionHandler.checkParseLocaDate();


        System.out.println("Tổng tiền thuê là :");
        double totalPrice = ExceptionHandler.checkParseDouble() ;

        Bill bills = new Bill(idIndex,nameRoom,tenantName,employeeName,startDate,endDate,totalPrice);
        this.billController.update(idIndex,bills);
    }

    private void showAddBills() {
        System.out.println("======THÊM MỚI BILLS========");

        System.out.println("Nhập id bill");
        int id = ExceptionHandler.checkParseInt();

        String nameRoom ;
        do {
            System.out.println("Nhập tên phòng :");
            nameRoom=scString.nextLine();
            if (nameRoom.isEmpty() ){
                System.out.println("Tên phòng không được để trống. Vui lòng nhập lại. ");
            }
        }while (nameRoom.isEmpty());


        String tenantName ;
        do {
            System.out.println("Nhập người thuê");
            tenantName= scString.nextLine();
            if (tenantName.isEmpty()){
                System.out.println("Người thuê không được bỏ trống. Vui lòng nhập lại");
            }
        }while (tenantName.isEmpty());

        String employeeName ;
        do {
            System.out.println("Nhập tên nhân viên :");
            employeeName=scString.nextLine();
            if (employeeName.isEmpty()){
                System.out.println("Tên nhân viên không đuược bỏ trống. Vui lòng nhập lại");
            }
        }while (employeeName.isEmpty());

        System.out.println("Nhập ngày bắt đầu thuê (YYYY--MM-DD) :");
        LocalDate startDate =ExceptionHandler.checkParseLocaDate();

        System.out.println("Nhập ngày kết thúc thuê (YYYY-MM-DD) :");
        LocalDate endDate = ExceptionHandler.checkParseLocaDate();

        System.out.println("Tổng tiền thuê là :");
        double totalPrice =ExceptionHandler.checkParseDouble() ;

        Bill bills = new Bill(id,nameRoom,tenantName,employeeName,startDate,endDate,totalPrice);
        this.billController.addBills(bills);
    }
}
