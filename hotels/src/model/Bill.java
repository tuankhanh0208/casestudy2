package model;

import java.time.LocalDate;
import java.util.Date;

public class Bill {
    private int id;
    private String roomName;
    private String tenantName;
    private String employeeName;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalPrice;
    public Bill(){}

    public Bill(int id, String roomName, String tenantName, String employeeName, LocalDate startDate, LocalDate endDate, double totalPrice) {
        this.id = id;
        this.roomName = roomName;
        this.tenantName = tenantName;
        this.employeeName = employeeName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
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

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", roomName='" + roomName + '\'' +
                ", tenantName='" + tenantName + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
