
/**
 * Created by: 龍ONE
 * Date Created: February 1, 2019
 * Date Edited: July 5, 2020
 * Purpose: Solution to Project Euler Problem 30
 */

/**
 * This class contains a method that find the sum of all the numbers that can be
 * written as the sum of the nth powers of their digits. The main method
 * executes the program.
 */
public class Problem_30 {

    // the largest digit from 0-9
    private static final int BIGGEST_DIGIT = 9;
    // value for div and mod 10 to strip numbers
    private static final int DIVISOR = 10;
    // lower bound for the problem
    private static final int LOWER_BOUND = 2;
    // nth power for the problem
    private static final int POWER = 5;

    // conversion from nanoseconds to seconds
    private static final long TIME_CONVERSION = 1000000000;

    // answer prompt
    private static final String ANSWER = "The sum of all numbers that can be written as the sum of the " + POWER
            + "th powers of their digits is: ";
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
        // solution for the problem
        int solution;
        // end time of the program
        long endTime;
        // start time of the program
        long startTime;

        startTime = System.nanoTime();
        solution = sumDigitPowers(POWER, calculateUpperBound(POWER));
        endTime = System.nanoTime();

        // print answer and time taken
        System.out.println(ANSWER + solution);
        System.out.printf(TIME_TAKEN, (double) (endTime - startTime) / TIME_CONVERSION);
    }

    /**
     * Calculates the upper bound for the problem using the given power.
     * 
     * @param power The given power for the problem
     * @return The upper bound for the problem
     */
    private static int calculateUpperBound(int power) {
        // the highest value possible, 9^power
        int highest_power = (int) Math.pow(BIGGEST_DIGIT, power);
        // the maximum digits in the upper bound
        int maxDigits = 1;

        // find the maximum number of digits the number can have
        while (("" + maxDigits * highest_power).length() > maxDigits) {
            maxDigits++;
        }

        return maxDigits * highest_power;
    }

    /**
     * Calculates the sum of all the numbers that can be written as the sum of the
     * nth powers of their digits.
     * 
     * @param power      The power for the problem
     * @param upperBound The upper bound for the problem
     * @return The sum of all numbers that can be written as a sum of the nth powers
     *         of their digits
     */
    private static int sumDigitPowers(int power, int upperBound) {
        // sum for the numbers that satisfy condition
        int sum = 0;
        // sum of the powers for a number
        int sumOfPowers;
        // temp holder for each number
        int temp;

        // loops through all possible numbers in range
        for (int num = LOWER_BOUND; num < upperBound; num++) {
            temp = num;
            sumOfPowers = 0;
            // calculate the sum of the nth powers of their digits
            while (temp != 0) {
                sumOfPowers += Math.pow(temp % DIVISOR, power);
                temp /= DIVISOR;
            }
            // check if the sum is equal to the number
            if (sumOfPowers == num) {
                sum += num;
            }
        }

        return sum;
    }

}