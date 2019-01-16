
//龍ONE

public class Problem_1 {
    public static void main(String[] args) {

        long startTime = System.nanoTime();
        // Add sum of multiples of 3 and/or 5 under 1000
        int totalSum = 0;
        int sum_of_three = 3 * (333 * (333 + 1)) / 2;
        int sum_of_five = 5 * (199 * (199 + 1)) / 2;
        int sum_of_fifteen = 15 * (66 * (66 + 1)) / 2;
        totalSum = sum_of_three + sum_of_five - sum_of_fifteen;
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(totalSum);
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
    }
}