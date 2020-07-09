
/**
 * Created by: 龍ONE 
 * Date Created: December 22, 2018
 * Date Edited: July 9, 2020
 * Purpose: Solution to Project Euler Problem 15
 */

/**
 * This class contains method(s) that calculates the number of possible routes in
 * a n by n square grid. The main method executes the program.
 */
public class Problem_15 {

    // size of the grid in the problem
    private static final int GRID_SIZE = 20;

    // conversion from nanoseconds to seconds
    private static final long TIME_CONVERSION = 1000000000;

    // answer prompt
    private static final String ANSWER = "The total number of routes through a " + GRID_SIZE + " x " + GRID_SIZE
            + " grid is: ";
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
        solution = (long) gridRoutes(GRID_SIZE);
        endTime = System.nanoTime();

        // print answer and time taken
        System.out.println(ANSWER + solution);
        System.out.printf(TIME_TAKEN, (double) (endTime - startTime) / TIME_CONVERSION);
    }

    /**
     * This method finds the factorial of a number.
     * 
     * @param value The number in question
     * @return The factorial for the number
     */
    private static double factorial(double number) {
        // base case for recursion
        if (number == 0) {
            return 1;
        }

        return number * factorial(number - 1);
    }

    /**
     * This method finds the total number of grid routes possible for a square grid.
     * 
     * @param gridSize The size of the grid
     * @return The total possible routes of a square grid
     */
    private static double gridRoutes(double gridSize) {
        return factorial(gridSize + gridSize) / (factorial(gridSize) * factorial(gridSize));
    }

}