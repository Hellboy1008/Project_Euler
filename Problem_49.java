import java.util.Arrays;

//龍ONE

public class Problem_49 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The 12-digit number is: ";
    private static final int FOUR_DIGIT_MAX = 9999;
    private static final int SMALLEST_PRIME = 2;
    private static final int LOWER_BOUND = 1488;
    private static final int TENS_DIGIT = 10;

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String answer = primePermutations();
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + answer);
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
    }

    private static String primePermutations() {
        // initialise boolean array
        boolean[] notPrime = new boolean[FOUR_DIGIT_MAX + 1];
        // set all non prime numbers to true
        for (int index = SMALLEST_PRIME; index < notPrime.length; index++) {
            if (index != SMALLEST_PRIME && index % SMALLEST_PRIME == 0) {
                continue;
            }
            for (int counter = index * SMALLEST_PRIME; counter < notPrime.length; counter += index) {
                notPrime[counter] = true;
            }
        }
        // intialise prime array
        int numOfPrimes = 0;
        for (int index = LOWER_BOUND; index < notPrime.length; index++) {
            if (notPrime[index] == false) {
                numOfPrimes++;
            }
        }
        int[] prime = new int[numOfPrimes];
        int primeIndex = 0;
        for (int index = LOWER_BOUND; index < notPrime.length; index++) {
            if (notPrime[index] == false) {
                prime[primeIndex] = index;
                primeIndex++;
            }
        }
        // find permutation
        for (int indexOne = 0; indexOne < prime.length; indexOne++) {
            for (int indexTwo = indexOne + 1; indexTwo < prime.length; indexTwo++) {
                int primeThree = prime[indexTwo] + (prime[indexTwo] - prime[indexOne]);
                if (primeThree > notPrime.length) {
                    break;
                }
                if (notPrime[primeThree] == true) {
                    continue;
                }
                if (numValue(prime[indexOne], prime[indexTwo]) == true && numValue(prime[indexTwo], primeThree)) {
                    return "" + prime[indexOne] + prime[indexTwo] + primeThree;
                }
            }
        }
        return "";
    }

    private static boolean numValue(int numOne, int numTwo) {
        int[] digitsOne = new int[TENS_DIGIT];
        int[] digitsTwo = new int[TENS_DIGIT];
        while (numOne != 0 && numTwo != 0) {
            digitsOne[numOne % TENS_DIGIT]++;
            digitsTwo[numTwo % TENS_DIGIT]++;
            numOne /= TENS_DIGIT;
            numTwo /= TENS_DIGIT;
        }
        // check if digits are equal
        for (int index = 0; index < digitsOne.length; index++) {
            if (digitsOne[index] != digitsTwo[index]) {
                return false;
            }
        }
        return true;
    }
}