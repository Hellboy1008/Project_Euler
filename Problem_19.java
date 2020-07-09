
/**
 * Created by: 龍ONE 
 * Date Created: January 15, 2019
 * Date Edited: July 9, 2020
 * Purpose: Solution to Project Euler Problem 19
 */

import java.util.ArrayList;

/**
 * This class contains method(s) that finds the number of sundays that fell on
 * the first of the month between two years. The main method executes the
 * program.
 */
public class Problem_19 {

    // number of days in a week
    private static final int DAYS_IN_WEEK = 7;
    // the end year for the calculation
    private static final int END_YEAR = 2000;
    // the mark of a century
    private static final int CENTURY = 100;
    // check to see whether the turn of a century is also a leap year
    private static final int CENTURY_LEAP_DIVISOR = 400;
    // number of years till leap year
    private static final int LEAP_DIVISOR = 4;
    // date for the first sunday (in this case Jan 6, 1901)
    private static final int FIRST_SUNDAY_DATE = 6;
    // the start year for the calculation
    private static final int START_YEAR = 1901;

    // number of days in each month for a normal year
    private static final int[] NUMBER_OF_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    // number of days in each month for a leap year
    private static final int[] NUMBER_OF_DAYS_LEAP = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    // conversion from nanoseconds to seconds
    private static final long TIME_CONVERSION = 1000000000;

    // answer prompt
    private static final String ANSWER = "The number of sundays that all on the first between " + START_YEAR + " and "
            + END_YEAR + " is: ";
    // time take to solve the problem
    private static final String TIME_TAKEN = "Time Taken: %s seconds";

    /**
     * The main method executes the solution and prints it alongside the time taken
     * to solve the program.
     * 
     * @param args The arguments given to the main method
     * @return None
     */
    public static void main(String[] args) {
        // solution for the problem
        int solution;
        // end time of the program
        long endTime;
        // start time of the program
        long startTime;

        startTime = System.nanoTime();
        solution = findFirstSundays(START_YEAR, END_YEAR);
        endTime = System.nanoTime();

        // print answer and time taken
        System.out.println(ANSWER + solution);
        System.out.printf(TIME_TAKEN, (double) (endTime - startTime) / TIME_CONVERSION);
    }

    /**
     * Calculates the number of sundays that fall on the first of the month between
     * two years.
     * 
     * @param startYear The starting year
     * @param endYear   The end year
     * @return The number of sundays that fall on the first of the month
     */
    private static int findFirstSundays(int startYear, int endYear) {
        // keep tracks of whether a given year is a leap year
        boolean leapYear = false;
        // keeps track of the date of the sundays
        int sunday = FIRST_SUNDAY_DATE;
        // number of sundays on the first of the month
        int numOfSundays = 0;
        // list containing the dates of all the sundays
        ArrayList<Integer> allSundays = new ArrayList<Integer>();

        // loops through all the years
        for (int year = START_YEAR; year <= END_YEAR; year++) {
            // check if the given year is a leap year
            if (year % CENTURY == 0 && year % CENTURY_LEAP_DIVISOR == 0) {
                leapYear = true;
            } else if (year % LEAP_DIVISOR == 0) {
                leapYear = true;
            } else {
                leapYear = false;
            }
            // loops through each month to count sundays
            for (int month = 1; month <= NUMBER_OF_DAYS.length; month++) {
                // loop through different arrays based on leap year
                if (leapYear == false) {
                    // calculate sundays for the month
                    while (sunday <= NUMBER_OF_DAYS[month - 1]) {
                        allSundays.add(sunday);
                        sunday += DAYS_IN_WEEK;
                    }
                    sunday = sunday - NUMBER_OF_DAYS[month - 1];
                } else {
                    // calculate sundays for the month
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
                numOfSundays++;
            }
        }

        return numOfSundays;
    }

}