package data;

import model.Room;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WriteAndReadRoom {
    private File file = new File("C:\\CodeGym\\CaseStudy2\\hotels\\src\\rooms.csv");

    public void writetoFileRoom(List<Room> roomList, boolean append) {
        try (FileWriter fw = new FileWriter(this.file, append);
             BufferedWriter bw = new BufferedWriter(fw)) {

            for (Room room : roomList) {
                String line = room.getIdRoom() + "," +
                        room.getNameRoom() + "," +
                        room.getNumberToilet() + "," +
                        room.getNumberBedRoom() + "," +
                        room.getPrice() + "," +
                        room.getStatus() + "," +
                        room.getStartDate() + "," +
                        room.getEndDate();

                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Room> readRoomsFromFile() {
        List<Room> roomList = new ArrayList<>();

        try (FileReader fr = new FileReader(this.file);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] roomDetails = line.split(",");
                int idRoom = Integer.parseInt(roomDetails[0]);
                String nameRoom = roomDetails[1];
                int numberToilet = Integer.parseInt(roomDetails[2]);
                int numberBedRoom = Integer.parseInt(roomDetails[3]);
                double price = Double.parseDouble(roomDetails[4]);
                String status = roomDetails[5];
                LocalDate startDate = LocalDate.parse(roomDetails[6]);
                LocalDate endDate = LocalDate.parse(roomDetails[7]);
                Room room = new Room(idRoom, nameRoom, numberToilet, numberBedRoom, price, status,startDate,endDate);
                roomList.add(room);
            }
        } catch (IOException e) {
            System.out.println( e.getMessage());
        }

        return roomList;
    }
}
