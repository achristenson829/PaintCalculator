package edu.wctc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PaintCalculator implements Serializable {

    private List<Room> roomList = new ArrayList<>();

    public void addRoom(double length, double width, double height){
        roomList.add(new Room(length, width, height));
    }

    public String toString() {
        String rooms = "";
        if (roomList.isEmpty())
            rooms = "There are no rooms";
        else {
            for (Room room : roomList)
                System.out.println(room.toString());
        }
        return rooms;
    }
}
