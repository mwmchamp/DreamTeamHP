package com.example.pilly;

import java.io.Serializable;
import java.util.Date;

public class Pill implements Comparable<Pill> {
    private String name;
    private String dose;
    private String timeToBeTaken;
    private String dayToTake;
    private boolean isTaken;

    @Override
    public int compareTo(Pill o) {
        if (DayOfWeek.fromString(this.getDayToTake()).getDayNumber() > DayOfWeek.fromString(o.getDayToTake()).getDayNumber()) {
            return 1;
        } else if (DayOfWeek.fromString(this.getDayToTake()).getDayNumber() < DayOfWeek.fromString(o.getDayToTake()).getDayNumber()) {
            return -1;
        } else {
            return this.getTimeToBeTaken().compareTo(o.getTimeToBeTaken());
        }

    }

    public enum DayOfWeek {
        SUNDAY(1), MONDAY(2), TUESDAY(3), WEDNESDAY(4), THURSDAY(5), FRIDAY(6), SATURDAY(7);

        private final int dayNumber;

        DayOfWeek(int dayNumber) {
            this.dayNumber = dayNumber;
        }

        public int getDayNumber() {
            return dayNumber;
        }

        public static DayOfWeek fromString(String day) {
            for (DayOfWeek d : DayOfWeek.values()) {
                if (d.name().equalsIgnoreCase(day)) {
                    return d;
                }
            }
            throw new IllegalArgumentException("Invalid day: " + day);
        }
    }

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

    public String getDayToTake() {
        return dayToTake;
    }

    public void setDayToTake(String dayToTake) {
        this.dayToTake = dayToTake;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }

    public String toString() {
        return name + ", " + dose + ", " + timeToBeTaken + ", " + dayToTake + ", " + isTaken;
    }
}
