
//龍ONE

import java.math.BigInteger;

public class Problem_48 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The last ten digits of the series is: ";
    private static final int POWER = 1000;
    private static final int LAST_DIGITS = 10;

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String answer = computeSeries();
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + answer);
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
    }

    private static String computeSeries() {
        BigInteger num = BigInteger.ONE;
        BigInteger sum = BigInteger.ZERO;
        for (int count = 1; count <= POWER; count++) {
            sum = sum.add(num.pow(count));
            num = num.add(BigInteger.ONE);
        }
        String sumString = sum.toString();
        return sumString.substring(sumString.length() - LAST_DIGITS);
    }
}