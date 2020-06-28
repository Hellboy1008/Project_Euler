
/**
 * Created by: 龍ONE 
 * Date Created: December 25, 2018
 * Date Edited: June 28, 2020
 * Purpose: Solution to Project Euler Problem 17
 */

/**
 * This class contains a method that calculates the number of letters used to
 * write out the numbers 1 to 1000 (inclusive) in words. The main method
 * executes the program.
 */
public class Problem_17 {

    // length of the word "and"
    private static final int AND_LENGTH = 3;
    // end value for the question
    private static final int END_VAL = 1000;
    // constant for the value 100
    private static final int HUNDRED = 100;
    // length of the word "hundred"
    private static final int HUNDRED_LENGTH = 7;
    // constant for the value 10
    private static final int TEN = 10;
    // constant for the value 1000
    private static final int THOUSAND = 1000;
    // length of the word "thousand"
    private static final int THOUSAND_LENGTH = 8;

    // conversion from nanoseconds to seconds
    private static final long TIME_CONVERSION = 1000000000;

    // answer prompt
    private static final String ANSWER = "The total number of letter used is: ";
    // time take to solve the problem
    private static final String TIME_TAKEN = "Time Taken:%s seconds";

    // length of one through nine in words
    private static final int[] ONE_TO_NINE = { 3, 3, 5, 4, 4, 3, 5, 5, 4 };
    // length of ten through nineteen in words
    private static final int[] TEN_TO_NINETEEN = { 3, 6, 6, 8, 8, 7, 7, 9, 8, 8 };
    // length of twenty to ninety in words
    private static final int[] TWENTY_TO_NINETY = { 6, 6, 5, 5, 5, 7, 6, 6 };

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
        solution = sumOfWords(END_VAL);
        endTime = System.nanoTime();

        // print answer and time taken
        System.out.println(ANSWER + solution);
        System.out.printf(TIME_TAKEN, (double) (endTime - startTime) / TIME_CONVERSION);
    }

    /**
     * Calculates the number of letters used to spell out the number in English.
     * 
     * @param number The number in question
     * @return The number of letters used to spell the number
     */
    private static int lengthOfNum(int number) {
        // the digit extracted out of tenth or hundredth place
        int digit;

        // if the number is zero, return 0
        if (number == 0) {
            return 0;
        }

        // if the number is less than 10
        if (number % TEN == number) {
            return ONE_TO_NINE[number - 1];
        }

        // if the number is between 10 and 99 (inclusive)
        if (number % HUNDRED == number) {
            digit = number / TEN;

            // check if it is between ten and nineteen
            if (digit == 1) {
                return TEN_TO_NINETEEN[number % TEN];
            }

            return TWENTY_TO_NINETY[digit - 1 - 1] + lengthOfNum(number % TEN);
        }

        // if the number is between 100 and 999 (inclusive)
        if (number % THOUSAND == number) {
            digit = number / HUNDRED;

            // if the number is a multiple of 100
            if (number % 100 == 0) {
                return ONE_TO_NINE[digit - 1] + HUNDRED_LENGTH;
            }

            return ONE_TO_NINE[digit - 1] + HUNDRED_LENGTH + AND_LENGTH + lengthOfNum(number - HUNDRED * digit);
        }

        // if the number is 1000
        if (number == THOUSAND) {
            return ONE_TO_NINE[0] + THOUSAND_LENGTH;
        }

        return 0;
    }

    /**
     * Calculates the number of letters used to spell out each word from one to the
     * end value (inclusive) in English.
     * 
     * @param endVal The end value for the calculation
     * @return The total number of letters used
     */
    private static int sumOfWords(int endVal) {
        // sum of the words
        int sum = 0;

        // run through all numbers from 1 to endVal (inclusive)
        for (int index = 1; index <= endVal; index++) {
            sum += lengthOfNum(index);
        }

        return sum;
    }

}