
//龍ONE

import java.util.ArrayList;

public class Problem_19 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The number of sundays that all on the first in the 19th century is: ";
    private static final int FIRST_SUNDAY_DATE = 6; // Jan 6 1901 is the first Sunday
    private static final int[] NUMBER_OF_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    private static final int[] NUMBER_OF_DAYS_LEAP = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    private static final int START_YEAR = 1901;
    private static final int END_YEAR = 2000;
    private static final int CENTURY = 100;
    private static final int CENTURY_LEAP_DIVISOR = 400;
    private static final int LEAP_DIVISOR = 4;
    private static final int DAYS_IN_WEEK = 7;

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int answer = 0;
        int sunday = FIRST_SUNDAY_DATE;
        boolean leapYear = false;
        ArrayList<Integer> allSundays = new ArrayList<Integer>();
        // determine all Sundays
        for (int year = START_YEAR; year <= END_YEAR; year++) {
            if (year % CENTURY == 0 && year % CENTURY_LEAP_DIVISOR == 0) {
                leapYear = true;
            } else if (year % LEAP_DIVISOR == 0) {
                leapYear = true;
            } else {
                leapYear = false;
            }
            for (int month = 1; month <= NUMBER_OF_DAYS.length; month++) {
                // calculate sundays for the month
                if (leapYear == false) {
                    while (sunday <= NUMBER_OF_DAYS[month - 1]) {
                        allSundays.add(sunday);
                        sunday += DAYS_IN_WEEK;
                    }
                    sunday = sunday - NUMBER_OF_DAYS[month - 1];
                } else {
                    while (sunday <= NUMBER_OF_DAYS_LEAP[month - 1]) {
                        allSundays.add(sunday);
                        sunday += DAYS_IN_WEEK;
                    }
                    sunday = sunday - NUMBER_OF_DAYS_LEAP[month - 1];
                }
            }
        }
        // calculate the number of sundays that are on the first
        for (int index = 0; index < allSundays.size(); index++) {
            if (allSundays.get(index) == 1) {
                answer++;
            }
        }
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + answer);
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
    }

}