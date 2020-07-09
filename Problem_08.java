
/**
 * Created by: 龍ONE 
 * Date Created: Jan 15, 2018
 * Date Edited: July 9, 2020
 * Purpose: Solution to Project Euler Problem 8
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class contains method(s) that calculates the greatest product of n
 * adjacent values in a large number. The main method executes the program.
 */
public class Problem_08 {

    // the number of adjacent values specified in the problem
    private static final int ADJACENT_VALUES = 13;

    // conversion from nanoseconds to seconds
    private static final long TIME_CONVERSION = 1000000000;

    // answer prompt
    private static final String ANSWER = "The maximum product of " + ADJACENT_VALUES
            + " adjacent digits in this 1000 digit number is: ";
    // time take to solve the problem
    private static final String TIME_TAKEN = "Time Taken: %s seconds";

    // input file
    private static final File INPUT_FILE = new File("./Problem_08_Input.txt");

    /**
     * The main method executes the solution and prints it alongside the time taken
     * to solve the program.
     * 
     * @param args The arguments given to the main method
     * @return None
     */
    public static void main(String[] args) throws FileNotFoundException {
        // end time of the program
        long endTime;
        // solution for the problem
        long solution;
        // start time of the program
        long startTime;

        startTime = System.nanoTime();
        solution = findMaxProduct(getInputNum(INPUT_FILE), ADJACENT_VALUES);
        endTime = System.nanoTime();

        // print answer and time taken
        System.out.println(ANSWER + solution);
        System.out.printf(TIME_TAKEN, (double) (endTime - startTime) / TIME_CONVERSION);
    }

    /**
     * This method finds the maximum product of n adjacent values given the input.
     * 
     * @param input    The input for the search
     * @param adjacent The number of adjacent values for the product
     * @return The maximum product of n adjacent values in a string of numbers
     */
    private static long findMaxProduct(int[] input, int adjacent) {
        // the maximum product
        long maximum_product = 0;
        // the individual products of the adjacent digits
        long product = 1;

        // Calculate answer using the digits in the array
        for (int counter = 0; counter <= input.length - ADJACENT_VALUES; counter++) {
            product = 1;
            for (int counterTwo = counter; counterTwo < counter + ADJACENT_VALUES; counterTwo++) {
                product *= input[counterTwo];
            }
            if (product > maximum_product) {
                maximum_product = product;
            }
        }

        return maximum_product;
    }

    /**
     * This methods gets the input from a file.
     * 
     * @param inputFile The input file used for the problem
     * @return An array containing the digits of the input
     * @throws FileNotFoundException
     */
    private static int[] getInputNum(File inputFile) throws FileNotFoundException {
        // the input in the file
        String input = "";
        // the array containing each digit in the file
        int[] inputNum;
        // the scanner used to read the file
        Scanner scan = new Scanner(inputFile);

        // reads the file and gets all the digits
        while (scan.hasNextLine()) {
            input = input + scan.next();
        }
        scan.close();

        // fill int array with digits
        inputNum = new int[input.length()];
        for (int index = 0; index < inputNum.length; index++) {
            inputNum[index] = Character.getNumericValue(input.charAt(index));
        }

        return inputNum;
    }
}