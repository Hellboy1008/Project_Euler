
/**
 * Created by: 龍ONE 
 * Date Created: Oct 12, 2017
 * Date Edited: May 12, 2019
 * Purpose: Solution to Project Euler Problem 3
 */

/**
 * This class contains a method that calculates the all the prime factors of a
 * number as well as the main method that executes the program.
 */
public class Problem_03 {

    // smallest prime factor of a number
    private static final int SMALLEST_FACTOR = 2;

    // input for the problem
    private static final long INPUT = 600851475143L;
    // conversion from nanoseconds to seconds
    private static final long TIME_CONVERSION = 1000000000;

    // answer prompt
    private static final String ANSWER = "The largest prime factor is: ";
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
        // end time of the program
        long endTime;
        // largest factor for the input
        long largestFactor;
        // start time of the program
        long startTime;

        startTime = System.nanoTime();
        largestFactor = findLargestPrimeFactor(INPUT);
        endTime = System.nanoTime();

        // print answer and time taken
        System.out.println(ANSWER + largestFactor);
        System.out.printf(TIME_TAKEN, (double) (endTime - startTime) / TIME_CONVERSION);
    }

    /**
     * This methods find the largest prime factor of a number.
     * 
     * @param target The number in question
     * @return The largest prime factor of the number
     */
    private static long findLargestPrimeFactor(long target) {
        // Use prime factorization to find largest prime factor
        for (int factor = SMALLEST_FACTOR; factor < Math.sqrt(target); factor++) {
            if (checkPrime(factor) == true && target % factor == 0) {
                target = target / factor;
            }
        }
        return target;
    }

    /**
     * This method determines whether a number is prime.
     * 
     * @param number The number in question
     * @return True if the number is a prime number, false if not
     */
    private static boolean checkPrime(long number) {
        // determine whether the number is divisible by any number other than itself
        for (int counter = SMALLEST_FACTOR; counter <= Math.sqrt(number); counter++) {
            if (number % counter == 0 && number != counter) {
                return false;
            }
        }
        return true;
    }
}