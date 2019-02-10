
//龍ONE

import java.util.ArrayList;
import java.lang.StringBuilder;

public class Problem_35 {

    private static ArrayList<Integer> primes = new ArrayList<Integer>();
    private static boolean[] circularPrimes;
    private static boolean[] notPrime = new boolean[1000000 + 1];

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int answer = findPrimes();
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println("The number of circle prime numbers is: " + answer);
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
    }

    private static int findPrimes() {
        // set all non prime numbers to true
        for (int index = 2; index < notPrime.length; index++) {
            for (int counter = index * 2; counter < notPrime.length; counter += index) {
                notPrime[counter] = true;
            }
        }
        // add primes to the array
        for (int index = 2; index < notPrime.length; index++) {
            if (notPrime[index] == false) {
                primes.add(index);
            }
        }
        // initialise boolean ArrayList
        circularPrimes = new boolean[primes.size()];
        for (int index = 0; index < primes.size(); index++) {
            circularPrimes[index] = true;
        }
        // remove primes that cannot be circular primes (starting from 11)
        for (int index = 4; index < primes.size(); index++) {
            int temp = primes.get(index);
            boolean possibleCircular = true;
            while (temp != 0) {
                if (temp % 10 == 0 || temp % 10 == 2 || temp % 10 == 4 || temp % 10 == 5 || temp % 10 == 6
                        || temp % 10 == 8) {
                    possibleCircular = false;
                    break;
                }
                temp /= 10;
            }
            if (possibleCircular == false) {
                circularPrimes[index] = false;
            }
        }
        // check if the primes are circular primes
        int sum = 0;
        int[] powersOfTen = { 10, 100, 1000, 10000, 100000 };
        for (int index = 0; index < circularPrimes.length; index++) {
            if (circularPrimes[index] == false) {
                continue;
            }
            int temp = primes.get(index);
            int digits = 0;
            while (temp != 0) {
                temp /= 10;
                digits++;
            }
            temp = primes.get(index);
            for (int count = 0; count < digits - 1; count++) {
                temp = (temp / 10) + factorsOfTen[digits - 2] * (temp % 10);
                if (primes.contains(temp) == false) {
                    circularPrimes[index] = false;
                    break;
                }
            }
        }
        // count the number of circular primes
        for (int index = 0; index < circularPrimes.length; index++) {
            if (circularPrimes[index] == true) {
                sum++;
            }
        }
        return sum;
    }
}