
//龍ONE

public class Problem_04 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The largest palindrome made from the product of 2 three digits numbers is: ";
    private static final int LOWER_BOUND = 900;
    private static final int UPPER_BOUND = 1000;
    private static final int DIVISOR = 10;

    public static void main(String[] args) {

        long startTime = System.nanoTime();
        int largestPalindrome = 0;
        // assume outcome has to be the product of two numbers greater than 900
        for (int first_number = LOWER_BOUND; first_number < UPPER_BOUND; first_number++) {
            for (int second_number = LOWER_BOUND; second_number < UPPER_BOUND; second_number++) {
                int product = first_number * second_number;
                if (checkPalindrome(product) == true && product > largestPalindrome) {
                    largestPalindrome = product;
                }
            }
        }

        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + largestPalindrome);
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
    }

    private static boolean checkPalindrome(int product) {
        int originalNumber = product;
        int reverse = 0;

        if (product <= DIVISOR || product % DIVISOR == 0) {
            return false;
        }
        while (product >= 1) {
            reverse = reverse * DIVISOR + product % DIVISOR;
            product = product / DIVISOR;
        }
        if (originalNumber == reverse) {
            return true;
        }
        return false;
    }
}