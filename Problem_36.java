
//龍ONE

import java.math.BigInteger;

public class Problem_36 {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        BigInteger answer = sumOfDoubleBasePalindrome(1000000);
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println("The sum of these special numbers is: " + answer);
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
    }

    private static BigInteger sumOfDoubleBasePalindrome(int limit) {
        BigInteger sum = BigInteger.ZERO;
        for (int count = 0; count < limit; count++) {
            // check if the number itself is a palindrome
            BigInteger a = new BigInteger("" + count);
            if (checkPalindrome(a) == false) {
                continue;

            }
            // check if the binary is a palindrome
            BigInteger binary = new BigInteger(Integer.toBinaryString(count));
            if (checkPalindrome(binary) == true) {
                sum = sum.add(a);
            }
        }
        return sum;
    }

    private static boolean checkPalindrome(BigInteger num) {
        BigInteger originalNumber = num;
        BigInteger reverse = BigInteger.ZERO;
        BigInteger ten = new BigInteger("10");
        while (originalNumber.compareTo(BigInteger.ONE) == 1 || originalNumber.equals(BigInteger.ONE)) {
            reverse = reverse.multiply(ten).add(originalNumber.mod(ten));
            originalNumber = originalNumber.divide(ten);
        }
        if (reverse.equals(num)) {
            return true;
        } else {
            return false;
        }
    }

}