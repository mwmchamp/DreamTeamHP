package com.example.pilly;

import java.io.Serializable;

public class Pill implements Serializable {
    private String name;
    private String dose;
    private String timeToBeTaken;
    private String dayToTake;
    private boolean isTaken;

    public Pill(String name, String dose, String timeToBeTaken, String dayToTake, boolean isTaken) {
        this.name = name;
        this.dose = dose;
        this.timeToBeTaken = timeToBeTaken;
        this.dayToTake = dayToTake;
        this.isTaken = isTaken;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getTimeToBeTaken() {
        return timeToBeTaken;
    }

    public void setTimeToBeTaken(String timeToBeTaken) {
        this.timeToBeTaken = timeToBeTaken;
    }

    public String getDayToTake() {return dayToTake; }

    public void setDayToTake(String dayToTake) {this.dayToTake = dayToTake; }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }

    public String toString(){
        return name + ", " + dose + ", " + timeToBeTaken + ", " + dayToTake + ", " + isTaken;
    }
}
