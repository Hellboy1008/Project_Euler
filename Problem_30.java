
//龍ONE

public class Problem_30 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The sum of numbers that can be written as the sum"
            + " of the fifth powers of the digits is: ";
    private static final int UPPER_BOUND = 354294;
    private static final int LOWER_BOUND = 2;
    private static final int DIVISOR = 10;
    private static final int POWER = 5;

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int answer = sumDigitPowers(UPPER_BOUND);
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + answer);
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
    }

    private static int sumDigitPowers(int maxValue) {
        int specialNumbers = 0;
        int sumOfPowers = 0;
        for (int num = LOWER_BOUND; num < maxValue; num++) {
            int temp = num;
            while (temp != 0) {
                sumOfPowers += Math.pow(temp % DIVISOR, POWER);
                temp /= DIVISOR;
            }
            if (sumOfPowers == num) {
                specialNumbers += num;
            }
            sumOfPowers = 0;
        }
        return specialNumbers;
    }

}