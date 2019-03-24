
//龍ONE

public class Problem_06 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The difference is: ";
    private static final int UPPER_BOUND = 100;
    private static final int MULTIPLIER_TWO = 2;
    private static final int MULTIPLIER_THREE = 3;
    private static final int DIVISOR_FOUR = 4;
    private static final int DIVISOR_SIX = 6;

    public static void main(String[] args) {

        long startTime = System.nanoTime();
        int answer = 0;
        int equationOne = (UPPER_BOUND * UPPER_BOUND * UPPER_BOUND * UPPER_BOUND
                + MULTIPLIER_TWO * UPPER_BOUND * UPPER_BOUND * UPPER_BOUND + UPPER_BOUND * UPPER_BOUND) / DIVISOR_FOUR;
        int equationTwo = (MULTIPLIER_TWO * UPPER_BOUND * UPPER_BOUND * UPPER_BOUND
                + MULTIPLIER_THREE * UPPER_BOUND * UPPER_BOUND + UPPER_BOUND) / DIVISOR_SIX;
        // Calculate answer using equations
        answer = equationOne - equationTwo;
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + answer);
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
    }
}