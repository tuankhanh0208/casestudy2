package repository;

import data.WriteAndReadBill;
import model.Bill;
import model.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BillRepository implements IBillRepository<Bill> {
    private List<Bill> billList ;
    WriteAndReadBill writeAndReadBill = new WriteAndReadBill();
    public BillRepository(){
        this.billList= this.writeAndReadBill.readBillsFromFile();
    }
    @Override
    public void addBills(Bill bills) {
        this.billList.add(bills);
        writeAndReadBill.writeToFileBill(this.billList,true);
    }

    @Override
    public void update(int id, Bill bill) {
        for (int i = 0; i < billList.size(); i++) {
            if (billList.get(i).getId() == id) {
                billList.set(i, bill);
                saveBillToFile();
                System.out.println("Cập nhật bill thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy bill với id: " + id);
    }

    @Override
    public List<Bill> getAll() {
        return billList;
    }

    @Override
    public double revenueByMonth(int month, int year) {
        double total = 0.0;
        for (Bill bill : billList) {
            if (bill.getEndDate().getMonthValue() == month && bill.getEndDate().getYear() == year) {
                total += bill.getTotalPrice();
            }
        }
        return total;
    }

    @Override
    public Bill seatchBillById(int id) {
        for (Bill directory : billList) {
            if (directory.getId() == id) {
                return directory;
            }
        }
        return null;
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < billList.size(); i++) {
            if(billList.get(i).getId() == id){
                billList.remove(i);
                saveBillToFile();
                System.out.println("Xóa hóa đơn thành công");
                return;
            }
        }
        System.out.println("Không tìm thấy hóa đơn với ID " + id);
    }




    public void saveBillToFile() {
        writeAndReadBill.writeToFileBill(billList, false);
    }

    public void reloadBill() {
        this.billList = writeAndReadBill.readBillsFromFile();
    }

}
