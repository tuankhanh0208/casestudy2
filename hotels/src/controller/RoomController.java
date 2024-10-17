package controller;

import model.Room;
import service.IRoomService;
import service.RoomService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RoomController {
    private IRoomService roomService = new RoomService();

    public void addRooms(Room room) {
        this.roomService.addRoom(room);
    }

    public void update(int id, Room room) {
        this.roomService.update(id,room);
    }

    public List<Room> getAll() {
        return this.roomService.getAll();
    }

    public void checkRooms(String nameRoom, LocalDate startDate, LocalDate endDate) {
        this.roomService.checkRooms(nameRoom,startDate,endDate);
    }

    public ArrayList<Room> searchByPrice(double from, double to) {
        return this.roomService.searchByPrice(from,to);
    }

    public List<Room> searchRoomById(int id) {
        return this.roomService.searchRoomById(id);
    }

    public void delete(int id) {
        this.roomService.delete(id);
    }
}
