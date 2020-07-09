
/**
 * Created by: 龍ONE 
 * Date Created: January 16, 2019
 * Date Edited: July 9, 2020
 * Purpose: Solution to Project Euler Problem 21
 */

import java.util.ArrayList;

/**
 * This class contains method(s) that finds the sum of all amicable numbers under
 * a number n. The main method executes the program.
 */
public class Problem_21 {

    // lower bound for the question
    private static final int LOWER_BOUND = 2;
    // upper bound for the question
    private static final int UPPER_BOUND = 10000;

    // conversion from nanoseconds to seconds
    private static final long TIME_CONVERSION = 1000000000;

    // answer prompt
    private static final String ANSWER = "The sum of all the amicable numbers under " + UPPER_BOUND + " is: ";
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
        solution = sumOfAmicableNumbers(createFactorSumArray(UPPER_BOUND), UPPER_BOUND);
        endTime = System.nanoTime();

        // print answer and time taken
        System.out.println(ANSWER + solution);
        System.out.printf(TIME_TAKEN, (double) (endTime - startTime) / TIME_CONVERSION);

    }

    /**
     * Calculates the sum of the factors for the input number and adds it to the
     * ArrayList.
     * 
     * @param allFactorSums The ArrayList to add the factor sum
     * @param input_number  The number to find the factor sum for
     * @return None
     */
    private static void calculateFactorSum(ArrayList<Integer> allFactorSums, int input_number) {
        // the sum of the factors
        int factorSum = 0;

        // find the factors between 1 and the square root of the number
        for (int counter = 1; counter <= Math.sqrt(input_number); counter++) {
            // if the number is a factor
            if (input_number % counter == 0) {
                factorSum += counter;
                // add the other factor using division if applicable
                if (counter != 1 && counter != (input_number / counter)) {
                    factorSum += (input_number / counter);
                }
            }
        }
        allFactorSums.add(factorSum);
    }

    /**
     * Creates an ArrayList with the sum of the factors for numbers between 2 and
     * upperBound.
     * 
     * @param upperBound The upper bound for calculation
     * @return ArrayList with sum of the factors
     */
    private static ArrayList<Integer> createFactorSumArray(int upperBound) {
        // ArrayList containing the sum of all the factors from lowerBound to upperBound
        ArrayList<Integer> sumOfAllFactors = new ArrayList<Integer>();

        // calculate sum of factors for each number
        for (int number = LOWER_BOUND; number <= upperBound; number++) {
            calculateFactorSum(sumOfAllFactors, number);
        }

        return sumOfAllFactors;
    }

    /**
     * Calculates the sum of the amicable numbers given ArrayList of factor sums.
     * 
     * @param allFactorSums The ArrayList containing factor sums
     * @param upperBound    The upper bound for the question
     * @return The sum of all amicable numbers
     */
    private static int sumOfAmicableNumbers(ArrayList<Integer> allFactorSums, int upperBound) {
        // the sum of amicable numbers
        int amicableNumSum = 0;

        // loop through the ArrayList
        for (int index = 0; index < allFactorSums.size(); index++) {
            int element = (int) (allFactorSums.get(index));
            // check if the number is a amicable number
            if (element == 1 || element > upperBound - 1 || element == index + LOWER_BOUND) {
                continue;
            } else if (index + LOWER_BOUND == (int) (allFactorSums.get(element - LOWER_BOUND))) {
                amicableNumSum += (index + LOWER_BOUND);
            }
        }

        return amicableNumSum;
    }

}