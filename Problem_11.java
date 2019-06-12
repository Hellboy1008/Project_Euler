
/**
 * Created by: 龍ONE 
 * Date Created: Jan 22, 2018
 * Date Edited: June 9, 2019
 * Purpose: Solution to Project Euler Problem 11
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class contains a method that calculates the maximum product in a grid.
 * The main method executes the program.
 */
public class Problem_11 {

    // number of adjacent numbers
    private static final int ADJACENT_NUM = 4;

    // conversion from nanoseconds to seconds
    private static final long TIME_CONVERSION = 1000000000;

    // answer prompt
    private static final String ANSWER = "The greatest product is: ";
    // time take to solve the problem
    private static final String TIME_TAKEN = "Time Taken:%s seconds";

    // input file
    private static final File INPUT_FILE = new File("./Problem_11_Input.txt");

    /**
     * The main method executes the solution and prints it alongside the time taken
     * to solve the program.
     * 
     * @param args The arguments given to the main method
     * @return None
     */
    public static void main(String[] args) throws FileNotFoundException {
        // solution for the problem
        int solution;
        // end time of the program
        long endTime;
        // start time of the program
        long startTime;

        startTime = System.nanoTime();
        solution = findMaxProduct(getGrid(INPUT_FILE), ADJACENT_NUM);
        endTime = System.nanoTime();

        // print answer and time taken
        System.out.println(ANSWER + solution);
        System.out.printf(TIME_TAKEN, (double) (endTime - startTime) / TIME_CONVERSION);
    }

    /**
     * This method returns the maximum product of n adjacent values in a grid.
     * 
     * @param grid The grid with the values
     * @return The maximum product of n adjacent values in the grid
     */
    private static int findMaxProduct(int[][] grid, int adjacentValues) {
        // maximum product in grid
        int maxProduct = 0;
        // product of each adjacent value
        int product = 0;

        // decrement adjacent values by one to match index
        adjacentValues--;

        // Check for largest product upwards/downwards
        for (int row = adjacentValues; row < grid.length - adjacentValues; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                product = grid[row][column] * grid[row + 1][column] * grid[row + (adjacentValues - 1)][column]
                        * grid[row + adjacentValues][column];
                if (product > maxProduct) {
                    maxProduct = product;
                }
            }
        }

        // Check for largest product left/right
        for (int row = 0; row < grid.length; row++) {
            for (int column = adjacentValues; column < grid[0].length - adjacentValues; column++) {
                product = grid[row][column] * grid[row][column - 1] * grid[row][column - (adjacentValues - 1)]
                        * grid[row][column - adjacentValues];
                if (product > maxProduct) {
                    maxProduct = product;
                }
            }
        }

        // Check for largest product diagonally (diagonal from left -> \)
        for (int row = 0; row < grid.length - adjacentValues; row++) {
            for (int column = 0; column < grid[0].length - adjacentValues; column++) {
                product = grid[row][column] * grid[row + 1][column + 1]
                        * grid[row + (adjacentValues - 1)][column + (adjacentValues - 1)]
                        * grid[row + adjacentValues][column + adjacentValues];
                if (product > maxProduct) {
                    maxProduct = product;
                }
            }
        }

        // Check for largest product diagonally (diagonal from right -> /)
        for (int row = 0; row < grid.length - adjacentValues; row++) {
            for (int column = grid[0].length - 1; column > (adjacentValues - 1); column--) {
                product = grid[row][column] * grid[row + 1][column - 1]
                        * grid[row + (adjacentValues - 1)][column - (adjacentValues - 1)]
                        * grid[row + adjacentValues][column - adjacentValues];
                if (product > maxProduct) {
                    maxProduct = product;
                }
            }
        }

        return maxProduct;
    }

    /**
     * This method reads a file with the grid and returns the grid as a 2D array.
     * 
     * @param inputFile The file being read
     * @return The grid as a 2D array
     */
    private static int[][] getGrid(File inputFile) throws FileNotFoundException {
        // number of lines in file
        int numOfLines = 0;
        // grid read from the file
        int[][] grid;
        // the scanner used to read the file
        Scanner scan = new Scanner(inputFile);

        // read the number of lines in file
        while (scan.hasNextLine() == true) {
            numOfLines++;
            scan.nextLine();
        }
        scan.close();

        // create grid
        grid = new int[numOfLines][numOfLines];

        // put numbers into grid
        scan = new Scanner(inputFile);
        while (scan.hasNextLine() == true) {
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[row].length; col++) {
                    grid[row][col] = scan.nextInt();
                }
            }
        }
        scan.close();

        return grid;
    }
}