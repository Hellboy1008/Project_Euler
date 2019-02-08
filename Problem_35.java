
//龍ONE

import java.util.ArrayList;
import java.lang.StringBuilder;

public class Problem_35 {

    private static ArrayList<String> primes = new ArrayList<String>();
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
                StringBuilder prime = new StringBuilder("");
                primes.add(prime.append(index).toString());
            }
        }

        // remove primes that cannot be circular primes
        String[] nonCircularDigits = { "0", "2", "4", "5", "6", "8" };
        for (int index = 0; index < primes.size(); index++) {
            if (primes.get(index).length() != 1) {
                for (int index2 = 0; index2 < nonCircularDigits.length; index2++) {
                    if (primes.get(index).indexOf(nonCircularDigits[index2]) != -1) {
                        primes.remove(index);
                        index--;
                    }
                }
            }
        }

        int sum = 0;
        // check if the primes are circular
        for (int index = 0; index < primes.size(); index++) {
            if (primes.get(index).length() == 1) {
                sum++;
                continue;
            } else {
                boolean circular = true;
                for (int count = 0; count < primes.get(index).length() - 1; count++) {
                    StringBuilder rearrange = new StringBuilder("");
                    rearrange.append(primes.get(index).substring(1));
                    rearrange.append(primes.get(index).charAt(0));
                    if (primes.contains(rearrange.toString()) == true) {
                        primes.set(index, rearrange.toString());
                    } else {
                        circular = false;
                        break;
                    }
                }
                StringBuilder rearrange = new StringBuilder("");
                rearrange.append(primes.get(index).substring(1));
                rearrange.append(primes.get(index).charAt(0));
                primes.set(index, rearrange.toString());
                if (circular == true) {
                    sum++;
                }
            }
        }
        return sum;
    }
}