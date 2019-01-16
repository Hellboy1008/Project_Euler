
//龍ONE

import java.math.BigInteger;

public class Problem_20 {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int answer = 0;
        String factorialString = "";
        BigInteger factorial = BigInteger.ONE;
        BigInteger startingNum = BigInteger.ONE;
        // calculate 100!
        for (int index = 1; index <= 100; index++) {
            factorial = factorial.multiply(startingNum);
            startingNum = startingNum.add(BigInteger.ONE);
        }
        // find sum of all digits
        factorialString = factorial.toString();
        for (int index = 0; index < factorialString.length(); index++) {
            answer += Character.getNumericValue(factorialString.charAt(index));
        }
        System.out.println("The sum of all the digits is: " + answer);
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
    }

}