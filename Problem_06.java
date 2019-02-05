
//龍ONE

public class Problem_06 {
    public static void main(String[] args) {

        long startTime = System.nanoTime();
        int answer = 0;
        int number = 100;
        // Calculate answer using equations
        answer = (number * number * number * number + 2 * number * number * number + number * number) / 4
                - (2 * number * number * number + 3 * number * number + number) / 6;
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println("The difference is: " + answer);
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
    }
}