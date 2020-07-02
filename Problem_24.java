
/**
 * Created by: 龍ONE 
 * Date Created: January 30, 2019
 * Date Edited: July 2, 2020
 * Purpose: Solution to Project Euler Problem 24
 */

import java.util.ArrayList;

/**
 * This class contains a method that calculates nth lexicographic permutation of
 * the digits 0 through 9. The main method executes the program.
 */
public class Problem_24 {

    // target value for the question
    private static final int TARGET = 1000000;
    // total number of digits used for permutation
    private static final int TOTAL_DIGITS = 10;

    // conversion from nanoseconds to seconds
    private static final long TIME_CONVERSION = 1000000000;

    // answer prompt
    private static final String ANSWER = "The " + TARGET + "th lexicographic permutation is: ";
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
        // end time of the program
        long endTime;
        // start time of the program
        long startTime;
        // solution for the problem
        String solution;

        startTime = System.nanoTime();
        solution = solvePermutation(TARGET);
        endTime = System.nanoTime();

        // print answer and time taken
        System.out.println(ANSWER + solution);
        System.out.printf(TIME_TAKEN, (double) (endTime - startTime) / TIME_CONVERSION);
    }

    /**
     * Finds the nth permutation of the digits 0-9, where n is the target.
     * 
     * @param target The target permutation
     * @return The permutation at the target for the digits 0-9
     */
    private static String solvePermutation(int target) {
        // number of digits that have been determined
        int determinedDigits = 0;
        // stores the permutation at the target
        String answer = "";
        // array storing the factorial of each digit 0-9
        int[] factorialArray = new int[10];
        // ArrayList containing all the numbers in the permutation
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        // initialize numbers ArrayList with the digits 0-9
        for (int index = 0; index < TOTAL_DIGITS; index++) {
            numbers.add(index);
        }

        // initialize factorial array with the factorials for each digit
        for (int index = 0; index < factorialArray.length; index++) {
            factorialArray[index] = factorial(index);
        }

        // loop while the target value is not zero
        while (target != 0) {
            // loop through all the digits
            for (int counter = 1; counter < TOTAL_DIGITS; counter++) {
                // find the lowest factorial that is smaller than the target and subtract
                if (target - factorialArray[factorialArray.length - determinedDigits - 1] * counter > 0) {
                } else {
                    target -= factorialArray[factorialArray.length - determinedDigits - 1] * (counter - 1);
                    determinedDigits++;
                    answer += numbers.get(counter - 1);
                    numbers.remove(counter - 1);
                    break;
                }
            }
            // check if the permutation is complete
            if (numbers.size() == 1) {
                answer += numbers.get(0);
                target = 0;
            }
        }

        return answer;
    }

    /**
     * This method finds the factorial of a number.
     * 
     * @param value The number in question
     * @return The factorial for the number
     */
    private static int factorial(int number) {
        // base case for recursion
        if (number == 0) {
            return 1;
        }

        return number * factorial(number - 1);
    }

}