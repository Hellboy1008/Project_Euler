
//龍ONE

public class Problem_10 {

    private static boolean[] notPrime = new boolean[2000000 + 1];

    public static void main(String[] args) {

        long startTime = System.nanoTime();
        long sum = findPrimeSum();
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println("The sum of all prime numbers below two million is: " + sum);
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
    }

    private static long findPrimeSum() {
        long primeSum = 0;
        // set all non prime numbers to true
        for (int index = 2; index < notPrime.length; index++) {
            for (int counter = index * 2; counter < notPrime.length; counter += index) {
                notPrime[counter] = true;
            }
        }
        // sum all prime numbers
        for (int index = 2; index < notPrime.length; index++) {
            if (notPrime[index] == false) {
                primeSum += (long) index;
            }
        }
        return primeSum;
    }
}