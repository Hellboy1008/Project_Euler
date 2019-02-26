import java.util.Arrays;

//龍ONE

public class Problem_49 {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String answer = primePermutations();
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println("The 12-digit number is: " + answer);
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
    }

    private static String primePermutations() {
        // initialise boolean array
        boolean[] notPrime = new boolean[10000];
        // set all non prime numbers to true
        for (int index = 2; index < notPrime.length; index++) {
            if (index != 2 && index % 2 == 0) {
                continue;
            }
            for (int counter = index * 2; counter < notPrime.length; counter += index) {
                notPrime[counter] = true;
            }
        }
        // intialise prime array
        int numOfPrimes = 0;
        for (int index = 1488; index < notPrime.length; index++) {
            if (notPrime[index] == false) {
                numOfPrimes++;
            }
        }
        int[] prime = new int[numOfPrimes];
        int primeIndex = 0;
        for (int index = 1488; index < notPrime.length; index++) {
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
        int[] digitsOne = new int[10];
        int[] digitsTwo = new int[10];
        while (numOne != 0 && numTwo != 0) {
            digitsOne[numOne % 10]++;
            digitsTwo[numTwo % 10]++;
            numOne /= 10;
            numTwo /= 10;
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