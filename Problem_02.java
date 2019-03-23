
//龍ONE

public class Problem_02 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The sum of even fibonacci numbers under 4 million is: ";
    private static final int SUM_OF_FIRST_THREE_FIBONACCI = 2;
    private static final int EVEN_FIBONACCI_MULTIPLIER = 4;
    private static final int UPPER_BOUND = 4000000;

    public static void main(String[] args) {

        long startTime = System.nanoTime();
        // Declare variables used for calculations (assume 2 is already part of sum)
        int previous_fibonacci_number = 0;
        int even_fibonacci_number = SUM_OF_FIRST_THREE_FIBONACCI;
        int calculated_fibonacci = 0;
        int totalSum = SUM_OF_FIRST_THREE_FIBONACCI;
        boolean endLoop = false;
        // Calculate the sum of the even fibonacci numbers
        while (endLoop == false) {
            calculated_fibonacci = EVEN_FIBONACCI_MULTIPLIER * even_fibonacci_number + previous_fibonacci_number;
            if (calculated_fibonacci < UPPER_BOUND) {
                totalSum += calculated_fibonacci;
                previous_fibonacci_number = even_fibonacci_number;
                even_fibonacci_number = calculated_fibonacci;
            } else {
                endLoop = true;
            }
        }
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + totalSum);
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
    }
}