package com.example.pilly;

public class Pill {
    private String name;
    private String dose;
    private String timeToBeTaken;
    private boolean isTaken;

    public Pill(String name, String dose, String timeToBeTaken, boolean isTaken) {
        this.name = name;
        this.dose = dose;
        this.timeToBeTaken = timeToBeTaken;
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

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }

    public String toString(){
        return name + ", " + dose + ", " + timeToBeTaken + ", " + isTaken;
    }
}
