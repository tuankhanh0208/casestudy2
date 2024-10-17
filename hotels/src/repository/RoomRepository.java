package repository;

import data.WriteAndReadRoom;
import model.Bill;
import model.Room;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class RoomRepository implements IRoomRepository<Room> {
    private List<Room> roomList;
    private WriteAndReadRoom writeAndReadRoom = new WriteAndReadRoom();
    public RoomRepository(){
        this.roomList= this.writeAndReadRoom.readRoomsFromFile();
    }

    public void saveRoomToFile() {
        writeAndReadRoom.writetoFileRoom(roomList, false);
    }

    public void reloadRoom() {
        this.roomList = writeAndReadRoom.readRoomsFromFile();
    }

    @Override
    public void addRoom(Room room) {
        this.roomList.add(room);
        writeAndReadRoom.writetoFileRoom(this.roomList,true);
    }

    @Override
    public void update(int id, Room room) {
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getIdRoom() == id) {
                roomList.set(i, room);
                saveRoomToFile();
                System.out.println("Cập nhật bill thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy bill với id: " + id);
    }

    @Override
    public List<Room> getAll() {
        return roomList;
    }

    @Override
    public void checkRooms(String nameRoom, LocalDate startDate, LocalDate endDate) {
        List<Room> roomList1 = writeAndReadRoom.readRoomsFromFile();
        boolean isAvailable =true;
        for (Room room : roomList1){
            if (room.getNameRoom().equalsIgnoreCase(nameRoom)){
                LocalDate roomStartDate = room.getStartDate();
                LocalDate roomEndDate = room.getEndDate();

                if (!(endDate.isBefore(roomStartDate) || startDate.isAfter(roomEndDate))){
                    isAvailable=false;
                    System.out.println("Phong " + nameRoom + " da duoc dat tu " + roomStartDate + " toi ngay " +roomEndDate);
                    break;
                }
            }
        }
        if (isAvailable){
            System.out.println("Phong " + nameRoom + " trong tu  " + startDate + " toi ngay " +endDate);
        }
    }

    @Override
    public ArrayList<Room> searchByPrice(double from, double to) {
        ArrayList<Room> filteredRooms = new ArrayList<>();
        List<Room> allRooms = writeAndReadRoom.readRoomsFromFile();
        for (Room room : allRooms) {
            if (room.getPrice() >= from && room.getPrice() <= to) {
                filteredRooms.add(room);
            }
        }
        return filteredRooms;
    }

    @Override
    public List<Room> searchRoomById(int id) {
        List<Room> roomList1 = new ArrayList<>();
        for (Room directory : roomList) {
            if (directory.getIdRoom()==id) {
                roomList1.add(directory);
            }
        }
        return roomList1;
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < roomList.size(); i++) {
            if(roomList.get(i).getIdRoom() == id){
                roomList.remove(i);
                saveRoomToFile();
                System.out.println("Xóa phòng thành công");
                return;
            }
        }
        System.out.println("Không tìm thấy phòng với ID " + id);
    }
}
