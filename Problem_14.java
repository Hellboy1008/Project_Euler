
//龍ONE

public class Problem_14 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The longest chain is produced by: ";
    private static final int LOWER_BOUND = 10;
    private static final int UPPER_BOUND = 1000000;
    private static final int CHECK_EVEN = 2;
    private static final int MULTIPLIER_THREE = 3;

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        long maximum_length = 0;
        long length = 0;
        long answer = 0;
        // Iterate through all numbers from 1 to 1 million
        for (long counter = LOWER_BOUND; counter < UPPER_BOUND; counter++) {
            length = 0;
            long number = counter;
            while (number != 1) {
                if (number % CHECK_EVEN == 0) {
                    number /= CHECK_EVEN;
                    length++;
                } else {
                    number = MULTIPLIER_THREE * number + 1;
                    length++;
                }
            }
            if (length > maximum_length) {
                maximum_length = length;
                answer = counter;
            }
        }
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + answer);
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
    }
}