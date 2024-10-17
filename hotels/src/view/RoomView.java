package view;

import common.ExceptionHandler;
import controller.RoomController;
import model.Room;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class RoomView {
    private RoomController roomController = new RoomController();
    private Scanner scString = new Scanner(System.in);

    int choice;
    public void renderRoom(){
        showAllRoom();
    }
    private void showAllRoom() {
        do {
            System.out.println("=====QUẢN LÍ PHÒNG KHÁCH SẠN=====");
            System.out.println("1.Danh sách phòng");
            System.out.println("2.Tìm kiếm phòng theo giá");
            System.out.println("3.Kiểm tra phòng");
            System.out.println("4.Thêm mới phòng");
            System.out.println("5.Sửa phòng");
            System.out.println("6.Xóa phòng");
            System.out.println("0.Quay lại menu chính");

            System.out.print("Nhập lựa chọn của bạn");
            choice = ExceptionHandler.checkParseInt();

            switch (choice){
                case 1:
                    showAllRooms();
                    break;
                case 2:
                    showSearchByPrice();
                    break;
                case 3:
                    showCheckRoom();
                    break;
                case 4:
                    showAddRoom();
                    break;
                case 5:
                    showEditRoom();
                    break;
                case 6:
                    showDeleteRoom();
                    break;
                case 0:
                    System.out.println("Quay lại màn hình chính");
            }
        }while (choice!=0);
    }

    private void showDeleteRoom() {
        System.out.println("====XÓA PHÒNG====");
        int id;
        do {
            System.out.print("Nhập ID phòng cần xóa (nhấn Enter để quay lại Menu): ");
            id = ExceptionHandler.checkParseInt();
            if (id == 0) {
                System.out.println("Quay lại Menu chính.");
                return;
            }
            Room directory = (Room) roomController.searchRoomById(id);
            if (directory != null) {
                System.out.println("Bạn có chắc muốn xóa phòng với số ID " + id + " không? (Nhập 'Y' để xác nhận): ");
                String confirm = scString.nextLine();
                if (confirm.equalsIgnoreCase("Y")) {
                    roomController.delete(id);
                    System.out.println("Phòng với số ID " + id + " đã được xóa.");
                } else {
                    System.out.println("Hủy thao tác xóa. Quay lại Menu.");
                }
                return;
            } else {
                System.out.println("Không tìm thấy phòng với số ID này. Vui lòng nhập lại.");
            }
        } while (true);


    }

    private void showEditRoom() {
        System.out.println("Nhập id phòng bạn muốn cập nhật:");
        int id = ExceptionHandler.checkParseInt();

        System.out.println("Nhập tên phòng:");
        String nameRoom = scString.nextLine();
        System.out.println("Nhập số nhà vệ sinh:");
        int numberToilet = ExceptionHandler.checkParseInt();
        System.out.println("Nhập số phòng ngủ:");
        int numberBedRoom = ExceptionHandler.checkParseInt();
        System.out.println("Nhập giá phòng:");
        double price =ExceptionHandler.checkParseDouble();
        System.out.println("Nhập trạng thái phòng:");
        String status = scString.nextLine();
        System.out.println("Nhập ngày bắt đầu :");
        LocalDate startDate = ExceptionHandler.checkParseLocaDate();
        System.out.println("Nhập ngày kết thúc :");
        LocalDate endDate = ExceptionHandler.checkParseLocaDate();

        Room room = new Room(id, nameRoom, numberToilet, numberBedRoom, price, status,startDate,endDate);
        this.roomController.update(id, room);
    }

    private void showAddRoom() {
        System.out.println("======= THÊM PHÒNG MỚI =======");

        System.out.println("Nhập ID phòng:");
        int idRoom = ExceptionHandler.checkParseInt();

        System.out.println("Nhập tên phòng:");
        String nameRoom = scString.nextLine();

        System.out.println("Nhập số nhà vệ sinh:");
        int numberToilet = ExceptionHandler.checkParseInt();

        System.out.println("Nhập số phòng ngủ:");
        int numberBedRoom = ExceptionHandler.checkParseInt();

        System.out.println("Nhập giá:");
        double price = ExceptionHandler.checkParseDouble();

        System.out.println("Nhập trạng thái:");
        String status = scString.nextLine();

        System.out.println("Nhập ngày bắt đầu (YYYY-MM-DD):");
        LocalDate startDate = ExceptionHandler.checkParseLocaDate();

        System.out.println("Nhập ngày kết thúc (YYYY-MM-DD):");
        LocalDate endDate = ExceptionHandler.checkParseLocaDate();

        Room room = new Room(idRoom, nameRoom, numberToilet, numberBedRoom, price, status, startDate, endDate);
        roomController.addRooms(room);
        System.out.println("Phòng đã được thêm thành công.");
    }

    private void showCheckRoom() {

        System.out.println("Nhập tên phòng:");
        String nameRoom = scString.nextLine();

        System.out.println("Nhập ngày bắt đầu:");
        LocalDate startDate = ExceptionHandler.checkParseLocaDate();

        System.out.println("Nhập ngày kết thúc:");
        LocalDate endDate = ExceptionHandler.checkParseLocaDate();
        this.roomController.checkRooms(nameRoom,startDate,endDate);
    }

    private void showSearchByPrice() {
        System.out.println("Nhập giá min:");
        double from = ExceptionHandler.checkParseDouble();

        System.out.println("Nhập giá max:");
        double to = ExceptionHandler.checkParseDouble();

        List<Room> roomList = roomController.searchByPrice(from, to);

        if (roomList.isEmpty()) {
            System.out.println("Không có phòng nào trong khoảng giá này.");
        } else {
            roomList.forEach(System.out::println);
        }
    }


    private void showAllRooms() {
        List<Room> roomList = this.roomController.getAll();
        if (roomList.isEmpty()) {
            System.out.println("Không có phòng nào trong hệ thống.");
        } else {
            for (Room room : roomList) {
                System.out.println(room);
            }
        }
    }
}
