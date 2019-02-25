
//龍ONE

public class Problem_47 {

    private static boolean[] notPrime;

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int answer = findConsecutiveNums(210, 150000);
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println("The first number of the 4 consecutive integers is: " + answer);
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
    }

    private static int findConsecutiveNums(int lowerLimit, int upperLimit) {
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
        // find factors
        int[] numOfPrimeFactors = new int[upperLimit];
        for (int index = lowerLimit; index < numOfPrimeFactors.length; index++) {
            if (notPrime[index] == true) {
                for (int counter = 2; counter <= Math.sqrt(index); counter++) {
                    if (notPrime[counter] == false && index % counter == 0) {
                        numOfPrimeFactors[index]++;
                    }
                    if (notPrime[index / counter] == false && index % counter == 0) {
                        numOfPrimeFactors[index]++;
                    }
                }
            }
            // find first number
            if (numOfPrimeFactors[index] == 4 && numOfPrimeFactors[index - 1] == 4 && numOfPrimeFactors[index - 2] == 4
                    && numOfPrimeFactors[index - 3] == 4) {
                return index - 3;
            }
        }
        return 0;
    }

}