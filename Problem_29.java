
/**
 * Created by: 龍ONE 
 * Date Created: February 1, 2019
 * Date Edited: July 5, 2020
 * Purpose: Solution to Project Euler Problem 29
 */

import java.util.ArrayList;

/**
 * This class contains a method that calculates the number of distinct terms in
 * the sequence generated by a^b for n ≤ a ≤ m and n ≤ b ≤ m, where n is the
 * lower bound and m is the upper bound. The main method executes the program.
 */
public class Problem_29 {

    // lower bound for the problem
    private static final int LOWER_BOUND = 2;
    // upper bound for the problem
    private static final int UPPER_BOUND = 100;

    // conversion from nanoseconds to seconds
    private static final long TIME_CONVERSION = 1000000000;

    // answer prompt
    private static final String ANSWER = "The number of distinct terms in the sequence generated by a^b where "
            + LOWER_BOUND + " <= a <= " + UPPER_BOUND + " and " + LOWER_BOUND + " <= b <= " + UPPER_BOUND + " is: ";
    // time take to solve the problem
    private static final String TIME_TAKEN = "Time Taken:%s seconds";

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
        solution = addTerms(LOWER_BOUND, UPPER_BOUND);
        endTime = System.nanoTime();

        // print answer and time taken
        System.out.println(ANSWER + solution);
        System.out.printf(TIME_TAKEN, (double) (endTime - startTime) / TIME_CONVERSION);
    }

    /**
     * Calculates the number of distinct terms in the sequence generated by a^b for
     * n ≤ a ≤ m and n ≤ b ≤ m, where n is the lower bound and m is the upper bound.
     * 
     * @param lowerBound The lower bound for the problem
     * @param upperBound The upper bound for the problem
     * @return The number of distinct terms in the sequence
     */
    private static int addTerms(int lowerBound, int upperBound) {
        // holds the result of a^b
        double num;
        // holds the distinct values in the sequence
        ArrayList<Double> values = new ArrayList<Double>();

        // loop through all values for a
        for (int aValue = lowerBound; aValue <= upperBound; aValue++) {
            // loop through all values of b
            for (int bValue = lowerBound; bValue <= upperBound; bValue++) {
                num = Math.pow(aValue, bValue);
                // check if the value already exists
                if (values.contains(num) == false) {
                    values.add(num);
                }
            }
        }

        return values.size();
    }

}