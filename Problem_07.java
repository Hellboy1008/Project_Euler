
//龍ONE

public class Problem_07 {
    public static void main(String[] args) {

        long startTime = System.nanoTime();
        int answer = 2;
        int counter = 0;
        // Calculate 100001th prime
        while (counter != 10000) {
            answer += 1;
            if (checkPrime(answer) == true) {
                counter += 1;
            }
        }
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println("The 10001th prime number is: " + answer);
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
    }

    private static boolean checkPrime(long check_number) {
        for (int counter = 2; counter <= Math.sqrt(check_number); counter++) {
            if (check_number % counter == 0) {
                return false;
            }
        }
        return true;
    }
}