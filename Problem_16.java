
//龍ONE

import java.math.BigInteger;

public class Problem_16 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The sum of the digits of 2^1000 is: ";
    private static final int POWER = 1000;

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        BigInteger value = BigInteger.ONE.add(BigInteger.ONE);
        value = value.pow(POWER);
        String power = value.toString();
        int answer = 0;
        for (int index = 0; index < power.length(); index++) {
            answer += Character.getNumericValue(power.charAt(index));
        }
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + answer);
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
    }

}