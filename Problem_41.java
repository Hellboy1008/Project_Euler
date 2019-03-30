
//龍ONE

public class Problem_41 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The largest n-digit pandigital prime is: ";
    private static final int UPPER_BOUND = 10000000;
    private static final int SMALLEST_PRIME = 2;
    private static final int TENS_DIGIT = 10;
    private static boolean[] notPrime;

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int answer = findPandigitalPrime(UPPER_BOUND);
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + answer);
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
    }

    private static int findPandigitalPrime(int limit) {
        notPrime = new boolean[limit];
        // set all non prime numbers to true
        for (int index = SMALLEST_PRIME; index < notPrime.length; index++) {
            if (index != SMALLEST_PRIME && index % SMALLEST_PRIME == 0) {
                continue;
            }
            for (int counter = index * SMALLEST_PRIME; counter < notPrime.length; counter += index) {
                notPrime[counter] = true;
            }
        }
        // find all pandigital primes
        for (int index = notPrime.length - 1; index >= 0; index--) {
            if (notPrime[index] == false && isPandigital(index) == true) {
                return index;
            }
        }
        return 0;
    }

    private static boolean isPandigital(int num) {
        // find number of digits
        int tempOne = num;
        int digitCount = 0;
        while (tempOne > 0) {
            digitCount++;
            tempOne /= TENS_DIGIT;
        }
        // initialise array with false
        boolean[] digits = new boolean[TENS_DIGIT - 1];
        int tempTwo = num;
        for (int count = 0; count < digitCount; count++) {
            if (tempTwo % TENS_DIGIT == 0) {
                return false;
            }
            if (digits[tempTwo % TENS_DIGIT - 1] == false) {
                digits[tempTwo % TENS_DIGIT - 1] = true;
            } else {
                return false;
            }
            tempTwo /= TENS_DIGIT;
        }
        // check if it uses the digits from 1 to n exactly once
        for (int index = 0; index < digitCount; index++) {
            if (digits[index] == false) {
                return false;
            }
        }
        return true;
    }

}