
//龍ONE

public class Problem_12 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The first triangle number to have over 500 divisors is: ";
    private static final int HALF = 2;
    private static final int TARGET_FACTORS = 500;

    public static void main(String[] args) {

        long startTime = System.nanoTime();
        int answer = 0;
        boolean found = false;
        int index = 1;
        // Find triangle number
        while (found == false) {
            int triangle_number = index * (index + 1) / HALF;
            if (countFactors(triangle_number) >= TARGET_FACTORS) {
                found = true;
                answer = triangle_number;
            }
            index++;
        }
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + answer);
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
    }

    private static int countFactors(int number) {
        int factors = 0;
        for (int counter = 1; counter <= Math.sqrt(number); counter++) {
            if (Math.sqrt(number) <= TARGET_FACTORS / HALF) {
                break;
            }
            if (number % counter == 0) {
                factors++;
            }
        }
        return factors + factors;
    }
}