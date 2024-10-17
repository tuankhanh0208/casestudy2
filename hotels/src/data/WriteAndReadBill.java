package data;

import model.Bill;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WriteAndReadBill {
    private File file = new File("C:\\CodeGym\\CaseStudy2\\hotels\\src\\bills.csv");


    public void writeToFileBill(List<Bill> billList, boolean append) {
        try (FileWriter fw = new FileWriter(this.file, append);
             BufferedWriter bw = new BufferedWriter(fw)) {

            for (Bill bill : billList) {
                bw.write(bill.getId() + "," + bill.getRoomName() + "," + bill.getTenantName() + "," +
                        bill.getEmployeeName() + "," + bill.getStartDate() + "," + bill.getEndDate() + "," + bill.getTotalPrice());
                bw.newLine();
            }

//            System.out.println("Thêm bill mới thành công");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public List<Bill> readBillsFromFile() {
        List<Bill> billList = new ArrayList<>();

        try (FileReader fr = new FileReader(this.file);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            while ((line = br.readLine()) != null) {

                String[] billDetails = line.split(",");
                int id = Integer.parseInt(billDetails[0]);
                String roomName = billDetails[1];
                String tenantName = billDetails[2];
                String employeeName = billDetails[3];
                LocalDate startDate = LocalDate.parse(billDetails[4]);
                LocalDate endDate = LocalDate.parse(billDetails[5]);
                double totalPrice = Double.parseDouble(billDetails[6]);


                Bill bill = new Bill(id, roomName, tenantName, employeeName, startDate, endDate, totalPrice);
                billList.add(bill);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return billList;
    }
}
