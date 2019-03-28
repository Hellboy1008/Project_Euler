
//龍ONE

import java.math.BigInteger;

public class Problem_26 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The longest recurring cycle is 1 / ";
    private static final int UPPER_BOUND = 1000;
    private static final int FACTOR_ONE = 2;
    private static final int FACTOR_TWO = 5;

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int answer = determineLongestCycle(UPPER_BOUND);
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + answer);
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
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
        while (number % FACTOR_ONE == 0) {
            number = number / FACTOR_ONE;
        }
        while (number % FACTOR_TWO == 0) {
            number = number / FACTOR_TWO;
        }
        return number;
    }

}