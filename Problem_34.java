
//龍ONE

public class Problem_34 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The sum of all curious numbers is: ";
    private static final int LOWER_BOUND = 3;
    private static final int UPPER_BOUND = 2540160;
    private static final int DIVISOR_TEN = 10;
    private static final int[] FACTORIAL_VALUES = { 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880 };

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int answer = findCuriousNumbersSum();
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + answer);
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
    }

    private static int findCuriousNumbersSum() {
        int curiousNumberSum = 0;
        int factorialSum = 0;
        // find all curious numbers (ignore 1 and 2)
        for (int counter = LOWER_BOUND; counter < UPPER_BOUND; counter++) {
            int num = counter;
            if (FACTORIAL_VALUES[num % DIVISOR_TEN] > counter) {
                continue;
            }
            while (num != 0) {
                if (FACTORIAL_VALUES[num % DIVISOR_TEN] > counter) {
                    break;
                }
                factorialSum += FACTORIAL_VALUES[num % DIVISOR_TEN];
                num /= DIVISOR_TEN;
            }
            if (factorialSum == counter) {
                curiousNumberSum += counter;
            }
            factorialSum = 0;
        }
        return curiousNumberSum;
    }

}