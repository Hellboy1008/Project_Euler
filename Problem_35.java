
//龍ONE

import java.util.ArrayList;
import java.lang.StringBuilder;

public class Problem_35 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The number of circle prime numbers is: ";
    private static final int UPPER_BOUND = 1000000;
    private static final int SMALLEST_PRIME = 2;
    private static final int STARTING_PRIME_NUM_INDEX = 4;
    private static final int TENS_DIGIT = 10;
    private static final int NON_CIRCULAR_END_DIGIT_ONE = 2;
    private static final int NON_CIRCULAR_END_DIGIT_TWO = 4;
    private static final int NON_CIRCULAR_END_DIGIT_THREE = 5;
    private static final int NON_CIRCULAR_END_DIGIT_FOUR = 6;
    private static final int NON_CIRCULAR_END_DIGIT_FIVE = 8;
    private static final int[] POWERS_OF_TEN = { 10, 100, 1000, 10000, 100000 };
    private static ArrayList<Integer> primes = new ArrayList<Integer>();
    private static boolean[] circularPrimes;
    private static boolean[] notPrime = new boolean[UPPER_BOUND + 1];

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int answer = findPrimes();
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + answer);
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
    }

    private static int findPrimes() {
        // set all non prime numbers to true
        for (int index = SMALLEST_PRIME; index < notPrime.length; index++) {
            for (int counter = index * SMALLEST_PRIME; counter < notPrime.length; counter += index) {
                notPrime[counter] = true;
            }
        }
        // add primes to the array
        for (int index = SMALLEST_PRIME; index < notPrime.length; index++) {
            if (notPrime[index] == false) {
                primes.add(index);
            }
        }
        // initialise boolean ArrayList
        circularPrimes = new boolean[primes.size()];
        for (int index = 0; index < primes.size(); index++) {
            circularPrimes[index] = true;
        }
        // remove primes that cannot be circular primes (starting from 11)
        for (int index = STARTING_PRIME_NUM_INDEX; index < primes.size(); index++) {
            int temp = primes.get(index);
            boolean possibleCircular = true;
            while (temp != 0) {
                if (temp % TENS_DIGIT == 0 || temp % TENS_DIGIT == NON_CIRCULAR_END_DIGIT_ONE
                        || temp % TENS_DIGIT == NON_CIRCULAR_END_DIGIT_TWO
                        || temp % TENS_DIGIT == NON_CIRCULAR_END_DIGIT_THREE
                        || temp % TENS_DIGIT == NON_CIRCULAR_END_DIGIT_FOUR
                        || temp % TENS_DIGIT == NON_CIRCULAR_END_DIGIT_FIVE) {
                    possibleCircular = false;
                    break;
                }
                temp /= TENS_DIGIT;
            }
            if (possibleCircular == false) {
                circularPrimes[index] = false;
            }
        }
        // check if the primes are circular primes
        int sum = 0;

        for (int index = 0; index < circularPrimes.length; index++) {
            if (circularPrimes[index] == false) {
                continue;
            }
            int temp = primes.get(index);
            int digits = 0;
            while (temp != 0) {
                temp /= TENS_DIGIT;
                digits++;
            }
            temp = primes.get(index);
            for (int count = 0; count < digits - 1; count++) {
                temp = (temp / TENS_DIGIT) + POWERS_OF_TEN[digits - SMALLEST_PRIME] * (temp % TENS_DIGIT);
                if (primes.contains(temp) == false) {
                    circularPrimes[index] = false;
                    break;
                }
            }
        }
        // count the number of circular primes
        for (int index = 0; index < circularPrimes.length; index++) {
            if (circularPrimes[index] == true) {
                sum++;
            }
        }
        return sum;
    }
}