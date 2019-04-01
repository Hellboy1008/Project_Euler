
//龍ONE

public class Problem_44 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The difference D is: ";
    private static final int UPPER_BOUND = 3000; // guess and check
    private static final int MULTIPLIER_THREE = 3;
    private static final int MULTIPLIER_TWENTY_FOUR = 24;
    private static final int DIVISOR_TWO = 2;
    private static final int DIVISOR_SIX = 6;

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int answer = findPentagonalPair(UPPER_BOUND);
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + answer);
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
    }

    private static int findPentagonalPair(int limit) {
        int pentagonalOne;
        int pentagonalTwo;
        int difference;
        int sum;
        double differenceNVal;
        double sumNVal;
        // loop through pentagonal numbers 1 through 3000
        for (int countOne = 1; countOne < limit; countOne++) {
            for (int countTwo = countOne + 1; countTwo < limit; countTwo++) {
                pentagonalOne = countOne * (MULTIPLIER_THREE * countOne - 1) / DIVISOR_TWO;
                pentagonalTwo = countTwo * (MULTIPLIER_THREE * countTwo - 1) / DIVISOR_TWO;
                difference = pentagonalTwo - pentagonalOne;
                sum = pentagonalOne + pentagonalTwo;
                differenceNVal = (Math.sqrt(MULTIPLIER_TWENTY_FOUR * difference + 1) + 1) / DIVISOR_SIX;
                sumNVal = (Math.sqrt(MULTIPLIER_TWENTY_FOUR * sum + 1) + 1) / DIVISOR_SIX;
                // check if the difference and sum are pentagonal numbers
                if (differenceNVal == (int) differenceNVal && sumNVal == (int) sumNVal) {
                    return difference;
                }
            }
        }
        return 0;
    }
}