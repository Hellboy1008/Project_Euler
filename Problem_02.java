
/**
 * Created by: 龍ONE 
 * Date Created: Oct 12, 2017
 * Date Edited: May 12, 2019
 * Purpose: Solution to Project Euler Problem 2
 */

/**
 * This class contains a method that calculates the sum of a even fibonacci
 * numbers as well as the main method that executes the program.
 */
public class Problem_02 {

    // multiplier for the equation used to calculate the sum
    private static final int EVEN_FIBONACCI_MULTIPLIER = 4;
    // sum of the first three fibonacci numbers (0,1,1)
    private static final int SUM_OF_FIRST_THREE_FIBONACCI = 2;
    // upper limit for the problem
    private static final int UPPER_BOUND = 4000000;

    // conversion from nanoseconds to seconds
    private static final long TIME_CONVERSION = 1000000000;

    // answer prompt
    private static final String ANSWER = "The sum of even fibonacci numbers under 4 million is: ";
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
        // sum for the problem
        int sum;
        // end time of the program
        long endTime;
        // start time of the program
        long startTime;

        startTime = System.nanoTime();
        sum = calculateEvenFibonaciiSum(UPPER_BOUND);
        endTime = System.nanoTime();

        // print answer and time taken
        System.out.println(ANSWER + sum);
        System.out.printf(TIME_TAKEN, (double) (endTime - startTime) / TIME_CONVERSION);
    }

    /**
     * This methods calculates the sum of even fibonacci numbers using the idea that
     * every third fibonacci numbers is even starting from 2.
     * 
     * @param limit The limit of the sum
     * @return The sum of all even fibonacci numbers smaller than limit
     */
    private static int calculateEvenFibonaciiSum(int limit) {
        // holds the future fibonacci number
        int calculated_fibonacci = 0;
        // holds the current fibonacci number
        int even_fibonacci_number = SUM_OF_FIRST_THREE_FIBONACCI;
        // holds the previous fibonacci number
        int previous_fibonacci_number = 0;
        // holds the sum of the fibonacci numbers
        int sum = SUM_OF_FIRST_THREE_FIBONACCI;

        // Calculate the sum of the even fibonacci numbers
        while (calculated_fibonacci + calculated_fibonacci < limit) {
            calculated_fibonacci = EVEN_FIBONACCI_MULTIPLIER * even_fibonacci_number + previous_fibonacci_number;
            sum += calculated_fibonacci;
            previous_fibonacci_number = even_fibonacci_number;
            even_fibonacci_number = calculated_fibonacci;
        }

        return sum;
    }
}