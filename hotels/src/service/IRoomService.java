package service;

import model.Room;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface IRoomService <E>{
    void addRoom(Room room);

    void update(int id, Room room);

    List<Room> getAll();

    void checkRooms(String nameRoom, LocalDate startDate, LocalDate endDate);

    ArrayList<Room> searchByPrice(double from, double to);

    List<Room> searchRoomById(int id);

    void delete(int id);
}
