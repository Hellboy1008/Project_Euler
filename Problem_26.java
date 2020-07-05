
/**
 * Created by: 龍ONE 
 * Date Created: January 30, 2019
 * Date Edited: July 5, 2020
 * Purpose: Solution to Project Euler Problem 26
 */

import java.math.BigInteger;

/**
 * This class contains a method that calculates the number between 1 and n for
 * which 1/n contains the longest recurring cycle in its decimal fraction part.
 * The main method executes the program.
 */
public class Problem_26 {

    // the first factor used in calculations
    private static final int FACTOR_ONE = 2;
    // the second factor used in calculations
    private static final int FACTOR_TWO = 5;
    // the upper limit for the problem
    private static final int UPPER_BOUND = 1000;

    // conversion from nanoseconds to seconds
    private static final long TIME_CONVERSION = 1000000000;

    // answer prompt
    private static final String ANSWER = "The longest recurring cycle for n < " + UPPER_BOUND + " is: 1 / ";
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
        solution = determineLongestCycle(UPPER_BOUND);
        endTime = System.nanoTime();

        // print answer and time taken
        System.out.println(ANSWER + solution);
        System.out.printf(TIME_TAKEN, (double) (endTime - startTime) / TIME_CONVERSION);
    }

    /**
     * Calculates the value of n less than the maxDivisor for which 1/n contains the
     * longest recurring cycle in its decimal fraction part.
     * 
     * @param maxDivisor The upper bound for the problem
     * @return The value of n < maxDivisor for which 1/n has the longest recurring
     *         cycle.
     */
    private static int determineLongestCycle(int maxDivisor) {
        // stores the length of the longest cycle
        int longestCycleLength = 0;
        // stores the value with the longest cycle
        int longestCycleDivisor = 0;
        // stores the power used in the calculations
        int power;
        // stores the value for base 10 calculations
        BigInteger base = BigInteger.TEN;
        // stores the modulo value of 2 numbers
        BigInteger modValue;

        // loop through all values from 1 to the max divisor
        for (int divisor = 1; divisor <= maxDivisor; divisor++) {
            // check if the number can be written as 2^a5^b
            if (divideTwoAndFive(divisor) == 1) {
                continue;
            } else {
                power = 1;
                modValue = new BigInteger("" + divideTwoAndFive(divisor));
                // find the power where 10^k (mod n) = 1, where n is the result of dividing the
                // number by 2s and 5s as many times as possible
                while (base.pow(power).mod(modValue).intValue() != 1) {
                    power++;
                }
                // if the length of the cycle is longer than the current length
                if (power > longestCycleLength) {
                    longestCycleLength = power;
                    longestCycleDivisor = divisor;
                }
            }
        }

        return longestCycleDivisor;
    }

    /**
     * Divides all 2s and 5s from a number. Used to determine if a number can be
     * written in the form 2^a5^b.
     * 
     * @param number The number in question
     * @return The result of dividing all 2s and 5s from the number
     */
    private static int divideTwoAndFive(int number) {
        // divides two as many times as possible
        while (number % FACTOR_ONE == 0) {
            number = number / FACTOR_ONE;
        }
        // divides five as many times as possible
        while (number % FACTOR_TWO == 0) {
            number = number / FACTOR_TWO;
        }

        return number;
    }

}