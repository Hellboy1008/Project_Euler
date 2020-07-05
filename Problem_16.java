
/**
 * Created by: 龍ONE 
 * Date Created: December 22, 2018
 * Date Edited: July 5, 2020
 * Purpose: Solution to Project Euler Problem 16
 */

/**
 * This class contains a method that calculates the sum of the digits of a number n
 * raised to another number m. The main method executes the program.
 */

import java.math.BigInteger;

public class Problem_16 {

    // the base in question
    private static final int BASE = 2;
    // the exponent in question
    private static final int EXPONENT = 1000;

    // conversion from nanoseconds to seconds
    private static final long TIME_CONVERSION = 1000000000;

    // answer prompt
    private static final String ANSWER = "The sum of the digits of " + BASE + "^" + EXPONENT + " is: ";
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
        solution = digitSumPower(BASE, EXPONENT);
        endTime = System.nanoTime();

        // print answer and time taken
        System.out.println(ANSWER + solution);
        System.out.printf(TIME_TAKEN, (double) (endTime - startTime) / TIME_CONVERSION);
    }

    /**
     * Calculates the sum of the digits of a number raised to another number.
     * 
     * @param base     The base in question
     * @param exponent The exponent in question
     * @return The sum of the digits of the base raised to the exponent.
     */
    private static int digitSumPower(int base, int exponent) {
        // sum of the digits of resulting value
        int sum = 0;
        // string representation of the resulting value
        String result_val;
        // BigInteger value for base
        BigInteger bigIntBase = BigInteger.valueOf(base);
        // BigInteger value for resulting value
        BigInteger solution;

        solution = bigIntBase;
        solution = solution.pow(exponent);
        result_val = solution.toString();

        // add the digits one at a time
        for (int index = 0; index < result_val.length(); index++) {
            sum += Character.getNumericValue(result_val.charAt(index));
        }

        return sum;
    }

}