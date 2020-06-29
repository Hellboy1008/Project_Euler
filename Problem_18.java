
/**
 * Created by: 龍ONE 
 * Date Created: December 25, 2018
 * Date Edited: June 29, 2020
 * Purpose: Solution to Project Euler Problem 18
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class contains a method that finds the maximum total from top to bottom
 * of a pyramid containing numbers. The main method executes the program.
 */
public class Problem_18 {

    // conversion from nanoseconds to seconds
    private static final long TIME_CONVERSION = 1000000000;

    // answer prompt
    private static final String ANSWER = "The maximum total from top to bottom is: ";
    // time take to solve the problem
    private static final String TIME_TAKEN = "Time Taken:%s seconds";

    // input file
    private static final File INPUT_FILE = new File("./Problem_18_Input.txt");

    /**
     * The main method executes the solution and prints it alongside the time taken
     * to solve the program.
     * 
     * @param args The arguments given to the main method
     * @return None
     * @throws FileNotFoundException Throws error if file not found
     */
    public static void main(String[] args) throws FileNotFoundException {
        // solution for the problem
        int solution;
        // end time of the program
        long endTime;
        // start time of the program
        long startTime;

        startTime = System.nanoTime();
        solution = findMaxTotal(getPyramid(INPUT_FILE));
        endTime = System.nanoTime();

        // print answer and time taken
        System.out.println(ANSWER + solution);
        System.out.printf(TIME_TAKEN, (double) (endTime - startTime) / TIME_CONVERSION);
    }

    /**
     * Finds the maximum total from the top to the bottom of a pyramid.
     * 
     * @param pyramid The pyramid in question
     * @return The maximum total from the top to the bottom
     */
    private static int findMaxTotal(int[][] pyramid) {
        // max total
        int max;

        // shrink the pyramid by adding the max values from the bottom of the pyramid
        for (int indexOne = pyramid.length - 1 - 1; indexOne > 0; indexOne--) {
            for (int indexTwo = 0; indexTwo < pyramid[indexOne].length; indexTwo++) {
                // add the value that is the larger of the two possible outcomes
                if (pyramid[indexOne][indexTwo] + pyramid[indexOne + 1][indexTwo] > pyramid[indexOne][indexTwo]
                        + pyramid[indexOne + 1][indexTwo + 1]) {
                    pyramid[indexOne][indexTwo] = pyramid[indexOne][indexTwo] + pyramid[indexOne + 1][indexTwo];
                } else {
                    pyramid[indexOne][indexTwo] = pyramid[indexOne][indexTwo] + pyramid[indexOne + 1][indexTwo + 1];
                }
            }
        }

        // calculate largest sum
        if (pyramid[1][0] > pyramid[1][1]) {
            max = pyramid[0][0] + pyramid[1][0];
        } else {
            max = pyramid[0][0] + pyramid[1][1];
        }

        return max;
    }

    /**
     * This method gets the pyramid from the file.
     * 
     * @param inputFile The file being read
     * @return A 2d array containing the pyramid
     * @throws FileNotFoundException Throws error if file not found
     */
    private static int[][] getPyramid(File inputFile) throws FileNotFoundException {
        // number of lines in file
        int numOfLines = 0;
        // temp array for each column in pyramid
        int[] temp;
        // the pyramid
        int[][] pyramid;
        // the scanner used to read the file
        Scanner scan = new Scanner(inputFile);

        // read the number of lines in file
        while (scan.hasNextLine() == true) {
            numOfLines++;
            scan.nextLine();
        }
        scan.close();

        // create pyramid array and new scanner
        pyramid = new int[numOfLines][];
        scan = new Scanner(inputFile);

        // add the numbers in the file into the pyramid
        for (int indexOne = 0; indexOne < pyramid.length; indexOne++) {
            temp = new int[indexOne + 1];
            // read the integers in the row
            for (int indexTwo = 0; indexTwo < temp.length; indexTwo++) {
                temp[indexTwo] = scan.nextInt();
            }
            pyramid[indexOne] = temp;
        }

        // close scanner
        scan.close();

        return pyramid;
    }

}