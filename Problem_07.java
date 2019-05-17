
/**
 * Created by: 龍ONE 
 * Date Created: Jan 3, 2018
 * Date Edited: May 16, 2019
 * Purpose: Solution to Project Euler Problem 6
 */

/**
 * This class contains a method that calculates the nth prime number. The main
 * method executes the program.
 */
public class Problem_07 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The 10001th prime number is: ";
    private static final int SMALLEST_PRIME = 2;
    private static final int TARGET = 10001;
    private static boolean[] notPrime = new boolean[150000 + 1];

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int answer = findPrime(TARGET);
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + answer);
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
    }

    private static int findPrime(int target) {
        int count = 0;
        // set all non prime numbers to true
        for (int index = SMALLEST_PRIME; index < notPrime.length; index++) {
            for (int counter = index * SMALLEST_PRIME; counter < notPrime.length; counter += index) {
                notPrime[counter] = true;
            }
        }
        // find the target prime
        for (int index = SMALLEST_PRIME; index < notPrime.length; index++) {
            if (notPrime[index] == false) {
                count++;
            }
            if (count == target) {
                return index;
            }
        }
        return 0;
    }
}