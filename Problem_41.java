
//龍ONE

public class Problem_41 {

    private static boolean[] notPrime;

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int answer = findPandigitalPrime(10000000);
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println("The largest n-digit pandigital prime is: " + answer);
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
    }

    private static int findPandigitalPrime(int limit) {
        notPrime = new boolean[limit];
        // set all non prime numbers to true
        for (int index = 2; index < notPrime.length; index++) {
            for (int counter = index * 2; counter < notPrime.length; counter += index) {
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
            tempOne /= 10;
        }
        // initialise array with false
        boolean[] digits = new boolean[9];
        int tempTwo = num;
        for (int count = 0; count < digitCount; count++) {
            if (tempTwo % 10 == 0) {
                return false;
            }
            if (digits[tempTwo % 10 - 1] == false) {
                digits[tempTwo % 10 - 1] = true;
            } else {
                return false;
            }
            tempTwo /= 10;
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