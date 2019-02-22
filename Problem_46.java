
//龍ONE

public class Problem_46 {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int answer = findCounterExample();
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out
                .println("The smallest odd composite that cannot be written as a sum of a prime and twice a square is: "
                        + answer);
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
    }

    private static int findCounterExample() {
        boolean counterEx = true;
        boolean[] notPrime = new boolean[10000]; // guess and check upper limit
        // set all non prime numbers to true
        for (int index = 2; index < notPrime.length; index++) {
            if (index != 2 && index % 2 == 0) {
                continue;
            }
            for (int counter = index * 2; counter < notPrime.length; counter += index) {
                notPrime[counter] = true;
            }
        }
        // find counte example
        for (int indexOne = 2; indexOne < notPrime.length; indexOne++) {
            // only count odd composite
            if (indexOne % 2 == 0 || notPrime[indexOne] == false) {
                continue;
            }
            counterEx = true;
            for (int indexTwo = 2; indexTwo < notPrime.length; indexTwo++) {
                // skip all non primes
                if (notPrime[indexTwo] == true) {
                    continue;
                }
                // see if number satisfies conjecture
                if (indexTwo > indexOne) {
                    break;
                } else {
                    double a = Math.sqrt((indexOne - indexTwo) / 2);
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