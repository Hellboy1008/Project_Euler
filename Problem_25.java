
//龍ONE

import java.math.BigInteger;

public class Problem_25 {

    private static BigInteger fibonacciOne = BigInteger.ONE;
    private static BigInteger fibonacciTwo = BigInteger.ONE;

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int answer = findFibonacciIndex(1000);
        System.out.println("The index of the first fibonacci with 1000 digits is: " + answer);
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
    }

    private static int findFibonacciIndex(int digits) {
        int counter = 2; // count first 2 ones in the sequence
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