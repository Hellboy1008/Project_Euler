
//龍ONE

import java.util.ArrayList;

public class Problem_37 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The sum of the 11 primes is: ";
    private static final int UPPER_BOUND = 740000; // narrow through trial and error to 740000
    private static final int SMALLEST_PRIME = 2;
    private static final int SMALLEST_TENS_PRIME_INDEX = 4;
    private static final int TENS_DIGIT = 10;
    private static final int END_DIGIT_ONE = 3;
    private static final int END_DIGIT_TWO = 7;
    private static final int[] POWERS_OF_TEN = { 10, 100, 1000, 10000, 100000 };
    private static boolean[] notPrime;
    private static ArrayList<Integer> primes = new ArrayList<Integer>();
    private static ArrayList<Integer> specialPrimes = new ArrayList<Integer>();

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int answer = findSpecialPrimes(UPPER_BOUND);
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + answer);
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
    }

    private static int findSpecialPrimes(int size) {
        notPrime = new boolean[size];
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
        // deep copy primes to specialPrimes (don't count 2,3,5,7)
        for (int index = SMALLEST_TENS_PRIME_INDEX; index < primes.size(); index++) {
            // only primes that end with 3 or 7 are left truncatable
            if ((primes.get(index) % TENS_DIGIT != END_DIGIT_ONE && primes.get(index) % TENS_DIGIT != END_DIGIT_TWO)) {
                continue;
            }
            // only numbers that start with 2,3,5,7 are right truncatable
            int digit = 0;
            int temp = primes.get(index);
            // find digits for original number
            while (temp != 0) {
                temp /= TENS_DIGIT;
                digit++;
            }
            if (primes.get(index) / POWERS_OF_TEN[digit - SMALLEST_PRIME] != SMALLEST_PRIME
                    && primes.get(index) / POWERS_OF_TEN[digit - SMALLEST_PRIME] != END_DIGIT_ONE
                    && primes.get(index) / POWERS_OF_TEN[digit - SMALLEST_PRIME] != (END_DIGIT_ONE + SMALLEST_PRIME)
                    && primes.get(index) / POWERS_OF_TEN[digit - SMALLEST_PRIME] != END_DIGIT_TWO) {
                continue;
            }
            specialPrimes.add(primes.get(index));
        }
        // remove primes with even digits other than 2
        for (int index = 0; index < specialPrimes.size(); index++) {
            int temp = specialPrimes.get(index);
            while (temp != 0) {
                if (temp % TENS_DIGIT == (SMALLEST_PRIME + SMALLEST_PRIME)
                        || temp % TENS_DIGIT == (SMALLEST_PRIME + SMALLEST_PRIME + SMALLEST_PRIME)
                        || temp % TENS_DIGIT == (SMALLEST_PRIME * SMALLEST_PRIME * SMALLEST_PRIME)
                        || temp % TENS_DIGIT == 0) {
                    specialPrimes.remove(index);
                    index--;
                    break;
                }
                temp /= TENS_DIGIT;
            }
        }
        // check right truncatable or not
        for (int index = 0; index < specialPrimes.size(); index++) {
            int temp = specialPrimes.get(index);
            while (temp != 0) {
                if (primes.contains(temp / TENS_DIGIT) == false && temp / TENS_DIGIT != 0) {
                    specialPrimes.remove(index);
                    index--;
                    break;
                }
                temp /= TENS_DIGIT;
            }
        }
        // check left truncatable or not
        for (int index = 0; index < specialPrimes.size(); index++) {
            int digit = 0;
            int temp = specialPrimes.get(index);
            // find digits for original number
            while (temp != 0) {
                temp /= TENS_DIGIT;
                digit++;
            }
            int tempTwo = specialPrimes.get(index);
            // left truncate numbers
            for (int count = 0; count < digit; count++) {
                if (tempTwo < TENS_DIGIT) {
                    if (primes.contains(tempTwo % TENS_DIGIT) == false) {
                        specialPrimes.remove(index);
                        index--;
                    }
                    break;
                }
                if (primes.contains(tempTwo % POWERS_OF_TEN[digit - count - SMALLEST_PRIME]) == false) {
                    specialPrimes.remove(index);
                    index--;
                    break;
                } else {
                    tempTwo %= POWERS_OF_TEN[digit - count - SMALLEST_PRIME];
                }
            }
        }
        // return sum of the special primes
        int sum = 0;
        for (int index = 0; index < specialPrimes.size(); index++) {
            sum += specialPrimes.get(index);
        }
        return sum;
    }

}