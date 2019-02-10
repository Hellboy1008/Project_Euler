
//龍ONE

import java.util.ArrayList;

public class Problem_37 {

    private static boolean[] notPrime;
    private static ArrayList<Integer> primes = new ArrayList<Integer>();
    private static ArrayList<Integer> specialPrimes = new ArrayList<Integer>();

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        // narrow through trial and error to 740000
        int answer = findSpecialPrimes(740000);
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println("The sum of the 11 primes is: " + answer);
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
    }

    private static int findSpecialPrimes(int size) {
        notPrime = new boolean[size];
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
        // deep copy primes to specialPrimes (don't count 2,3,5,7)
        int[] powersOfTen = { 10, 100, 1000, 10000, 100000 };
        for (int index = 4; index < primes.size(); index++) {
            // only primes that end with 3 or 7 are left truncatable
            if ((primes.get(index) % 10 != 3 && primes.get(index) % 10 != 7)) {
                continue;
            }
            // only numbers that start with 2,3,5,7 are right truncatable
            int digit = 0;
            int temp = primes.get(index);
            // find digits for original number
            while (temp != 0) {
                temp /= 10;
                digit++;
            }
            if (primes.get(index) / powersOfTen[digit - 2] != 2 && primes.get(index) / powersOfTen[digit - 2] != 3
                    && primes.get(index) / powersOfTen[digit - 2] != 5
                    && primes.get(index) / powersOfTen[digit - 2] != 7) {
                continue;
            }
            specialPrimes.add(primes.get(index));
        }
        // remove primes with even digits other than 2
        for (int index = 0; index < specialPrimes.size(); index++) {
            int temp = specialPrimes.get(index);
            while (temp != 0) {
                if (temp % 10 == 4 || temp % 10 == 6 || temp % 10 == 8 || temp % 10 == 0) {
                    specialPrimes.remove(index);
                    index--;
                    break;
                }
                temp /= 10;
            }
        }
        // check right truncatable or not
        for (int index = 0; index < specialPrimes.size(); index++) {
            int temp = specialPrimes.get(index);
            while (temp != 0) {
                if (primes.contains(temp / 10) == false && temp / 10 != 0) {
                    specialPrimes.remove(index);
                    index--;
                    break;
                }
                temp /= 10;
            }
        }
        // check left truncatable or not
        for (int index = 0; index < specialPrimes.size(); index++) {
            int digit = 0;
            int temp = specialPrimes.get(index);
            // find digits for original number
            while (temp != 0) {
                temp /= 10;
                digit++;
            }
            int tempTwo = specialPrimes.get(index);
            // left truncate numbers
            for (int count = 0; count < digit; count++) {
                if (tempTwo < 10) {
                    if (primes.contains(tempTwo % 10) == false) {
                        specialPrimes.remove(index);
                        index--;
                    }
                    break;
                }
                if (primes.contains(tempTwo % powersOfTen[digit - count - 2]) == false) {
                    specialPrimes.remove(index);
                    index--;
                    break;
                } else {
                    tempTwo %= powersOfTen[digit - count - 2];
                }
            }
        }
        // return sum of the special primes
        int sum = 0;
        for (int index = 0; index < specialPrimes.size(); index++) {
            sum += specialPrimes.get(index);
        }
        return sum;
    }

}