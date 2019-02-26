
//龍ONE

import java.math.BigInteger;

public class Problem_48 {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String answer = computeSeries();
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println("The last ten digits of the series is: " + answer);
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
    }

    private static String computeSeries() {
        BigInteger num = BigInteger.ONE;
        BigInteger sum = BigInteger.ZERO;
        for (int count = 1; count <= 1000; count++) {
            sum = sum.add(num.pow(count));
            num = num.add(BigInteger.ONE);
        }
        String sumString = sum.toString();
        return sumString.substring(sumString.length() - 10);
    }
}