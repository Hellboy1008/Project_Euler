
/**
 * Created by: 龍ONE
 * Date Created: February 3, 2019
 * Date Edited: July 7, 2020
 * Purpose: Solution to Project Euler Problem 32
 */

import java.util.ArrayList;

/**
 * This class contains a method that calculates the sum of all products whose
 * multiplicand/multiplier/product identity can be written as a 1 through 9
 * pandigital. The main method executes the program.
 */
public class Problem_32 {

    // mod value for getting last digit for a number
    private static final int MOD_VAL = 10;
    // minimum value for the multiplier
    private static final int MULTIPLIER_MIN = 100;
    // maximum value for the multiplier
    private static final int MULTIPLIER_MAX = 9999;
    // maximum value for the multiplicand
    private static final int MULTIPLICAND_MAX = 99;
    // maximum value for the product
    private static final int PRODUCT_MAX = 10000;

    // conversion from nanoseconds to seconds
    private static final long TIME_CONVERSION = 1000000000;

    // answer prompt
    private static final String ANSWER = "The sum of all products whose multiplicand/multiplier/product identity"
            + " can be written as a 1 through 9 pandigital is: ";
    // time take to solve the problem
    private static final String TIME_TAKEN = "Time Taken: %s seconds";

    // all the possible digits in the identity
    private static final String[] DIGITS = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };

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
        solution = calculateSum();
        endTime = System.nanoTime();

        // print answer and time taken
        System.out.println(ANSWER + solution);
        System.out.printf(TIME_TAKEN, (double) (endTime - startTime) / TIME_CONVERSION);
    }

    /**
     * Calculates the sum of all products whose multiplicand/multiplier/product
     * identity can be written as a 1 through 9 pandigital.
     * 
     * @return The sum of all products
     */
    private static int calculateSum() {
        // holds the product for the multiplicand and multiplier
        int product;
        // sum of all products
        int sumOfProducts = 0;
        // ArrayList containing all the products
        ArrayList<Integer> productsArray = new ArrayList<Integer>();

        // loops through all possible multiplicands
        for (int multiplicand = 1; multiplicand <= MULTIPLICAND_MAX; multiplicand++) {
            // loops through all possible multipliers
            for (int multiplier = MULTIPLIER_MIN; multiplier <= MULTIPLIER_MAX; multiplier++) {
                product = multiplicand * multiplier;
                // check if the product is over the maximum possible value for the product
                if (product >= PRODUCT_MAX) {
                    continue;
                }
                // check if the three numbers are pandigital
                if (checkPandigital(multiplicand, multiplier, product) == true
                        && productsArray.contains(product) == false) {
                    productsArray.add(product);
                }
            }
        }

        // sum all products
        for (int index = 0; index < productsArray.size(); index++) {
            sumOfProducts += productsArray.get(index);
        }

        return sumOfProducts;
    }

    /**
     * Checks whether three numbers only contain the digits 1-9 once.
     * 
     * @param multiplicand The multiplicand for the identity
     * @param multiplier   The multiplier for the identity
     * @param product      The product for the identity
     * @return True if the three numbers only contain the digits 1-9 once, false
     *         otherwise
     */
    private static boolean checkPandigital(int multiplicand, int multiplier, int product) {
        // holds the individual digits being read
        int digit;
        // array to check if a digit already exists
        boolean[] digitExists = new boolean[DIGITS.length];

        // run through all the digits for multiplicand
        while (multiplicand > 0) {
            digit = multiplicand % MOD_VAL;
            if (digit == 0)
                return false;
            // check if the digit already exists in the array
            if (digitExists[digit - 1] == true) {
                return false;
            } else {
                digitExists[digit - 1] = true;
            }
            multiplicand /= MOD_VAL;
        }

        // run through all the digits for multiplier
        while (multiplier > 0) {
            digit = multiplier % MOD_VAL;
            if (digit == 0)
                return false;
            // check if the digit already exists in the array
            if (digitExists[digit - 1] == true) {
                return false;
            } else {
                digitExists[digit - 1] = true;
            }
            multiplier /= MOD_VAL;
        }

        // run through all the digits for product
        while (product > 0) {
            digit = product % MOD_VAL;
            if (digit == 0)
                return false;
            // check if the digit already exists in the array
            if (digitExists[digit - 1] == true) {
                return false;
            } else {
                digitExists[digit - 1] = true;
            }
            product /= MOD_VAL;
        }

        // loop through the digit exists boolean array
        for (int index = 0; index < digitExists.length; index++) {
            // check if all the digits have been used
            if (digitExists[index] == false) {
                return false;
            }
        }

        return true;
    }

}