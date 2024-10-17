package controller;

import model.Bill;
import model.Room;
import service.BillService;
import service.IBillService;

import java.util.List;

public class BillController {
    private final IBillService<Bill> billService = new BillService();
    public void addBills(Bill bills) {
        this.billService.addBills(bills);
    }

    public void update(int id, Bill bills) {
        this.billService.update(id,bills);
    }

    public List<Bill> getAll() {
        return this.billService.getAll();
    }

    public double revenueByMonth(int month, int year) {
        return this.billService.revenueByMonth(month,year);
    }

    public Bill searchBillById(int id) {
        return this.billService.searchBillById(id);
    }

    public void delete(int id) {
        this.billService.delete(id);
    }

}
