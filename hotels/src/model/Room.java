package model;

import java.time.LocalDate;
import java.util.List;

public class Room {
    private int idRoom;
    private String nameRoom;
    private int numberToilet;
    private int numberBedRoom;
    private double price;
    private String status;
    private LocalDate startDate;
    private LocalDate endDate;
    private static int idIndex=1;
    public Room(){}

    public Room(int idRoom, String nameRoom,int numberToilet, int numberBedRoom, double price, String status,LocalDate startDate, LocalDate endDate) {
        this.idRoom = idRoom;
        this.nameRoom = nameRoom;
        this.numberToilet=numberToilet;
        this.numberBedRoom=numberBedRoom;
        this.price = price;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNumberToilet() {
        return numberToilet;
    }

    public void setNumberToilet(int numberToilet) {
        this.numberToilet = numberToilet;
    }

    public int getNumberBedRoom() {
        return numberBedRoom;
    }

    public void setNumberBedRoom(int numberBedRoom) {
        this.numberBedRoom = numberBedRoom;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Room{" +
                "idRoom=" + idRoom +
                ", nameRoom='" + nameRoom + '\'' +
                ", numberToilet=" + numberToilet +
                ", numberBedRoom=" + numberBedRoom +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
