
/**
 * Created by: 龍ONE
 * Date Created: February 5, 2019
 * Date Edited: July 9, 2020
 * Purpose: Solution to Project Euler Problem 34
 */

/**
 * This class contains method(s) that finds the sum of all numbers which are
 * equal to the sum of the factorial of their digits (curious numbers). The main
 * method executes the program.
 */
public class Problem_34 {

    // used for stripping numbers
    private static final int DIVISOR_TEN = 10;
    // lower bound for the problem
    private static final int LOWER_BOUND = 3;
    // upper bound for the problem
    private static final int UPPER_BOUND = 2540160;

    // the factorials for the digits 0-9
    private static final int[] FACTORIAL_VALUES = { 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880 };

    // conversion from nanoseconds to seconds
    private static final long TIME_CONVERSION = 1000000000;

    // answer prompt
    private static final String ANSWER = "The sum of all curious numbers is: ";
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
        solution = findCuriousNumbersSum(LOWER_BOUND, UPPER_BOUND);
        endTime = System.nanoTime();

        // print answer and time taken
        System.out.println(ANSWER + solution);
        System.out.printf(TIME_TAKEN, (double) (endTime - startTime) / TIME_CONVERSION);
    }

    /**
     * Calculates the sum of all the curious numbers.
     * 
     * @param lowerBound The lower bound for the problem
     * @param upperBound The upper bound for the problem
     * @return The sum of the curious numbers
     */
    private static int findCuriousNumbersSum(int lowerBound, int upperBound) {
        // the sum of the curious numbers
        int curiousNumberSum = 0;
        // sum of the factorials for a number
        int factorialSum;
        // temp value to hold a number
        int tempNum;

        // loop through all possible values
        for (int num = lowerBound; num < upperBound; num++) {
            tempNum = num;
            factorialSum = 0;
            // check if the sum of factorials is greater than the number itself
            if (FACTORIAL_VALUES[tempNum % DIVISOR_TEN] > num) {
                continue;
            }
            // find the factorial sum for a number
            while (tempNum != 0) {
                // check if the sum of factorials is greater than the number itself
                if (FACTORIAL_VALUES[tempNum % DIVISOR_TEN] > num) {
                    break;
                }
                factorialSum += FACTORIAL_VALUES[tempNum % DIVISOR_TEN];
                tempNum /= DIVISOR_TEN;
            }
            // check if the sum of the factorials is equal to the original number
            if (factorialSum == num) {
                curiousNumberSum += num;
            }
        }

        return curiousNumberSum;
    }

}