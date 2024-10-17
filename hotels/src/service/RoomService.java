package service;

import model.Room;
import repository.IRoomRepository;
import repository.RoomRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RoomService implements  IRoomService<Room> {
    private IRoomRepository roomRepository = new RoomRepository();

    @Override
    public void addRoom(Room room) {
        this.roomRepository.addRoom(room);
    }

    @Override
    public void update(int id, Room room) {
        this.roomRepository.update(id,room);
    }

    @Override
    public List<Room> getAll() {
        return this.roomRepository.getAll();
    }

    @Override
    public void checkRooms(String nameRoom, LocalDate startDate, LocalDate endDate) {
        this.roomRepository.checkRooms(nameRoom,startDate,endDate);
    }

    @Override
    public ArrayList<Room> searchByPrice(double from, double to) {
        return this.roomRepository.searchByPrice(from,to);
    }

    @Override
    public List<Room> searchRoomById(int id) {
        return this.roomRepository.searchRoomById(id);
    }

    @Override
    public void delete(int id) {
        this.roomRepository.delete(id);
    }
}
