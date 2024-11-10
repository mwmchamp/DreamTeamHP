package com.example.pilly;

import java.io.FileWriter;
import java.io.IOException;

public class PillWriter {
    public static boolean writePill(Pill pill, String filename) {
        String pillToAppend = pill.getName() + ", " + pill.getDose() + ", " + pill.getTimeToBeTaken() + ", " + pill.getDayToTake() +  ", " + pill.isTaken() + "\n";
        try (FileWriter output = new FileWriter(filename, true)) {
            output.write(pillToAppend);
            return true;
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
            return false;
        }

    }
}