
//龍ONE

public class Problem_15 {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        double answer = factorial(40) / (factorial(20) * factorial(20));
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println("The total number of routes is: " + answer);
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
    }

    private static double factorial(double value) {
        if (value == 1) {
            return 1;
        } else {
            return value * factorial(value - 1);
        }
    }
}