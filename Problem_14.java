
/**
 * Created by: 龍ONE 
 * Date Created: Jan 24, 2018
 * Date Edited: July 9, 2020
 * Purpose: Solution to Project Euler Problem 14
 */

/**
 * This class contains method(s) that calculates the longest Collatz sequence
 * chain for a starting number under n. The main method executes the program.
 */
public class Problem_14 {

    // divisor for Collatz sequence
    private static final int DIVISOR_TWO = 2;
    // multiplier for Collatz sequence
    private static final int MULTIPLIER_THREE = 3;

    // lower bound for the problem
    private static final long LOWER_BOUND = 10;
    // conversion from nanoseconds to seconds
    private static final long TIME_CONVERSION = 1000000000;
    // upper bound for the problem
    private static final long UPPER_BOUND = 1000000;

    // answer prompt
    private static final String ANSWER = "The longest chain for a starting number under " + UPPER_BOUND
            + " is produced by: ";
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
        // end time of the program
        long endTime;
        // solution for the problem
        long solution;
        // start time of the program
        long startTime;

        startTime = System.nanoTime();
        solution = maxCollatzSequence(LOWER_BOUND, UPPER_BOUND);
        endTime = System.nanoTime();

        // print answer and time taken
        System.out.println(ANSWER + solution);
        System.out.printf(TIME_TAKEN, (double) (endTime - startTime) / TIME_CONVERSION);
    }

    /**
     * This method finds the length of the Collatz sequence for a number.
     * 
     * @param number The number being checked
     * @return The length of the Collatz sequence
     */
    private static int collatzSequenceCount(long number) {
        // length of sequence
        int length = 0;

        while (number != 1) {
            if (number % DIVISOR_TWO == 0) {
                number /= DIVISOR_TWO;
                length++;
            } else {
                number = MULTIPLIER_THREE * number + 1;
                length++;
            }
        }

        return length;
    }

    /**
     * This method finds the number with the maximum Collatz sequence.
     * 
     * @param lower_bound The lower bound for the integers being checked
     * @param upper_bound The upper bound for the integers being checked
     * @return The integer between lower and upper bound with the longest Collatz
     *         sequence
     */
    private static long maxCollatzSequence(long lower_bound, long upper_bound) {
        // length of individual Collatz sequence
        int length = 0;
        // maximum length of Collatz sequence
        int maxLength = 0;
        // integer with the maximum Collatz sequence
        long maxNum = 0;

        // Iterate through all numbers from lower to upper bound
        for (long counter = lower_bound; counter < upper_bound; counter++) {
            length = collatzSequenceCount(counter);
            if (length > maxLength) {
                maxLength = length;
                maxNum = counter;
            }
        }

        return maxNum;
    }
}