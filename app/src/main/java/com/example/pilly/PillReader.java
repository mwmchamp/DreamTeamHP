package com.example.pilly;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class PillReader {

    public static LinkedList<com.example.pilly.Pill> readPills(String filename) {
        try {
            LinkedList<com.example.pilly.Pill> pills = new LinkedList<com.example.pilly.Pill>();
            File pillData = new File(filename);
            Scanner input = new Scanner(pillData);
            while (input.hasNextLine()) {
                String currentLine = input.nextLine();
                String[] splitLine = currentLine.split(",");
                String name = splitLine[0].trim();
                String dose = splitLine[1].trim();
                String timeToTake = splitLine[2].trim();
                boolean isTaken = false;
                if(splitLine[3].trim().equals("true")) {
                    isTaken = true;
                }
                com.example.pilly.Pill currentPill = new com.example.pilly.Pill(name, dose, timeToTake, isTaken);
                if(pills.isEmpty()) {
                    pills.add(currentPill);
                }
                else{
                    int index = 0;
                    while (index < pills.size() && pills.get(index).getTimeToBeTaken().compareTo(currentPill.getTimeToBeTaken()) < 0) {
                        index++;
                    }
                    pills.add(index, currentPill);
                }
            }
            input.close();
            return pills;
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file \"" + filename + "\"");
            return null;
        }
    }

}
