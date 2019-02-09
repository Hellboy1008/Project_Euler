
//龍ONE

import java.lang.StringBuilder;
import java.util.ArrayList;

public class Problem_36 {

    private static ArrayList<Integer> palindromeNums = new ArrayList<Integer>();

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int answer = sumOfDoubleBasePalindrome(1000000);
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println("The sum of these special numbers is: " + answer);
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
    }

    private static void findPalindromes(int limit) {
        for (int count = 0; count < limit; count++) {
            int originalNumber = count;
            int reverse = 0;
            if (originalNumber % 10 == 0) {
                continue;
            }
            while (originalNumber >= 1) {
                reverse = reverse * 10 + originalNumber % 10;
                originalNumber /= 10;
            }
            if (count == reverse) {
                palindromeNums.add(count);
            }
        }
    }

    private static int sumOfDoubleBasePalindrome(int limit) {
        int sum = 0;
        findPalindromes(limit);
        for (int index = 0; index < palindromeNums.size(); index++) {
            StringBuilder binary = new StringBuilder(Integer.toBinaryString(palindromeNums.get(index)));
            if (binary.toString().equals(binary.reverse().toString())) {
                sum += palindromeNums.get(index);
            }
        }
        return sum;
    }

}