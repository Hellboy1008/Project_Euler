
/**
 * Created by: 龍ONE 
 * Date Created: February 7, 2019 
 * Date Edited: July 9, 2020
 * Purpose: Solution to Project Euler Problem 35
 */

/**
 * This class contains a method that finds all circular primes below a number n.
 * The main method executes the program.
 */
public class Problem_35 {

    // checks whether a digit is unwanted when finding circular primes (0,2,4,5,6,8)
    private static final boolean[] UNWANTED_DIGITS = { true, false, true, false, true, true, true, false, true, false };

    // the smallest prime number
    private static final int SMALLEST_PRIME = 2;
    // div value for stripping numbers
    private static final int DIV_10 = 10;
    // upper bound for the problem
    private static final int UPPER_BOUND = 1000000;

    // conversion from nanoseconds to seconds
    private static final long TIME_CONVERSION = 1000000000;

    // answer prompt
    private static final String ANSWER = "The number of circle prime numbers under " + UPPER_BOUND + " is: ";
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
        solution = findCircularPrimes(UPPER_BOUND);
        endTime = System.nanoTime();

        // print answer and time taken
        System.out.println(ANSWER + solution);
        System.out.printf(TIME_TAKEN, (double) (endTime - startTime) / TIME_CONVERSION);
    }

    /**
     * Returns whether a prime number is a circular prime.
     * 
     * @param num      The number in question
     * @param notPrime The boolean array containing whether a number is prime
     * @return True if the prime number is circular, false otherwise
     */
    private static boolean checkCircular(int num, boolean[] notPrime) {
        // number of digits for the input
        int digits = 0;
        // the first digit of a number
        int firstDigit;
        // index for the rotated numbers array
        int rotatedNumbersIndex = 0;
        // temp variable for the input
        int tempNum;
        // holds all the rotations for a number
        int[] rotatedNumbers;

        // if the number only has one digit, it is circular
        if (num / DIV_10 == 0) {
            return true;
        }

        // run through all the digits for the number
        tempNum = num;
        while (tempNum > 0) {
            // check if the number contains the digits 0,2,4,5,6,8
            if (UNWANTED_DIGITS[tempNum % DIV_10] == true) {
                return false;
            }
            tempNum /= DIV_10;
        }

        // find out how many digits the number has
        tempNum = num;
        while (tempNum > 0) {
            tempNum /= DIV_10;
            digits++;
        }

        // find all rotations for the number
        tempNum = num;
        rotatedNumbers = new int[digits - 1];
        for (int count = 0; count < digits - 1; count++) {
            firstDigit = tempNum / ((int) Math.pow(DIV_10, digits - 1));
            tempNum = (tempNum - firstDigit * ((int) Math.pow(DIV_10, digits - 1))) * DIV_10 + firstDigit;
            rotatedNumbers[rotatedNumbersIndex] = tempNum;
            rotatedNumbersIndex++;
        }

        // loop through all the rotated numbers
        for (int index = 0; index < rotatedNumbers.length; index++) {
            // check if the rotated numbers are also prime
            if (notPrime[rotatedNumbers[index]] == true) {
                return false;
            }
        }

        return true;
    }

    /**
     * Finds the sum of all circular primes under n.
     * 
     * @param upperBound The upper bound for the problem
     * @return The sum of all circular primes under the upper bound
     */
    private static int findCircularPrimes(int upperBound) {
        // number of circular primes
        int circularPrimes = 0;
        // keeps track of whether a number is prime or not
        boolean[] notPrime = new boolean[upperBound + 1];

        // loop through all the possible values
        for (int index = SMALLEST_PRIME; index < notPrime.length; index++) {
            // for each multiple of that number, set true
            for (int counter = index * SMALLEST_PRIME; counter < notPrime.length; counter += index) {
                notPrime[counter] = true;
            }
        }

        // loop through the notPrime array
        for (int num = SMALLEST_PRIME; num < notPrime.length; num++) {
            // for all prime numbers, check if they are circular prime
            if (notPrime[num] == false && checkCircular(num, notPrime) == true) {
                circularPrimes++;
            }
        }

        return circularPrimes;
    }
}