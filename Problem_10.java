
/**
 * Created by: 龍ONE 
 * Date Created: Jan 22, 2018
 * Date Edited: June 8, 2019
 * Purpose: Solution to Project Euler Problem 10
 */

/**
 * This class contains a method that calculates the sum of primes below a
 * certain number. The main method executes the program.
 */
public class Problem_10 {

    // array containing whether a number is a prime
    private static boolean[] notPrime;

    // smallest prime number
    private static final int SMALLEST_PRIME = 2;
    // upper limit for problem
    private static final int UPPER_LIMIT = 2000000;

    // conversion from nanoseconds to seconds
    private static final long TIME_CONVERSION = 1000000000;

    // answer prompt
    private static final String ANSWER = "The sum of all prime numbers below two million is: ";
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
        // end time of the program
        long endTime;
        // solution for the problem
        long solution;
        // start time of the program
        long startTime;

        startTime = System.nanoTime();
        solution = findPrimeSum(UPPER_LIMIT);
        endTime = System.nanoTime();

        // print answer and time taken
        System.out.println(ANSWER + solution);
        System.out.printf(TIME_TAKEN, (double) (endTime - startTime) / TIME_CONVERSION);
    }

    /**
     * Finds the sum of all primes under a certain number.
     * 
     * @param limit The upper limit of the sum
     * @return The sum of all primes under limit
     */
    private static long findPrimeSum(int limit) {
        // the sum of primes
        long primeSum = 0;

        // initialize array
        notPrime = new boolean[limit + 1];

        // set all non prime numbers to true
        for (int index = SMALLEST_PRIME; index < notPrime.length; index++) {
            for (int counter = index * SMALLEST_PRIME; counter < notPrime.length; counter += index) {
                notPrime[counter] = true;
            }
        }

        // sum all prime numbers
        for (int index = SMALLEST_PRIME; index < notPrime.length; index++) {
            if (notPrime[index] == false) {
                primeSum += (long) index;
            }
        }

        return primeSum;
    }
}