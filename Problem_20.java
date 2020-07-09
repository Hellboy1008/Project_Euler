
/**
 * Created by: 龍ONE 
 * Date Created: January 15, 2019
 * Date Edited: July 9, 2020
 * Purpose: Solution to Project Euler Problem 20
 */

import java.math.BigInteger;

/**
 * This class contains method(s) that finds the sum of the digits for a factorial
 * of a number n. The main method executes the program.
 */
public class Problem_20 {

    // the number that we are solving for
    private static final int FACTORIAL_NUM = 100;

    // conversion from nanoseconds to seconds
    private static final long TIME_CONVERSION = 1000000000;

    // answer prompt
    private static final String ANSWER = "The sum of the digits in the number " + FACTORIAL_NUM + "! is: ";
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
        solution = sumOfDigitsFactorial(FACTORIAL_NUM);
        endTime = System.nanoTime();

        // print answer and time taken
        System.out.println(ANSWER + solution);
        System.out.printf(TIME_TAKEN, (double) (endTime - startTime) / TIME_CONVERSION);
    }

    /**
     * Calculates the sum of the digits of a factorial of the number.
     * 
     * @param number The number in question
     * @return The sum of the digits of the factorial of the number
     */
    private static int sumOfDigitsFactorial(int number) {
        // sum of the digits
        int digitSum = 0;
        // the string containing the factorial of the number
        String factorialString = "";
        // the big integer for the factorial value
        BigInteger factorial = BigInteger.ONE;
        // the number used for factorial calculation that counts up to number
        BigInteger startingNum = BigInteger.ONE;

        // calculates the factorial of the number
        for (int index = 1; index <= number; index++) {
            factorial = factorial.multiply(startingNum);
            startingNum = startingNum.add(BigInteger.ONE);
        }

        // calculates the sum of the digits
        factorialString = factorial.toString();
        for (int index = 0; index < factorialString.length(); index++) {
            digitSum += Character.getNumericValue(factorialString.charAt(index));
        }

        return digitSum;
    }

}