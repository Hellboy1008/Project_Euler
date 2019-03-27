
//龍ONE

import java.math.BigInteger;

public class Problem_20 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The sum of all the digits is: ";
    private static final int FACTORIAL_NUM = 100;

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int answer = 0;
        String factorialString = "";
        BigInteger factorial = BigInteger.ONE;
        BigInteger startingNum = BigInteger.ONE;
        // calculate 100!
        for (int index = 1; index <= FACTORIAL_NUM; index++) {
            factorial = factorial.multiply(startingNum);
            startingNum = startingNum.add(BigInteger.ONE);
        }
        // find sum of all digits
        factorialString = factorial.toString();
        for (int index = 0; index < factorialString.length(); index++) {
            answer += Character.getNumericValue(factorialString.charAt(index));
        }
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + answer);
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
    }

}