
/**
 * Created by: 龍ONE 
 * Date Created: January 31, 2019
 * Date Edited: July 5, 2020
 * Purpose: Solution to Project Euler Problem 27
 */

import java.util.ArrayList;

/**
 * This class contains a method that calculates the product of the coefficients
 * a and b, where |a| < l and |b| <= l for the quadratic expression n^2 + an + b
 * that produces the maximum number of primes for consecutive values of n,
 * starting with n = 0. The main method executes the program.
 */
public class Problem_27 {

    // the smallest prime number
    private static final int SMALLEST_PRIME = 2;
    // upper bound for the problem
    private static final int UPPER_BOUND = 1000;

    // conversion from nanoseconds to seconds
    private static final long TIME_CONVERSION = 1000000000;

    // answer prompt
    private static final String ANSWER = "The product of the coefficients where |a| < " + UPPER_BOUND + " and |b| <= "
            + UPPER_BOUND + " is: ";
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
        solution = productOfCoefficients(UPPER_BOUND);
        endTime = System.nanoTime();

        // print answer and time taken
        System.out.println(ANSWER + solution);
        System.out.printf(TIME_TAKEN, (double) (endTime - startTime) / TIME_CONVERSION);
    }

    /**
     * Calculates the product of the coefficients a and b, where |a| < l and |b| <=
     * l for the quadratic expression n^2 + an + b that produces the maximum number
     * of primes for consecutive values of n, starting with n = 0.
     * 
     * @param limit The upper limit for the coefficients
     * @return The product of the coefficients that satisfy the requirement
     */
    private static int productOfCoefficients(int limit) {
        // keeps track of the value of a with longest consecutive prime numbers
        int largest_a_value = 0;
        // keeps track of the value of b with longest consecutive prime numbers
        int largest_b_value = 0;
        // the length of the largest number of consecutive primes
        int largestNumOfPrimes = 0;
        // keeps track of the value of n
        int n_value;
        // keeps track of the number of primes for a pair of a and b
        int numberOfPrimes = 0;
        // ArrayList that contains all possible values for b
        ArrayList<Integer> b_values = new ArrayList<Integer>();

        // loops through all possible values of b
        for (int counter = SMALLEST_PRIME; counter <= limit; counter++) {
            // b must be a prime, so only add prime numbers to ArrayList
            if (checkPrime(counter) == true) {
                b_values.add(counter);
            }
        }

        // loops through all possible values of a
        for (int counter = -limit; counter < limit; counter++) {
            // loops through all possible values of b
            for (int index = 0; index < b_values.size(); index++) {
                n_value = 0;
                numberOfPrimes = 0;
                // count how many consecutive primes are produced
                while (checkPrime(Math.abs(n_value * n_value + counter * n_value + b_values.get(index))) == true) {
                    n_value++;
                    numberOfPrimes++;
                }
                // if the number of consecutive primes is greater than the current longest
                // length
                if (numberOfPrimes > largestNumOfPrimes) {
                    largestNumOfPrimes = numberOfPrimes;
                    largest_a_value = counter;
                    largest_b_value = b_values.get(index);
                }
            }
        }

        return largest_a_value * largest_b_value;
    }

    /**
     * Returns whether a number is a prime number.
     * 
     * @param num The number to be checked
     * @return True if the number is a prime number, false otherwise
     */
    private static boolean checkPrime(int num) {
        // check if the number is 0 or 1
        if (num == 0 || num == 1) {
            return false;
        }

        // loops from 2 to the square root of the number to find potential factors
        for (int counter = SMALLEST_PRIME; counter <= Math.sqrt(num); counter++) {
            // checks if the number is divisible
            if (num % counter == 0) {
                return false;
            }
        }

        return true;
    }

}