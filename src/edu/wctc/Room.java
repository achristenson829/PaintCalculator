package edu.wctc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Room implements Serializable {
    List<Wall> wallList = new ArrayList<>();

    public Room (Double width, Double length, double height){

        Wall wall1 = new Wall(width, height);
        Wall wall2 = new Wall(width, height);
        Wall wall3 = new Wall(length, height);
        Wall wall4 = new Wall(length, height);
        wallList.add(wall1);
        wallList.add(wall2);
        wallList.add(wall3);
        wallList.add(wall4);
    }

    public double getArea(){
        double area = 0;
      for (Wall wall : wallList) {
            area += wall.getArea();
        }
      return area;
    }
    public String toString (){
        return "The area of the room is " + getArea();
    }

}
