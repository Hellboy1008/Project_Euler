
/**
 * Created by: 龍ONE
 * Date Created: Oct 12, 2017
 * Date Edited: May 8, 2019
 * Purpose: Solution to Project Euler Problem 1
 */

public class Problem_01 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The sum of all multiples of 3 or 5 below 1000 is: ";
    private static final int SUM_OF_MULTIPLES_THREE = 3 * (333 * (333 + 1)) / 2;
    private static final int SUM_OF_MULTIPLES_FIVE = 5 * (199 * (199 + 1)) / 2;
    private static final int SUM_OF_MULTIPLES_FIFTEEN = 15 * (66 * (66 + 1)) / 2;

    public static void main(String[] args) {

        long startTime = System.nanoTime();
        // Add sum of multiples of 3 and/or 5 under 1000 and subtract the multiples of
        // fifteen
        int totalSum = SUM_OF_MULTIPLES_THREE + SUM_OF_MULTIPLES_FIVE - SUM_OF_MULTIPLES_FIFTEEN;
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + totalSum);
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
    }
}