
//龍ONE

import java.util.ArrayList;

public class Problem_38 {

    private static ArrayList<Long> pandigitalNums = new ArrayList<Long>();

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        long answer = findLargestPandigital(49999);
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println("The largest pandigital number is: " + answer);
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
    }

    private static long findLargestPandigital(int limit) {
        long[] powersOfTen = { 1, 10, 100, 1000, 10000, 100000 };
        boolean[] digitsList;
        // loop through numbers 1 to limit
        for (long countOne = 1; countOne < limit; countOne++) {
            long sum = 0;
            digitsList = new boolean[9];
            for (long countTwo = 1; countTwo < 10; countTwo++) {
                int digit = 0;
                long product = countOne * countTwo;
                while (product != 0) {
                    product /= 10;
                    digit++;
                }
                // check if sum is 0
                if (sum == 0) {
                    sum += countOne * countTwo;
                    continue;
                }
                sum = 1 * powersOfTen[digit] * sum + countOne * countTwo;
                // check if sum is 9 digits or above
                if (sum >= 100000000 && sum <= 1000000000 || sum >= 1000000000) {
                    break;
                }
            }
            // check if sum is a 9 digit number
            if (sum < 100000000 || sum > 1000000000) {
                continue;
            }
            // check if sum contains all 9 digits
            boolean allDigits = true;
            long sumTemp = sum;
            while (sum != 0) {
                // if the digit 0 exists, break
                if (sum % 10 == 0) {
                    allDigits = false;
                    break;
                }
                // check for duplicates
                if (digitsList[(int) sum % 10 - 1] == true) {
                    allDigits = false;
                    break;
                }
                digitsList[(int) sum % 10 - 1] = true;
                sum /= 10;
            }
            // add to ArrayList if it is pandigital
            if (allDigits == true) {
                pandigitalNums.add(sumTemp);
            }
        }
        // find largest value in the ArrayList
        long max = pandigitalNums.get(0);
        for (int index = 1; index < pandigitalNums.size(); index++) {
            if (pandigitalNums.get(index) > max) {
                max = pandigitalNums.get(index);
            }
        }
        return max;
    }

}