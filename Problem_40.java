
//龍ONE

public class Problem_40 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The value of the expression is: ";
    private static final int[] DIGIT_PARTS = { 1, 10, 100, 1000, 10000, 100000, 1000000 };
    private static final int TENS_DIGITS = 2;
    private static final int HUNDREDS_DIGITS = 3;
    private static final int THOUSANDS_DIGITS = 4;
    private static final int TEN_THOUSANDS_DIGITS = 5;
    private static final int HUNDRED_THOUSANDS_DIGITS = 6;

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int answer = findProduct(DIGIT_PARTS);
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + answer);
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
    }

    private static int findProduct(int[] digits) {
        int currentDigit = 0;
        int index = 0;
        int product = 1;
        for (int count = 1; count < DIGIT_PARTS[DIGIT_PARTS.length - 1]; count++) {
            // add to digit count accordingly
            if (count < DIGIT_PARTS[1]) {
                currentDigit++;
            } else if (count >= DIGIT_PARTS[1] && count < DIGIT_PARTS[HUNDREDS_DIGITS - 1]) {
                currentDigit += TENS_DIGITS;
            } else if (count >= DIGIT_PARTS[HUNDREDS_DIGITS - 1] && count < DIGIT_PARTS[THOUSANDS_DIGITS - 1]) {
                currentDigit += HUNDREDS_DIGITS;
            } else if (count >= DIGIT_PARTS[THOUSANDS_DIGITS - 1] && count < DIGIT_PARTS[TEN_THOUSANDS_DIGITS - 1]) {
                currentDigit += THOUSANDS_DIGITS;
            } else if (count >= DIGIT_PARTS[TEN_THOUSANDS_DIGITS - 1]
                    && count < DIGIT_PARTS[HUNDRED_THOUSANDS_DIGITS - 1]) {
                currentDigit += TEN_THOUSANDS_DIGITS;
            } else if (count >= DIGIT_PARTS[HUNDRED_THOUSANDS_DIGITS - 1]
                    && count < DIGIT_PARTS[DIGIT_PARTS.length - 1]) {
                currentDigit += HUNDRED_THOUSANDS_DIGITS;
            }
            if (currentDigit > digits[index]) {
                int difference = currentDigit - digits[index];
                int temp = count;
                for (int counter = 0; counter < difference; counter++) {
                    temp /= DIGIT_PARTS[1];
                }
                product *= temp % DIGIT_PARTS[1];
                index++;
            } else if (currentDigit == digits[index]) {
                int temp = count;
                while (temp > DIGIT_PARTS[1]) {
                    temp /= DIGIT_PARTS[1];
                }
                product *= temp;
                index++;
            }
            if (index == digits.length) {
                break;
            }
        }
        return product;
    }
}