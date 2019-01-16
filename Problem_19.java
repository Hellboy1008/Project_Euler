
//龍ONE

import java.util.ArrayList;

public class Problem_19 {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int sunday = 6; // Jan 6 1901 is the first Sunday
        int answer = 0;
        boolean leapYear = false;
        int[] numberOfDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int[] numberOfDays_LeapYear = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        ArrayList<Integer> allSundays = new ArrayList<Integer>();
        // determine all Sundays
        for (int year = 1901; year <= 2000; year++) {
            if (year % 100 == 0 && year % 400 == 0) {
                leapYear = true;
            } else if (year % 4 == 0) {
                leapYear = true;
            } else {
                leapYear = false;
            }
            for (int month = 1; month <= 12; month++) {
                // calculate sundays for the month
                if (leapYear == false) {
                    while (sunday <= numberOfDays[month - 1]) {
                        allSundays.add(sunday);
                        sunday += 7;
                    }
                    sunday = sunday - numberOfDays[month - 1];
                } else {
                    while (sunday <= numberOfDays_LeapYear[month - 1]) {
                        allSundays.add(sunday);
                        sunday += 7;
                    }
                    sunday = sunday - numberOfDays_LeapYear[month - 1];
                }
            }
        }
        // calculate the number of sundays that are on the first
        for (int index = 0; index < allSundays.size(); index++) {
            if (allSundays.get(index) == 1) {
                answer++;
            }
        }
        System.out.println("The number of sundays that all on the first in the 19th century is: " + answer);
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
    }

}