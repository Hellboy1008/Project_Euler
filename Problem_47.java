
//龍ONE

public class Problem_47 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The first number of the 4 consecutive integers is: ";
    private static final int LOWER_BOUND = 647;
    private static final int UPPER_BOUND = 140000; // guess and check;
    private static final int CONSECUTIVE_PRIMES = 4;
    private static final int SMALLEST_PRIME = 2;
    private static boolean[] notPrime;
    private static int[] primeNums;
    private static int[] nonPrimeNums;

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int answer = findConsecutiveNums(LOWER_BOUND, UPPER_BOUND);
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + answer);
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
    }

    private static int findConsecutiveNums(int lowerLimit, int upperLimit) {
        initialiseArrays(lowerLimit, upperLimit);
        // find the number of prime factors
        int primeIndex;
        int previousIndex;
        int primeCount = 0;
        int temp;
        int consecutive = 0;
        for (int count = 0; count < nonPrimeNums.length; count++) {
            temp = nonPrimeNums[count];
            primeIndex = 0;
            previousIndex = -1;
            primeCount = 0;
            // find all prime factors
            while (temp != 1) {
                // there is always only one prime factor that is greater than the square root of
                // the number
                if (primeNums[primeIndex] >= Math.sqrt(nonPrimeNums[count])) {
                    primeCount++;
                    break;
                }
                if (temp % primeNums[primeIndex] == 0) {
                    temp /= primeNums[primeIndex];
                    if (previousIndex != primeIndex) {
                        primeCount++;
                    }
                    previousIndex = primeIndex;
                } else {
                    primeIndex++;
                }
            }
            if (primeCount == CONSECUTIVE_PRIMES) {
                consecutive++;
            } else {
                consecutive = 0;
            }
            if (consecutive == CONSECUTIVE_PRIMES) {
                return nonPrimeNums[count] - (CONSECUTIVE_PRIMES - 1);
            }
            // if the numbers are no consecutive, ignore
            if (nonPrimeNums[count + 1] != nonPrimeNums[count] + 1) {
                consecutive = 0;
            }
        }
        return primeCount;
    }

    private static void initialiseArrays(int lowerLimit, int upperLimit) {
        // initialise boolean array
        notPrime = new boolean[upperLimit];
        // set all non prime numbers to true
        for (int index = SMALLEST_PRIME; index < notPrime.length; index++) {
            if (index != SMALLEST_PRIME && index % SMALLEST_PRIME == 0) {
                continue;
            }
            for (int counter = index * SMALLEST_PRIME; counter < notPrime.length; counter += index) {
                notPrime[counter] = true;
            }
        }
        // find the number of primes and non-primes
        int primeLength = 0;
        int nonPrimeLength = 0;
        for (int index = SMALLEST_PRIME; index < notPrime.length; index++) {
            if (notPrime[index] == true) {
                nonPrimeLength++;
            } else {
                primeLength++;
            }
        }
        // initialise prime and nonPrime int[] arrays
        int primeIndex = 0;
        int nonPrimeIndex = 0;
        primeNums = new int[primeLength];
        nonPrimeNums = new int[nonPrimeLength];
        for (int index = SMALLEST_PRIME; index < notPrime.length; index++) {
            if (notPrime[index] == true && index > lowerLimit) {
                nonPrimeNums[nonPrimeIndex] = index;
                nonPrimeIndex++;
            } else if (notPrime[index] == false) {
                primeNums[primeIndex] = index;
                primeIndex++;
            }
        }
    }

}