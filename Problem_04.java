
/**
 * Created by: 龍ONE 
 * Date Created: Dec 28, 2017
 * Date Edited: July 2, 2020
 * Purpose: Solution to Project Euler Problem 4
 */

/**
 * This class contains a method that calculates the largest palindrome made from
 * the product of two three-digit numbers. The main method executes the program.
 */
public class Problem_04 {

    // divisor to check for palindrome
    private static final int DIVISOR_TEN = 10;
    // assumed lower bound
    private static final int LOWER_BOUND = 900;
    // upper bound
    private static final int UPPER_BOUND = 1000;

    // conversion from nanoseconds to seconds
    private static final long TIME_CONVERSION = 1000000000;

    // answer prompt
    private static final String ANSWER = "The largest palindrome made from the product of two three digits numbers is: ";
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
        solution = findLargestPalindrome(LOWER_BOUND, UPPER_BOUND);
        endTime = System.nanoTime();

        // print answer and time taken
        System.out.println(ANSWER + solution);
        System.out.printf(TIME_TAKEN, (double) (endTime - startTime) / TIME_CONVERSION);
    }

    /**
     * This method checks if a number is a palindrome.
     * 
     * @param number The number being checked
     * @return True if the number is a palindrome, false if not
     */
    private static boolean checkPalindrome(int number) {
        // the original number
        int originalNumber = number;
        // the reverse of the parameter
        int reverse = 0;

        // check if the number is smaller than 10 or divisible by 10
        if (number <= DIVISOR_TEN || number % DIVISOR_TEN == 0) {
            return false;
        }

        // find the reverse of the number
        while (number >= 1) {
            reverse = reverse * DIVISOR_TEN + number % DIVISOR_TEN;
            number /= DIVISOR_TEN;
        }

        // check if the original number and the reverse number are equal
        if (originalNumber == reverse) {
            return true;
        }

        return false;
    }

    /**
     * This method finds the largest palindrome from the product of two numbers from
     * the parameter lower_bound to upper_bound.
     * 
     * @param lower_bound The lower bound for the method
     * @param upper_bound The upper bound for the method
     * @return The largest palindrome product of two numbers from lower_bound to
     *         upper_bound
     */
    private static int findLargestPalindrome(int lower_bound, int upper_bound) {
        // holds the largest palindrome
        int largestPalindrome = 0;
        // holds the product of two numbers
        int product;

        // check each permutation from lower to upper bound
        for (int first_num = lower_bound; first_num < upper_bound; first_num++) {
            for (int second_num = lower_bound; second_num < upper_bound; second_num++) {
                product = first_num * second_num;
                if (checkPalindrome(product) == true && product > largestPalindrome) {
                    largestPalindrome = product;
                }
            }
        }

        return largestPalindrome;
    }
}