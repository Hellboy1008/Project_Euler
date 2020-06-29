
/**
 * Created by: 龍ONE 
 * Date Created: Jan 23, 2018
 * Date Edited: June 29, 2020
 * Purpose: Solution to Project Euler Problem 13
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class contains a method that calculates the the first ten digits of the
 * sum of n 50 digit numbers. The main method executes the program.
 */
public class Problem_13 {

    // divisor for dividing by ten
    private static final int DIVISOR_TEN = 10;
    // the relevant digits for the sum
    private static final int RELEVANT_DIGITS = 11;

    // conversion from nanoseconds to seconds
    private static final long TIME_CONVERSION = 1000000000;

    // answer prompt
    private static final String ANSWER = "The first ten digits of the sum is: ";
    // time take to solve the problem
    private static final String TIME_TAKEN = "Time Taken:%s seconds";

    // input file
    private static final File INPUT_FILE = new File("./Problem_13_Input.txt");

    /**
     * The main method executes the solution and prints it alongside the time taken
     * to solve the program.
     * 
     * @param args The arguments given to the main method
     * @return None
     * @throws FileNotFoundException Throws error if file not found
     */
    public static void main(String[] args) throws FileNotFoundException {
        // end time of the program
        long endTime;
        // solution for the problem
        long solution;
        // start time of the program
        long startTime;

        startTime = System.nanoTime();
        solution = findSum(getNumbers(INPUT_FILE));
        endTime = System.nanoTime();

        // print answer and time taken
        System.out.println(ANSWER + solution);
        System.out.printf(TIME_TAKEN, (double) (endTime - startTime) / TIME_CONVERSION);
    }

    /**
     * This method finds the first ten digits of the sum of numbers in the list.
     * 
     * @param numList The list of numbers
     * @return The first ten digits of the sum of numbers in the list
     */
    private static long findSum(long[] numList) {
        // the number of digits in sum
        int sumDigits = 0;
        // sum of the digits in the list
        long sum = 0;
        // temp holder for sum
        long tempSum = 0;

        // find the sum of the numbers
        for (int index = 0; index < numList.length; index++) {
            sum += numList[index];
        }

        // find the number of digits in the sum
        tempSum = sum;
        while (tempSum > 0) {
            sumDigits++;
            tempSum /= DIVISOR_TEN;
        }

        // remove the unnecessary digits in the sum
        if (sumDigits > (RELEVANT_DIGITS - 1)) {
            sum /= (Math.pow(DIVISOR_TEN, sumDigits - (RELEVANT_DIGITS - 1)));
        }

        return sum;
    }

    /**
     * This method gets the list of numbers from the file.
     * 
     * @param inputFile The file being read
     * @return An array containing the 50 digit numbers
     * @throws FileNotFoundException Throws error if file not found
     */
    private static long[] getNumbers(File inputFile) throws FileNotFoundException {
        // number of lines in file
        int numOfLines = 0;
        // long array containing the number's first 11 digits
        long[] shortNumList;
        // String array containing the numbers
        String[] numList;
        // the scanner used to read the file
        Scanner scan = new Scanner(inputFile);

        // read the number of lines in file
        while (scan.hasNextLine() == true) {
            numOfLines++;
            scan.nextLine();
        }
        scan.close();

        // create the number list
        shortNumList = new long[numOfLines];
        numList = new String[numOfLines];

        // get the numbers into the list
        scan = new Scanner(inputFile);
        while (scan.hasNextLine() == true) {
            for (int index = 0; index < numList.length; index++) {
                numList[index] = scan.nextLine();
            }
        }
        scan.close();

        // get the first 11 digits of the numbers
        for (int index = 0; index < shortNumList.length; index++) {
            shortNumList[index] = Long.parseLong(numList[index].substring(0, RELEVANT_DIGITS));
        }

        return shortNumList;
    }
}