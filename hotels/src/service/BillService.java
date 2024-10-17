package service;

import model.Bill;
import model.Room;
import repository.BillRepository;
import repository.IBillRepository;

import java.util.List;

public class BillService implements IBillService<Bill> {
    private final IBillRepository billRepository = new BillRepository();
    @Override
    public void addBills(Bill bills) {
        this.billRepository.addBills(bills);
    }



    @Override
    public void update(int id, Bill bills) {
        this.billRepository.update(id, bills);
    }

    @Override
    public List<Bill> getAll() {
        return this.billRepository.getAll();
    }

    @Override
    public double revenueByMonth(int month, int year) {
        return this.billRepository.revenueByMonth(month,year);
    }

    @Override
    public Bill searchBillById(int id) {
        return this.billRepository.seatchBillById(id);
    }

    @Override
    public void delete(int id) {
        this.billRepository.delete(id);
    }

}
