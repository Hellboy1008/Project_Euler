import java.util.ArrayList;

//龍ONE

public class Problem_50 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The prime number is: ";
    private static final int UPPER_BOUND = 1000000;
    private static final int SMALLEST_PRIME = 2;

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int answer = findPrime();
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + answer);
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
    }

    private static int findPrime() {
        // initialise boolean array
        boolean[] notPrime = new boolean[UPPER_BOUND + 1];
        // set all non prime numbers to true
        for (int index = SMALLEST_PRIME; index < notPrime.length; index++) {
            if (index != SMALLEST_PRIME && index % SMALLEST_PRIME == 0) {
                continue;
            }
            for (int counter = index * SMALLEST_PRIME; counter < notPrime.length; counter += index) {
                notPrime[counter] = true;
            }
        }
        // initialise consecutive prime array
        ArrayList<Integer> consecutivePrime = new ArrayList<Integer>();
        consecutivePrime.add(SMALLEST_PRIME); // add zero first
        for (int index = SMALLEST_PRIME + 1; index < notPrime.length; index++) {
            if (notPrime[index] == false) {
                consecutivePrime.add(index + consecutivePrime.get(consecutivePrime.size() - 1));
            }
        }
        // find largest number
        int numberOfPrimes = 0;
        int answerPrime = 0;
        for (int indexOne = numberOfPrimes; indexOne < consecutivePrime.size(); indexOne++) {
            for (int indexTwo = indexOne - (numberOfPrimes + 1); indexTwo >= 0; indexTwo--) {
                int diff = consecutivePrime.get(indexOne) - consecutivePrime.get(indexTwo);
                if (diff >= UPPER_BOUND) {
                    break;
                } else if (diff <= 0) {
                    continue;
                }
                if (notPrime[diff] == false) {
                    numberOfPrimes = indexOne - indexTwo;
                    answerPrime = diff;
                }
            }
        }
        return answerPrime;
    }

}