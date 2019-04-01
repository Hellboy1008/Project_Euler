
//龍ONE

public class Problem_45 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The second triangular number that is also pentagonal and hexagonal is: ";
    private static final int LOWER_BOUND = 287;
    private static final int UPPER_BOUND = 60000; // guess and check upper bound
    private static final int DIVISOR_TWO = 2;
    private static final int DIVISOR_SIX = 6;
    private static final int MULTIPLIER_TWENTY_FOUR = 24;

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        long answer = findSpecialTriangular(LOWER_BOUND, UPPER_BOUND);
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + answer);
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
    }

    private static long findSpecialTriangular(int start, int end) {
        long triangularNum;
        double pentagonalNval;
        // loop through triangular numbers from start to end
        for (long count = start; count < end; count += DIVISOR_TWO) {
            triangularNum = (count * (count + 1)) / DIVISOR_TWO;
            pentagonalNval = (Math.sqrt(MULTIPLIER_TWENTY_FOUR * triangularNum + 1) + 1) / DIVISOR_SIX;
            if (pentagonalNval == (long) pentagonalNval) {
                return triangularNum;
            }
        }
        return 0;
    }
}