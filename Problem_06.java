
/**
 * Created by: 龍ONE 
 * Date Created: Jan 3, 2018
 * Date Edited: July 2, 2020
 * Purpose: Solution to Project Euler Problem 6
 */

/**
 * This class contains a method that calculates the difference between the sum
 * of squares of the first n natural numbers and the square of the sum. The main
 * method executes the program.
 */
public class Problem_06 {

    // divisors for equation
    private static final int DIVISOR_TWO = 2;
    private static final int DIVISOR_SIX = 6;
    // multipliers for equation
    private static final int MULTIPLIER_TWO = 2;
    private static final int MULTIPLIER_THREE = 3;
    // upper bound for the problem
    private static final int UPPER_BOUND = 100;

    // conversion from nanoseconds to seconds
    private static final long TIME_CONVERSION = 1000000000;

    // answer prompt
    private static final String ANSWER = "The difference is for the first " + UPPER_BOUND + " natural numbers is: ";
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
        solution = Math.abs(sumOfSquares(UPPER_BOUND) - sumOfNumbers(UPPER_BOUND) * sumOfNumbers(UPPER_BOUND));
        endTime = System.nanoTime();

        // print answer and time taken
        System.out.println(ANSWER + solution);
        System.out.printf(TIME_TAKEN, (double) (endTime - startTime) / TIME_CONVERSION);
    }

    /**
     * This method finds the sum of the natural numbers from 1 to upper_bound using
     * the equation (n^2+n)/2.
     * 
     * @param upper_bound The upper bound for the sum
     * @return The sum of the first upper_bound natural numbers
     */
    private static int sumOfNumbers(int upper_bound) {
        return (upper_bound * upper_bound + upper_bound) / DIVISOR_TWO;
    }

    /**
     * This method finds the sum of the squares of the first upper_bound natural
     * numbers using the equation (2n^3+3n^2+n)/6
     * 
     * @param upper_bound The upper bound for the sum
     * @return The sum of the squares of the first upper_bound natural numbers
     */
    private static int sumOfSquares(int upper_bound) {
        return (int) (MULTIPLIER_TWO * Math.pow(upper_bound, 3) + MULTIPLIER_THREE * Math.pow(upper_bound, 2)
                + upper_bound) / DIVISOR_SIX;
    }
}