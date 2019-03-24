
//龍ONE

public class Problem_10 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The sum of all prime numbers below two million is: ";
    private static final int SMALLEST_PRIME = 2;
    private static boolean[] notPrime = new boolean[2000000 + 1];

    public static void main(String[] args) {

        long startTime = System.nanoTime();
        long sum = findPrimeSum();
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + sum);
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
    }

    private static long findPrimeSum() {
        long primeSum = 0;
        // set all non prime numbers to true
        for (int index = SMALLEST_PRIME; index < notPrime.length; index++) {
            for (int counter = index * SMALLEST_PRIME; counter < notPrime.length; counter += index) {
                notPrime[counter] = true;
            }
        }
        // sum all prime numbers
        for (int index = SMALLEST_PRIME; index < notPrime.length; index++) {
            if (notPrime[index] == false) {
                primeSum += (long) index;
            }
        }
        return primeSum;
    }
}