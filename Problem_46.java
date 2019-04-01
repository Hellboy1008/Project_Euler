
//龍ONE

public class Problem_46 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The smallest odd composite that cannot be written"
            + " as a sum of a prime and twice a square is: ";
    private static final int UPPER_BOUND = 6000; // guess and check upper limit
    private static final int SMALLEST_PRIME = 2;

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int answer = findCounterExample();
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + answer);
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
    }

    private static int findCounterExample() {
        boolean counterEx = true;
        boolean[] notPrime = new boolean[UPPER_BOUND];
        // set all non prime numbers to true
        for (int index = SMALLEST_PRIME; index < notPrime.length; index++) {
            if (index != SMALLEST_PRIME && index % SMALLEST_PRIME == 0) {
                continue;
            }
            for (int counter = index * SMALLEST_PRIME; counter < notPrime.length; counter += index) {
                notPrime[counter] = true;
            }
        }
        // find counter example
        for (int indexOne = SMALLEST_PRIME; indexOne < notPrime.length; indexOne++) {
            // only count odd composite
            if (indexOne % SMALLEST_PRIME == 0 || notPrime[indexOne] == false) {
                continue;
            }
            counterEx = true;
            for (int indexTwo = SMALLEST_PRIME; indexTwo < notPrime.length; indexTwo++) {
                // skip all non primes
                if (notPrime[indexTwo] == true) {
                    continue;
                }
                // see if number satisfies conjecture
                if (indexTwo > indexOne) {
                    break;
                } else {
                    double a = Math.sqrt((indexOne - indexTwo) / SMALLEST_PRIME);
                    if (a == (int) a) {
                        counterEx = false;
                        break;
                    }
                }
            }
            if (counterEx == true) {
                return indexOne;
            }
        }
        return 0;
    }
}