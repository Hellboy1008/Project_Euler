
//龍ONE

public class Problem_17 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The total number of letter used is: ";
    private static final int ONE_TO_NINE_SUM = 36;
    private static final int TEN_TO_NINETEEN_SUM = 70;
    private static final int TWENTY_TO_NINETY_SUM = 46;
    private static final int ONE_TO_NINETY_NINE_SUM = ONE_TO_NINE_SUM + TEN_TO_NINETEEN_SUM + TWENTY_TO_NINETY_SUM * 10
            + ONE_TO_NINE_SUM * 8;
    private static final int HUNDREDS_SUM = 7 * 9 + ONE_TO_NINE_SUM;
    private static final int HUNDREDS_AND_SUM = 10 * 99 * 9;
    private static final int NUMBERS_BEFORE_HUNDREDS_SUM = ONE_TO_NINE_SUM * 99;
    private static final int NUMBERS_AFTER_HUNDREDS_SUM = ONE_TO_NINETY_NINE_SUM * 9;
    private static final int ONE_THOUSAND_SUM = 11;

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int answer = ONE_TO_NINETY_NINE_SUM + HUNDREDS_SUM + HUNDREDS_AND_SUM + NUMBERS_BEFORE_HUNDREDS_SUM
                + NUMBERS_AFTER_HUNDREDS_SUM + ONE_THOUSAND_SUM;
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + answer);
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
    }

}