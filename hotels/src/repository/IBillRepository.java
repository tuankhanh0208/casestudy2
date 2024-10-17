package repository;

import model.Bill;
import model.Room;

import java.util.List;

public interface IBillRepository<E> {
    void addBills(Bill bills);



    void update(int id, Bill bills);

    List<Bill> getAll();

    double revenueByMonth(int month, int year);

    Bill seatchBillById(int id);

    void delete(int id);

}
