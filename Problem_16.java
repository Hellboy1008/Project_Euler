
//龍ONE

import java.math.BigInteger;

public class Problem_16 {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        BigInteger value = BigInteger.ONE.add(BigInteger.ONE);
        value = value.pow(1000);
        String power = value.toString();
        int answer = 0;
        for (int i = 0; i < power.length(); i++) {
            answer += Character.getNumericValue(power.charAt(i));
        }
        System.out.println(answer);
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
    }

}