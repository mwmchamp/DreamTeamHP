package com.example.pilly;

import android.content.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class PillReader {

    public static LinkedList<com.example.pilly.Pill> readPills(Context context) {
        InputStream is = context.getResources().openRawResource(R.raw.pilldata);

        LinkedList<com.example.pilly.Pill> pills = new LinkedList<com.example.pilly.Pill>();
        Scanner input = new Scanner(is).useDelimiter("\\A");
        while (input.hasNextLine()) {
            String currentLine = input.nextLine();
            String[] splitLine = currentLine.split(",");
            String name = splitLine[0].trim();
            String dose = splitLine[1].trim();
            String timeToTake = splitLine[2].trim();
            String dayToTake = splitLine[3].trim();
            boolean isTaken = splitLine[4].trim().equals("true");
            com.example.pilly.Pill currentPill = new com.example.pilly.Pill(name, dose, timeToTake, dayToTake, isTaken);
            if (pills.isEmpty()) {
                pills.add(currentPill);
            } else {
                int index = 0;
                while (index < pills.size() && pills.get(index).getTimeToBeTaken().compareTo(currentPill.getTimeToBeTaken()) < 0) {
                    index++;
                }
                pills.add(index, currentPill);
            }
        }
        input.close();
        return pills;
//        } catch (FileNotFoundException e) {
//            System.out.println("Could not find file \"" + filename + "\"");
//            LinkedList<com.example.pilly.Pill> pills = new LinkedList<com.example.pilly.Pill>();
//            return pills;
    }
}
