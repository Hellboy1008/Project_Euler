
/**
 * Created by: 龍ONE 
 * Date Created: January 17, 2019
 * Date Edited: July 5, 2020
 * Purpose: Solution to Project Euler Problem 23
 */

import java.util.ArrayList;

/**
 * This class contains a method that calculates the sum of all positive integers
 * which cannot be written as the sum of two abundant numbers. The main method
 * executes the program.
 */
public class Problem_23 {

    // lower bound for the problem
    private static final int LOWER_BOUND = 2;
    // upper bound for the problem
    private static final int UPPER_BOUND = 28123;

    // conversion from nanoseconds to seconds
    private static final long TIME_CONVERSION = 1000000000;

    // answer prompt
    private static final String ANSWER = "The sum of all positive integers which cannot be written as the"
            + " sum of two abundant numbers is: ";
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
        solution = totalSum(UPPER_BOUND, findAbundantNumbers(LOWER_BOUND, UPPER_BOUND));
        endTime = System.nanoTime();

        // print answer and time taken
        System.out.println(ANSWER + solution);
        System.out.printf(TIME_TAKEN, (double) (endTime - startTime) / TIME_CONVERSION);
    }

    /**
     * Creates an ArrayList that contains all abundant numbers between lower and
     * upper bound (exclusive).
     * 
     * @param lower_bound The lower bound for the abundant numbers
     * @param upper_bound The upper bound for the abundant numbers
     * @return An ArrayList with all abundant numbers between lower and upper bound
     */
    private static ArrayList<Integer> findAbundantNumbers(int lower_bound, int upper_bound) {
        // sum of the factors for a certain number
        int factorSum;
        // ArrayList containing all abundant numbers between lower and upper
        ArrayList<Integer> abundantNumbers = new ArrayList<Integer>();

        // loops through all the numbers
        for (int num = lower_bound; num < upper_bound; num++) {
            factorSum = 0;
            // calculates the sum of factors
            for (int counter = 1; counter <= Math.sqrt(num); counter++) {
                // if the counter value is a factor
                if (num % counter == 0) {
                    factorSum += counter;
                    // if the counter value is not 1 or a duplicate (for square numbers)
                    if (counter != 1 && counter != (num / counter)) {
                        factorSum += (num / counter);
                    }
                }
            }
            // check if the number is indeed an abundant number
            if (factorSum > num) {
                abundantNumbers.add(num);
            }
        }

        return abundantNumbers;
    }

    /**
     * Sums the all the positive integers which cannot be written as the sum of two
     * abundant numbers.
     * 
     * @param upper_bound     The upper bound for the calculation
     * @param abundantNumbers An ArrayList containing a list of abundant numbers
     * @return The sum of all positive integers which cannot be written as a sum of
     *         two abundant numbers
     */
    private static int totalSum(int upper_bound, ArrayList<Integer> abundantNumbers) {
        // sum for the addition of two abundant numbers
        int abundantNumSum = 0;
        // total sum for the integers
        int totalSum = 0;
        // contains whether a number can be written as a sum of abundant numbers
        boolean[] sumOfAbundantNumbers = new boolean[upper_bound + 1];

        // loops through the ArrayList of abundant numbers
        for (int element = 0; element < abundantNumbers.size() - 1; element++) {
            // loops through the ArrayList again for th sum
            for (int index = element; index < abundantNumbers.size(); index++) {
                abundantNumSum = abundantNumbers.get(element) + abundantNumbers.get(index);
                // sets the value of the sum as true in the boolean array
                if (abundantNumSum <= upper_bound) {
                    sumOfAbundantNumbers[abundantNumSum] = true;
                }
            }
        }

        // loops through the boolean array
        for (int index = 0; index < sumOfAbundantNumbers.length; index++) {
            // if the integer cannot be written as a sum of two abundant numbers, add to
            // total sum
            if (sumOfAbundantNumbers[index] == false) {
                totalSum += index;
            }
        }

        return totalSum;
    }

}