
//龍ONE

public class Problem_02 {
    public static void main(String[] args) {

        long startTime = System.nanoTime();
        // Declare variables used for calculations (assume 2 is already part of sum)
        int previous_fibonacci_number = 0;
        int even_fibonacci_number = 2;
        int calculated_fibonacci = 0;
        int totalSum = 2;
        boolean endLoop = false;
        // Calculate the sum of the even fibonacci numbers
        while (endLoop == false) {
            calculated_fibonacci = 4 * even_fibonacci_number + previous_fibonacci_number;
            if (calculated_fibonacci < 4000000) {
                totalSum += calculated_fibonacci;
                previous_fibonacci_number = even_fibonacci_number;
                even_fibonacci_number = calculated_fibonacci;
            } else {
                endLoop = true;
            }
        }
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println("The sum of even fibonacci numbers under 4 million is: " + totalSum);
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
    }
}