
//龍ONE

import java.lang.StringBuilder;
import java.util.ArrayList;

public class Problem_36 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The sum of these special numbers is: ";
    private static final int UPPER_BOUND = 1000000;
    private static final int TENS_DIGIT = 10;
    private static ArrayList<Integer> palindromeNums = new ArrayList<Integer>();

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int answer = sumOfDoubleBasePalindrome(UPPER_BOUND);
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + answer);
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
    }

    private static void findPalindromes(int limit) {
        for (int count = 0; count < limit; count++) {
            int originalNumber = count;
            int reverse = 0;
            if (originalNumber % TENS_DIGIT == 0) {
                continue;
            }
            while (originalNumber >= 1) {
                reverse = reverse * TENS_DIGIT + originalNumber % TENS_DIGIT;
                originalNumber /= TENS_DIGIT;
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