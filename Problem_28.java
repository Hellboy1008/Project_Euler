
/**
 * Created by: 龍ONE 
 * Date Created: January 31, 2019
 * Date Edited: July 4, 2020
 * Purpose: Solution to Project Euler Problem 28
 */

/**
 * This class contains a method that calculates sum of the numbers on the
 * diagonals in a n x n spiral. The main method executes the program.
 */
public class Problem_28 {

    // the square value for length 2 diagonal
    private static final int LENGTH_TWO_DIAGONAL_SQUARE = 3;
    // multiplier for the equations used to solve problem
    private static final int MULTIPLIER_FOUR = 4;
    // the increment for the square value every time the length of the diagonal
    // increases
    private static final int SIZE_INCREMENT = 2;
    // the spiral size for the problem
    private static final int SPIRAL_SIZE = 1001;

    // conversion from nanoseconds to seconds
    private static final long TIME_CONVERSION = 1000000000;

    // answer prompt
    private static final String ANSWER = "The sum of the diagonal in the " + SPIRAL_SIZE + " x " + SPIRAL_SIZE
            + " is: ";
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
        solution = calculateDiagonalSum(SPIRAL_SIZE);
        endTime = System.nanoTime();

        // print answer and time taken
        System.out.println(ANSWER + solution);
        System.out.printf(TIME_TAKEN, (double) (endTime - startTime) / TIME_CONVERSION);
    }

    /**
     * Calculates sum of the numbers on the diagonals in a n x n spiral, where n is
     * the size.
     * 
     * @param size The size of the spiral
     * @return The sum of the numbers on the diagonals
     */
    private static int calculateDiagonalSum(int size) {
        // the sum of the diagonals (starting at 1 for the central number)
        int diagonalSum = 1;
        // holds the length of each diagonal
        int lengthOfDiagonal = 1;

        // calculates the length of the diagonals
        for (int counter = LENGTH_TWO_DIAGONAL_SQUARE; counter <= size; counter += SIZE_INCREMENT) {
            lengthOfDiagonal++;
        }

        // calculates the sum of the diagonals for each corner
        for (int counter = 1; counter <= lengthOfDiagonal - 1; counter++) {
            // value of upper left diagonal
            diagonalSum += MULTIPLIER_FOUR * counter * counter + SIZE_INCREMENT * counter + 1;
            // value of lower left diagonal
            diagonalSum += MULTIPLIER_FOUR * counter * counter + 1;
            // value of upper right diagonal
            diagonalSum += MULTIPLIER_FOUR * counter * counter + MULTIPLIER_FOUR * counter + 1;
            // value of lower right diagonal
            diagonalSum += MULTIPLIER_FOUR * counter * counter - SIZE_INCREMENT * counter + 1;
        }

        return diagonalSum;
    }

}