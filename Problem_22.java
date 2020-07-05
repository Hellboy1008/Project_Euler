
/**
 * Created by: 龍ONE 
 * Date Created: January 17, 2019
 * Date Edited: July 5, 2020
 * Purpose: Solution to Project Euler Problem 22
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * This class contains a method that calculates the total name scores from a
 * list of names. The main method executes the program.
 */
public class Problem_22 {

    // ascii code for uppercase a
    private static final int ASCII_OF_A = 65;

    // conversion from nanoseconds to seconds
    private static final long TIME_CONVERSION = 1000000000;

    // answer prompt
    private static final String ANSWER = "The total of all the name scores is: ";
    // comma for pattern recognition and delimiter
    private static final String COMMA = ",";
    // time take to solve the problem
    private static final String TIME_TAKEN = "Time Taken: %s seconds";

    // input file
    private static final File INPUT_FILE = new File("./Problem_22_Input.txt");

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
        solution = calculateTotalNameScore(createNamesList(INPUT_FILE));
        endTime = System.nanoTime();

        // print answer and time taken
        System.out.println(ANSWER + solution);
        System.out.printf(TIME_TAKEN, (double) (endTime - startTime) / TIME_CONVERSION);
    }

    /**
     * Calculates the total name score given a list of names in alphabetical order.
     * 
     * @param listOfNames The list containing all the names
     * @return The total name score
     */
    private static int calculateTotalNameScore(ArrayList<String> listOfNames) {
        // the alphabetical value of a name
        int alphabeticalValue = 0;
        // the total name score
        int totalNameScore = 0;

        // loop through the list
        for (int element = 0; element < listOfNames.size(); element++) {
            alphabeticalValue = 0;
            // calculate the alphabetical value for the name
            for (int index = 1; index < listOfNames.get(element).length() - 1; index++) {
                alphabeticalValue += (listOfNames.get(element).charAt(index) - (ASCII_OF_A - 1));
            }
            totalNameScore += alphabeticalValue * (element + 1);
        }

        return totalNameScore;
    }

    /**
     * Create an ArrayList containing all the names in a file.
     * 
     * @param inputFile The input file with all the names
     * @return An ArrayList with all the names
     * @throws FileNotFoundException Throws error if file not found
     */
    private static ArrayList<String> createNamesList(File inputFile) throws FileNotFoundException {
        // the ArrayList containing the list of names
        ArrayList<String> listOfNames = new ArrayList<String>();
        // the scanner used to read the file
        Scanner scan = new Scanner(inputFile);

        // separate each name by looking at the commas
        scan.useDelimiter(COMMA);

        // Enter each name into the ArrayList
        while (scan.hasNext()) {
            listOfNames.add(scan.next());
        }

        // close scanner and sort ArrayList
        scan.close();
        Collections.sort(listOfNames);

        return listOfNames;
    }

}