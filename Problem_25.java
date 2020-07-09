
/**
 * Created by: 龍ONE 
 * Date Created: January 30, 2019
 * Date Edited: July 9, 2020
 * Purpose: Solution to Project Euler Problem 25
 */

import java.math.BigInteger;

/**
 * This class contains method(s) that calculates the index of the first term in
 * the Fibonacci sequence to contain n digits. The main method executes the
 * program.
 */
public class Problem_25 {

    // the index of the second fibonacci
    private static final int SECOND_FIBONACCI = 2;
    // the number of digits for the question
    private static final int TOTAL_DIGITS = 1000;

    // conversion from nanoseconds to seconds
    private static final long TIME_CONVERSION = 1000000000;

    // answer prompt
    private static final String ANSWER = "The index of the first fibonacci term with " + TOTAL_DIGITS + " digits is: ";
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
        solution = findFibonacciIndex(TOTAL_DIGITS);
        endTime = System.nanoTime();

        // print answer and time taken
        System.out.println(ANSWER + solution);
        System.out.printf(TIME_TAKEN, (double) (endTime - startTime) / TIME_CONVERSION);
    }

    /**
     * Find the index of the first term in the Fibonacci sequence that has n digits.
     * 
     * @param numOfDigits The number of digits in question
     * @return The index of the first term in the Fibonacci sequence with n digits
     */
    private static int findFibonacciIndex(int numOfDigits) {
        // stores the index for the fibonacci values
        int fibonacciIndex = SECOND_FIBONACCI;
        // the calculated fibonacci value
        BigInteger calculatedFibonacci = BigInteger.ZERO;
        // the first fibonacci value used in calculation
        BigInteger fibonacciOne = BigInteger.ONE;
        // the second fibonacci value used in calculation
        BigInteger fibonacciTwo = BigInteger.ONE;

        // run until the fibonacci has n digits
        while (calculatedFibonacci.toString().length() < numOfDigits) {
            calculatedFibonacci = fibonacciOne.add(fibonacciTwo);
            fibonacciOne = fibonacciTwo;
            fibonacciTwo = calculatedFibonacci;
            fibonacciIndex++;
        }

        return fibonacciIndex;
    }

}