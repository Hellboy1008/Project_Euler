
/**
 * Created by: 龍ONE 
 * Date Created: Jan 22, 2018
 * Date Edited: July 9, 2020
 * Purpose: Solution to Project Euler Problem 12
 */

/**
 * This class contains method(s) that calculates the first triangle number with n
 * divisors. The main method executes the program.
 */
public class Problem_12 {

    // divisor for dividing in half
    private static final int HALF = 2;
    // multiplier for multiplying by 2
    private static final int MULTIPLIER_TWO = 2;
    // number of factors
    private static final int TARGET_FACTORS = 500;

    // conversion from nanoseconds to seconds
    private static final long TIME_CONVERSION = 1000000000;

    // answer prompt
    private static final String ANSWER = "The first triangle number to have over " + TARGET_FACTORS + " divisors is: ";
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
        solution = findTriangleNumber(TARGET_FACTORS);
        endTime = System.nanoTime();

        // print answer and time taken
        System.out.println(ANSWER + solution);
        System.out.printf(TIME_TAKEN, (double) (endTime - startTime) / TIME_CONVERSION);
    }

    /**
     * This method counts the number of factors for an integer.
     * 
     * @param number The number being checked
     * @return The total number of factors of a number
     */
    private static int countFactors(int number) {
        // number of factors
        int factors = 0;

        // count factors
        for (int counter = 1; counter <= Math.sqrt(number); counter++) {
            if (Math.sqrt(number) <= TARGET_FACTORS / HALF) {
                break;
            }
            if (number % counter == 0) {
                factors++;
            }
        }

        return factors * MULTIPLIER_TWO;
    }

    /**
     * This method finds the first triangle number with n factors.
     * 
     * @param numOfFactors The number of factors
     * @return The first triangle number with n factors
     */
    private static int findTriangleNumber(int numOfFactors) {
        // value for whether the triangle number is found
        boolean found = false;
        // index used to calculate triangle number
        int index = 1;
        // triangle number
        int triangle_number = 0;

        // find triangle number
        while (found == false) {
            triangle_number = index * (index + 1) / HALF;
            if (countFactors(triangle_number) >= numOfFactors) {
                found = true;
            }
            index++;
        }

        return triangle_number;
    }
}