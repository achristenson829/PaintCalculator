package edu.wctc;

import java.io.*;
import java.util.Scanner;


public class Main {

    private static Scanner keyboard = new Scanner(System.in);
    private static PaintCalculator paintCalculator= new PaintCalculator();

    public static void main(String[] args) {
        int choice = 0;
        do {
            printMenu();
            choice = keyboard.nextInt();
            switch (choice){
                case 1:
                    createRoom();
                    break;
                case 2:
                    try {
                        writeFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        readFile();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    System.out.println(paintCalculator.toString());
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid input");
            }
        } while (choice != 5);
    }
    public static void createRoom(){
        double width = promptForDimension("width");
        double length = promptForDimension("length");
        double height = promptForDimension("height");
        paintCalculator.addRoom(length, width, height);
        System.out.println("New room created");
    }
    public static void printMenu(){
        System.out.printf("1. Add room%n2. Write rooms to file%n3. Read rooms from file%n4. View rooms%n5. Exit%n");
    }
    public static double promptForDimension(String dimensionName){
        System.out.printf("What is the %s of your room?", dimensionName);
        return keyboard.nextDouble();
    }

    public static void readFile() throws FileNotFoundException {

        File file = new File("rooms.txt");
        Scanner inputFile = new Scanner(file);
        while (inputFile.hasNextLine()) {
            String line = inputFile.nextLine();
            System.out.println(line);
        }
    }
    public static void writeFile() throws IOException {
        FileWriter fw = new FileWriter("rooms.txt");
        fw.write(paintCalculator.toString());
        System.out.println("File written successfully");
        fw.flush();
        fw.close();
    }
}
