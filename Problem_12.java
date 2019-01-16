
//龍ONE

public class Problem_12 {
    public static void main(String[] args) {

        long startTime = System.nanoTime();
        int answer = 0;
        boolean found = false;
        int i = 1;
        // Find triangle number
        while (found == false) {
            int triangle_number = i * (i + 1) / 2;
            if (countFactors(triangle_number) >= 500) {
                found = true;
                answer = triangle_number;
            }
            i++;
        }
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(answer);
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
    }

    public static int countFactors(int number) {
        int factors = 0;
        for (int counter = 1; counter <= Math.sqrt(number); counter++) {
            if (Math.sqrt(number) <= 250) {
                break;
            }
            if (number % counter == 0) {
                factors++;
            }
        }
        return 2 * factors;
    }
}