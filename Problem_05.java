
/**
 * Created by: 龍ONE 
 * Date Created: Dec 28, 2017
 * Date Edited: May 14, 2019
 * Purpose: Solution to Project Euler Problem 5
 */

/**
 * This class contains a method that calculates the smallest number divisible by
 * n consecutive integers as well as the main method that executes the program.
 */
public class Problem_05 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The smallest positive number divisible by all numbers from 1-20 is: ";
    private static final int SMALLEST_MULTIPLE = 116280; // 20*19*18*17 = 116280
    private static final int[] REMAINING_DIVISORS = { 16, 14, 13, 11 };

    public static void main(String[] args) {

        long startTime = System.nanoTime();
        // Calculate smallest multiple
        int num = SMALLEST_MULTIPLE;
        boolean found = false;
        while (found == false) {
            num += SMALLEST_MULTIPLE;
            for (int index = 0; index < REMAINING_DIVISORS.length; index++) {
                if (num % REMAINING_DIVISORS[index] == 0) {
                    found = true;
                } else {
                    found = false;
                    break;
                }
            }
        }
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + num);
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
    }
}