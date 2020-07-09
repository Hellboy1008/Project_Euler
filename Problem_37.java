
/**
 * Created by: 龍ONE 
 * Date Created: February 9, 2019 
 * Date Edited: July 9, 2020
 * Purpose: Solution to Project Euler Problem 37
 */

/**
 * This class contains a method that finds the sum of the only eleven primes
 * that are both truncatable from left to right and right to left. The main
 * method executes the program.
 */
public class Problem_37 {

    // digits the special prime has to start with (2,3,5,7)
    private static final boolean[] START_DIGITS = { false, false, true, true, false, true, false, true, false, false };
    // digits that special prime has to end with (3,7)
    private static final boolean[] END_DIGITS = { false, false, false, true, false, false, false, true, false, false };

    // used to strip numbers
    private static final int DIV_10 = 10;
    // number of special primes
    private static final int NUM_OF_PRIMES = 11;
    // smallest prime number
    private static final int SMALLEST_PRIME = 2;
    // upper bound for the problem (guess and check by increments of powers of 10s)
    private static final int UPPER_BOUND = 1000000;

    // conversion from nanoseconds to seconds
    private static final long TIME_CONVERSION = 1000000000;

    // answer prompt
    private static final String ANSWER = "The sum of these 11 primes is: ";
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
        solution = findSpecialPrimesSum();
        endTime = System.nanoTime();

        // print answer and time taken
        System.out.println(ANSWER + solution);
        System.out.printf(TIME_TAKEN, (double) (endTime - startTime) / TIME_CONVERSION);
    }

    /**
     * Calculates the sum of the only eleven primes that are both left and right
     * truncatable.
     * 
     * @return The sum of these special primes
     */
    private static int findSpecialPrimesSum() {
        // holds whether a prime number has invalid digits
        boolean invalidDigits;
        // holds whether a number is prime or not
        boolean[] notPrime = new boolean[UPPER_BOUND];
        // number of special primes found
        int numOfSpecialPrimes = 0;
        // sum of the special primes
        int sum = 0;
        // temp variable for a number
        int tempNum;

        // set all non prime numbers to true
        for (int index = SMALLEST_PRIME; index < notPrime.length; index++) {
            for (int counter = index * SMALLEST_PRIME; counter < notPrime.length; counter += index) {
                notPrime[counter] = true;
            }
        }

        // loop through all possible values
        for (int num = DIV_10; num < notPrime.length; num++) {
            // only run if the number is prime
            if (notPrime[num] == false) {
                // check if the number ends with a 3 or 7
                if (END_DIGITS[num % DIV_10] == true) {
                    tempNum = num;
                    // strip the number until we get the first digit
                    invalidDigits = false;
                    while (tempNum >= DIV_10) {
                        // check if the prime has even digits that are not 2
                        if ((tempNum % DIV_10) % SMALLEST_PRIME == 0 && tempNum % DIV_10 != SMALLEST_PRIME) {
                            invalidDigits = true;
                            break;
                        }
                        tempNum /= DIV_10;
                    }
                    // check if the prime has invalid digits
                    if (invalidDigits == true) {
                        continue;
                    }
                    // check if the number starts with 2,3,5,7
                    if (START_DIGITS[tempNum] == true) {
                        // check if the number is left and right truncatable
                        if (leftTruncatablePrime(num, notPrime) == true
                                && rightTruncatablePrime(num, notPrime) == true) {
                            numOfSpecialPrimes++;
                            sum += num;
                        }
                    }
                }
            }
            // if all 11 primes are found, exit loop
            if (numOfSpecialPrimes == NUM_OF_PRIMES) {
                break;
            }
        }

        return sum;
    }

    /**
     * Finds out whether a prime number is left truncatable.
     * 
     * @param prime    The prime number in question
     * @param notPrime Contains whether an number is prime
     * @return True if the number is left truncatable, false otherwise
     */
    private static boolean leftTruncatablePrime(int prime, boolean[] notPrime) {
        // number of digits in the prime number
        int digits;
        // temp variable for the prime number
        int tempNum;

        // run until the second last digit in the number
        while (prime >= DIV_10) {
            digits = 1;
            tempNum = prime;
            // find the number of digits in the prime number
            while (tempNum > DIV_10) {
                digits++;
                tempNum /= DIV_10;
            }
            prime -= tempNum * Math.pow(DIV_10, digits - 1);
            // check if the truncated value is a prime
            if (notPrime[prime] == true) {
                return false;
            }
        }

        return true;
    }

    /**
     * Finds out whether a prime number is right truncatable.
     * 
     * @param prime    The prime number in question
     * @param notPrime Contains whether an number is prime
     * @return True if the number is right truncatable, false otherwise
     */
    private static boolean rightTruncatablePrime(int prime, boolean[] notPrime) {
        // run until the second digit
        while (prime >= DIV_10) {
            prime /= DIV_10;
            // check if the truncated value is a prime
            if (notPrime[prime] == true) {
                return false;
            }
        }

        return true;
    }

}