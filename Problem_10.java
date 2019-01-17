
//龍ONE

public class Problem_10 {

    public static void main(String[] args) {

        long startTime = System.nanoTime();
        long sum = 5; // count 2 and 3 beforehand
        // Check for primes and add to total sum
        for (long counter = 0; 6 * counter - 1 <= 2000000; counter++) {
            if (checkPrime(6 * counter - 1) == true) {
                sum += 6 * counter - 1;
            }
        }
        for (long counter = 0; 6 * counter + 1 <= 2000000; counter++) {
            if (checkPrime(6 * counter + 1) == true) {
                sum += 6 * counter + 1;
            }
        }
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(sum);
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
    }

    private static boolean checkPrime(long check_number) {
        for (int counter = 3; counter <= Math.sqrt(check_number); counter += 2) {
            if (check_number % 2 == 0) {
                return false;
            }
            if (check_number % counter == 0) {
                return false;
            }
        }
        return true;
    }
}