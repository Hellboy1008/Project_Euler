
//龍ONE

import java.math.BigInteger;

public class Problem_26 {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int answer = determineLongestCycle(1000);
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println("The longest recurring cycle is 1 / " + answer);
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
    }

    private static int determineLongestCycle(int maxDivisor) {
        int longestCycle = 0;
        int longestCycleDivisor = 0;
        BigInteger base = BigInteger.TEN;
        BigInteger modValue;
        for (int divisor = 1; divisor <= maxDivisor; divisor++) {
            if (removeFactors(divisor) == 1) {
                continue;
            } else {
                int power = 1;
                modValue = new BigInteger("" + removeFactors(divisor));
                while (base.pow(power).mod(modValue).intValue() != 1) {
                    power++;
                }
                if (power > longestCycle) {
                    longestCycle = power;
                    longestCycleDivisor = divisor;
                }
            }
        }
        return longestCycleDivisor;
    }

    private static int removeFactors(int number) {
        while (number % 2 == 0) {
            number = number / 2;
        }
        while (number % 5 == 0) {
            number = number / 5;
        }
        return number;
    }

}