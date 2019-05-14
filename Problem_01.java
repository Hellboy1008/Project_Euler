
/**
 * Created by: 龍ONE 
 * Date Created: Oct 12, 2017
 * Date Edited: May 12, 2019
 * Purpose: Solution to Project Euler Problem 1
 */

/**
 * This class contains a method that calculates the sum of a multiple as well as
 * the main method that executes the program.
 */
public class Problem_01 {

    // upper limit for the problem
    private static final int LIMIT = 1000;
    // holds the multiple three
    private static final int MULTIPLE_THREE = 3;
    // holds the multiple five
    private static final int MULTIPLE_FIVE = 5;

    // conversion from nanoseconds to seconds
    private static final long TIME_CONVERSION = 1000000000;

    // answer prompt
    private static final String ANSWER = "The sum of all multiples of 3 or 5 below 1000 is: ";
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
        // total sum for the problem
        int totalSum;
        // end time of the program
        long endTime;
        // start time of the program
        long startTime;

        startTime = System.nanoTime();
        totalSum = sumOfMultiples(MULTIPLE_THREE, LIMIT) + sumOfMultiples(MULTIPLE_FIVE, LIMIT)
                - sumOfMultiples(MULTIPLE_THREE * MULTIPLE_FIVE, LIMIT);
        endTime = System.nanoTime();

        // print answer and time taken
        System.out.println(ANSWER + totalSum);
        System.out.printf(TIME_TAKEN, (double) (endTime - startTime) / TIME_CONVERSION);
    }

    /**
     * This method calculates the sum of all the multiples of a certain number below
     * the limit. It uses the mathematical equation for the sum of first n natural
     * numbers.
     * 
     * @param multiple The multiple being calculated
     * @param limit    The limit for the sum
     * @return The sum of all the multiples of a number below the limit
     */
    private static int sumOfMultiples(int multiple, int limit) {
        // the maximum for the sum
        int max;
        // the sum
        int sum = 0;

        // calculate the maximum
        if (limit % multiple == 0) {
            max = limit / multiple - 1;
        } else {
            max = limit / multiple;
        }

        // calculate the sum
        sum = multiple * (max * (max + 1)) / 2;

        return sum;
    }
}