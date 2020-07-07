
/**
 * Created by: 龍ONE
 * Date Created: February 1, 2019
 * Date Edited: July 7, 2020
 * Purpose: Solution to Project Euler Problem 31
 */

/**
 * This class contains a method that calculates the number of ways n pounds can
 * be made using any number of coins in the UK currency. The main method
 * executes the program.
 */
public class Problem_31 {

    // the number of pounds for the problem
    private static final int POUNDS = 2;
    // conversion from pounds to pence
    private static final int POUNDS_TO_PENCE = 100;

    // coins in the UK currency in pennies
    private static final int[] COINS = { 1, 2, 5, 10, 20, 50, 100, 200 };

    // conversion from nanoseconds to seconds
    private static final long TIME_CONVERSION = 1000000000;

    // answer prompt
    private static final String ANSWER = "The total number of ways for " + POUNDS + " pounds is: ";
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
        solution = createArray(POUNDS * POUNDS_TO_PENCE);
        endTime = System.nanoTime();

        // print answer and time taken
        System.out.println(ANSWER + solution);
        System.out.printf(TIME_TAKEN, (double) (endTime - startTime) / TIME_CONVERSION);
    }

    /**
     * Calculates the number of ways the UK currency can express n pennies using
     * just coins.
     * 
     * @param pennies The amount of pennies to be expressed
     * @return The number of ways to express the pennies using coins
     */
    private static int createArray(int pennies) {
        // create array that stores the number of ways a penny can be expressed
        int[][] numOfWays = new int[pennies + 1][COINS.length];

        // set all values for the first column to 1
        for (int row_index = 0; row_index < numOfWays.length; row_index++) {
            numOfWays[row_index][0] = 1;
        }

        // loop through the rest of the rows in array
        for (int row_index = 0; row_index < numOfWays.length; row_index++) {
            // loop through the rest of the columns in array
            for (int column_index = 1; column_index < numOfWays[row_index].length; column_index++) {
                // add number of ways for each new coin when applicable
                if (row_index >= COINS[column_index]) {
                    numOfWays[row_index][column_index] += numOfWays[row_index][column_index - 1];
                    numOfWays[row_index][column_index] += numOfWays[row_index - COINS[column_index]][column_index];
                } else {
                    numOfWays[row_index][column_index] = numOfWays[row_index][column_index - 1];
                }
            }
        }

        return numOfWays[numOfWays.length - 1][numOfWays[0].length - 1];
    }

}