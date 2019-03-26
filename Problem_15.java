
//龍ONE

public class Problem_15 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The total number of routes is: ";
    private static final int GRID_SIZE = 20;

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        double answer = factorial(GRID_SIZE + GRID_SIZE) / (factorial(GRID_SIZE) * factorial(GRID_SIZE));
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + answer);
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
    }

    private static double factorial(double value) {
        if (value == 1) {
            return 1;
        } else {
            return value * factorial(value - 1);
        }
    }
}