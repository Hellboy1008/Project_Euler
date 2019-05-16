
/**
 * Created by: 龍ONE 
 * Date Created: Jan 3, 2018
 * Date Edited: May 15, 2019
 * Purpose: Solution to Project Euler Problem 5
 */

/**
 * This class contains a method that calculates the smallest number divisible by
 * n consecutive integers as well as the main method that executes the program.
 */
public class Problem_05 {

    // holds whether a number is unique
    private static boolean[] unique;

    // smallest factor given that solution must be divisible by 1 and 2
    private static final int SMALLEST_FACTOR = 3;
    // the maximum factor for the problem
    private static final int UPPER_BOUND = 20;

    // conversion from nanoseconds to seconds
    private static final long TIME_CONVERSION = 1000000000;

    // holds all the unique factors
    private static int[] possibleFactors;

    // answer prompt
    private static final String ANSWER = "The smallest positive number divisible by all integers from 1-20 is: ";
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
        solution = findSmallestMultiple(UPPER_BOUND);
        endTime = System.nanoTime();

        // print answer and time taken
        System.out.println(ANSWER + solution);
        System.out.printf(TIME_TAKEN, (double) (endTime - startTime) / TIME_CONVERSION);
    }

    /**
     * This method determines the smallest multiple divisible by all positive
     * integers from 1 to upper_bound.
     * 
     * @param upper_bound The largest factor of the multiple
     * @return The smallest multiple that fulfills the conditions
     */
    private static int findSmallestMultiple(int upper_bound) {
        // solution to method
        int multiple = 1;

        // initialize possibleFactors array
        possibleFactors = new int[upper_bound + 1];
        for (int index = 0; index < possibleFactors.length; index++) {
            possibleFactors[index] = index;
        }
        // initialize unique array
        unique = new boolean[upper_bound + 1];
        for (int index = SMALLEST_FACTOR; index < unique.length; index++) {
            unique[index] = true;
        }

        // find numbers with no repeated factors
        for (int num = upper_bound; num > SMALLEST_FACTOR - 1; num--) {
            // if the number is not unique, skip
            if (unique[num] == false) {
                continue;
            }
            // check factors
            for (int factor = SMALLEST_FACTOR; factor < num; factor++) {
                if (num % factor == 0 && unique[factor] == true) {
                    // new factor
                    unique[factor] = false;
                } else if (num % factor == 0 && unique[factor] == false) {
                    // repeated factor
                    unique[num] = false;
                    break;
                }
            }
        }

        // multiply all the unique numbers to get the sum
        for (int index = 0; index < unique.length; index++) {
            if (unique[index] == true) {
                multiple *= index;
            }
        }

        return multiple;
    }
}