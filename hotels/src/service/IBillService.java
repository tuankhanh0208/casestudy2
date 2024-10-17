package service;

import model.Room;

import java.util.List;

public interface IBillService <E>{
    void addBills(E bills);



    void update(int id, E bills);

    List<E> getAll();

    double revenueByMonth(int month, int year);

    E searchBillById(int id);

    void delete(int id);

}
