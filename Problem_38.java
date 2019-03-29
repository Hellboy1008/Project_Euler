
//龍ONE

public class Problem_38 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The largest pandigital number is: ";
    private static final int UPPER_BOUND = 9999;
    private static final int TENS_DIGIT = 10;
    private static final int NINE_DIGITS_MIN = 100000000;
    private static final int TEN_DIGITS_MIN = 1000000000;
    private static final long[] POWERS_OF_TEN = { 1, 10, 100, 1000, 10000, 100000 };

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        long answer = findLargestPandigital(UPPER_BOUND);
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + answer);
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
    }

    private static long findLargestPandigital(int limit) {

        boolean[] digitsList;
        long max = 0;
        // loop through numbers 1 to limit
        for (long countOne = 1; countOne < limit; countOne++) {
            long sum = 0;
            digitsList = new boolean[9];
            for (long countTwo = 1; countTwo < TENS_DIGIT; countTwo++) {
                int digit = 0;
                long product = countOne * countTwo;
                while (product != 0) {
                    product /= TENS_DIGIT;
                    digit++;
                }
                // check if sum is 0
                if (sum == 0) {
                    sum += countOne * countTwo;
                    continue;
                }
                sum = 1 * POWERS_OF_TEN[digit] * sum + countOne * countTwo;
                // check if sum is 9 digits or above
                if (sum >= NINE_DIGITS_MIN && sum <= TEN_DIGITS_MIN || sum >= TEN_DIGITS_MIN) {
                    break;
                }
            }
            // check if sum is a 9 digit number
            if (sum < NINE_DIGITS_MIN || sum > TEN_DIGITS_MIN) {
                continue;
            }
            // check if sum contains all 9 digits
            boolean allDigits = true;
            long sumTemp = sum;
            while (sum != 0) {
                // if the digit 0 exists, break
                if (sum % TENS_DIGIT == 0) {
                    allDigits = false;
                    break;
                }
                // check for duplicates
                if (digitsList[(int) sum % TENS_DIGIT - 1] == true) {
                    allDigits = false;
                    break;
                }
                digitsList[(int) sum % TENS_DIGIT - 1] = true;
                sum /= TENS_DIGIT;
            }
            // check if the pandigital num is bigger than the previous one
            if (allDigits == true && sumTemp > max) {
                max = sumTemp;
            }
        }
        return max;
    }

}