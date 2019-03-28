
//龍ONE

import java.math.BigInteger;

public class Problem_25 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The index of the first fibonacci with 1000 digits is: ";
    private static final int TOTAL_DIGITS = 1000;
    private static final int SUM_OF_FIRST_THREE_FIBONACCI = 2;
    private static BigInteger fibonacciOne = BigInteger.ONE;
    private static BigInteger fibonacciTwo = BigInteger.ONE;

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int answer = findFibonacciIndex(TOTAL_DIGITS);
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + answer);
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
    }

    private static int findFibonacciIndex(int digits) {
        int counter = SUM_OF_FIRST_THREE_FIBONACCI; // count first 2 ones in the sequence
        BigInteger calculatedFibonacci = BigInteger.ZERO;
        while (calculatedFibonacci.toString().length() < digits) {
            calculatedFibonacci = fibonacciOne.add(fibonacciTwo);
            fibonacciOne = fibonacciTwo;
            fibonacciTwo = calculatedFibonacci;
            counter++;
        }
        return counter;
    }

}