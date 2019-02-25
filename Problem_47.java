
//龍ONE

public class Problem_47 {

    private static boolean[] notPrime;
    private static int[] primeNums;
    private static int[] nonPrimeNums;

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int answer = findConsecutiveNums(210, 150000);
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println("The first number of the 4 consecutive integers is: " + answer);
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
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
            if (primeCount == 4) {
                consecutive++;
            } else {
                consecutive = 0;
            }
            if (consecutive == 4) {
                return nonPrimeNums[count] - 3;
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
        for (int index = 2; index < notPrime.length; index++) {
            if (index != 2 && index % 2 == 0) {
                continue;
            }
            for (int counter = index * 2; counter < notPrime.length; counter += index) {
                notPrime[counter] = true;
            }
        }
        // find the number of primes and non-primes
        int primeLength = 0;
        int nonPrimeLength = 0;
        for (int index = 2; index < notPrime.length; index++) {
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
        for (int index = 2; index < notPrime.length; index++) {
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