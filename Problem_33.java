
/**
 * Created by: 龍ONE
 * Date Created: February 4, 2019
 * Date Edited: July 7, 2020
 * Purpose: Solution to Project Euler Problem 33
 */

/**
 * This class contains a method that calculates the product of anomalous
 * cancelling proper fractions (curious fractions) that contains n digits in the
 * numerator and denominator. The main method executes the program.
 */
public class Problem_33 {

    // the number of digits for each number in the fraction
    private static final int DIGITS_FOR_FRACTIONS = 2;
    // div value for slicing numbers
    private static final int DIV_VAL = 10;
    // largest value for the numerator/denominator
    private static final int LARGEST_NUM = (int) Math.pow(10, DIGITS_FOR_FRACTIONS) - 1;
    // smallest value for the numerator/denominator
    private static final int SMALLEST_NUM = (int) Math.pow(10, DIGITS_FOR_FRACTIONS - 1);

    // conversion from nanoseconds to seconds
    private static final long TIME_CONVERSION = 1000000000;

    // answer prompt
    private static final String ANSWER = "The value of the denominator for the product of these fractions with "
            + DIGITS_FOR_FRACTIONS + " digits in the numerator/denominator is: ";
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
        solution = findCuriousFractionDenominator(SMALLEST_NUM, LARGEST_NUM);
        endTime = System.nanoTime();

        // print answer and time taken
        System.out.println(ANSWER + solution);
        System.out.printf(TIME_TAKEN, (double) (endTime - startTime) / TIME_CONVERSION);
    }

    /**
     * Finds the product of all curious fractions that can be created using the
     * smallest and largest possible values and returns the denominator of that
     * product in fraction form.
     * 
     * @param smallest_val The smallest possible value for the numerator/denominator
     * @param largest_val  The largest possible value for the numerator/denominator
     * @return The denominator of the product of all these fraction
     */
    private static int findCuriousFractionDenominator(int smallest_val, int largest_val) {
        // product of the denominators for the special fractions
        int denominatorProduct = 1;
        // product of the numerators for the special fractions
        int numeratorProduct = 1;
        // the value for the division
        double division;
        // the value for the incorrect division
        double incorrectDivision;

        // loop through all possible numerators
        for (double numerator = smallest_val; numerator <= largest_val; numerator++) {
            // loop through all possible denominators
            for (double denominator = numerator + 1; denominator <= largest_val; denominator++) {
                // check if the number is cancellable
                if ((int) (numerator) % DIV_VAL == (int) (denominator) / DIV_VAL) {
                    division = numerator / denominator;
                    incorrectDivision = (double) ((int) (numerator) / DIV_VAL)
                            / (double) ((int) (denominator) % DIV_VAL);
                    // check if the proper division is the same as the incorrect division
                    if (division == incorrectDivision) {
                        numeratorProduct *= numerator;
                        denominatorProduct *= denominator;
                    }
                }
            }
        }

        return denominatorProduct / gcd(numeratorProduct, denominatorProduct);
    }

    /**
     * This method returns the greatest common divisor between two numbers.
     * 
     * @param numOne The first number
     * @param numTwo The second number
     * @return The greatest common divisor between the two numbers
     */
    private static int gcd(int numOne, int numTwo) {

        // base case for recursion
        if (numTwo == 0) {
            return numOne;
        }

        return gcd(numTwo, numOne % numTwo);
    }

}