
/**
 * Created by: 龍ONE 
 * Date Created: February 8, 2019 
 * Date Edited: July 9, 2020
 * Purpose: Solution to Project Euler Problem 36
 */

import java.lang.StringBuilder;
import java.util.ArrayList;

/**
 * This class contains a method that finds the sum of all numbers less than n
 * which are palindromic in base 10 and base 2. The main method executes the
 * program.
 */
public class Problem_36 {

    // used to strip numbers
    private static final int DIV_10 = 10;
    // upper bound for the problem
    private static final int UPPER_BOUND = 1000000;

    // conversion from nanoseconds to seconds
    private static final long TIME_CONVERSION = 1000000000;

    // answer prompt
    private static final String ANSWER = "The sum of all numbers less than " + UPPER_BOUND
            + " which are palindromic in base 10 and base 2 is: ";
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
        solution = findPalindromesBase2(findPalindromesBase10(UPPER_BOUND));
        endTime = System.nanoTime();

        // print answer and time taken
        System.out.println(ANSWER + solution);
        System.out.printf(TIME_TAKEN, (double) (endTime - startTime) / TIME_CONVERSION);
    }

    /**
     * Finds all the numbers below the upperBound that are palindromic in base 10.
     * 
     * @param upperBound The upper bound for the problem
     * @return ArrayList containing numbers that are palindromic in base 10
     */
    private static ArrayList<Integer> findPalindromesBase10(int upperBound) {
        // the reverse of a number
        int reverseNum;
        // temp variable to hold a number
        int tempNum;
        // holds all the numbers in base 10 below the limit that are a palindrome
        ArrayList<Integer> palindromicNumbers = new ArrayList<Integer>();

        // loop through all possible values
        for (int num = 0; num < upperBound; num++) {
            tempNum = num;
            reverseNum = 0;
            // find the reverse of a number
            while (tempNum >= 1) {
                reverseNum = reverseNum * DIV_10 + tempNum % DIV_10;
                tempNum /= DIV_10;
            }
            // check if the number is a palindrome
            if (num == reverseNum) {
                palindromicNumbers.add(num);
            }
        }

        return palindromicNumbers;
    }

    /**
     * Finds the sum of all numbers in the ArrayList that are palindromic in base 2.
     * 
     * @param palindromicNumbers ArrayList containing numbers that are palindromic
     *                           in base 10
     * @return Sum of all numbers in the ArrayList that are palindromic in base 2
     */
    private static int findPalindromesBase2(ArrayList<Integer> palindromicNumbers) {
        // sum of the all the numbers that are also palindromic in base 2
        int sum = 0;
        // StringBuilder for the base 2 representation of a number
        StringBuilder binaryRepresentation;

        // loop through all numbers that are palindromic in base 10
        for (int index = 0; index < palindromicNumbers.size(); index++) {
            binaryRepresentation = new StringBuilder(Integer.toBinaryString(palindromicNumbers.get(index)));
            // check if the base 2 representation is also palindromic
            if (binaryRepresentation.toString().equals(binaryRepresentation.reverse().toString())) {
                sum += palindromicNumbers.get(index);
            }
        }

        return sum;
    }

}