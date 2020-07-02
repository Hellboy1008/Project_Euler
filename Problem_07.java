
/**
 * Created by: 龍ONE 
 * Date Created: Jan 3, 2018
 * Date Edited: July 2, 2020
 * Purpose: Solution to Project Euler Problem 7
 */

/**
 * This class contains a method that calculates the nth prime number. The main
 * method executes the program.
 */
public class Problem_07 {

    // prime multiplier
    private static final int PRIME_MULTIPLIER = 15;
    // smallest prime number
    private static final int SMALLEST_PRIME = 2;
    // target value for problem
    private static final int TARGET = 10001;

    // conversion from nanoseconds to seconds
    private static final long TIME_CONVERSION = 1000000000;

    // answer prompt
    private static final String ANSWER = "The " + TARGET + "th prime number is: ";
    // time take to solve the problem
    private static final String TIME_TAKEN = "Time Taken:%s seconds";

    // array storing boolean values for prime numbers
    private static boolean[] notPrime;

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
        solution = findPrime(TARGET);
        endTime = System.nanoTime();

        // print answer and time taken
        System.out.println(ANSWER + solution);
        System.out.printf(TIME_TAKEN, (double) (endTime - startTime) / TIME_CONVERSION);
    }

    /**
     * This method finds the nth prime number.
     * 
     * @param target The nth number for the method
     * @return The nth prime number given the parameter target
     */
    private static int findPrime(int target) {
        // counts the number of primes cycled through so far
        int count = 0;

        // initialize non-prime array
        notPrime = new boolean[target * PRIME_MULTIPLIER + 1];

        // set all non prime numbers to true
        for (int index = SMALLEST_PRIME; index < notPrime.length; index++) {
            for (int counter = index * SMALLEST_PRIME; counter < notPrime.length; counter += index) {
                notPrime[counter] = true;
            }
        }

        // find the target prime
        for (int index = SMALLEST_PRIME; index < notPrime.length; index++) {
            if (notPrime[index] == false) {
                count++;
            }
            // if we find the prime, return the prime number
            if (count == target) {
                return index;
            }
        }

        return 0;
    }
}