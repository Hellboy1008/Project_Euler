
//龍ONE

public class Problem_09 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The product of abc is: ";
    private static final int SUM = 1000;
    private static final int SUM_HALVED = SUM / 2;
    private static final int SMALLEST_FACTOR = 2;

    public static void main(String[] args) {

        long startTime = System.nanoTime();
        int m = 0;
        int k = 0;
        int product = 0;
        boolean completed = false;
        // Calculate answer using Euclid's Pythagorean Triplets
        for (m = SMALLEST_FACTOR; m < (int) Math.sqrt(SUM_HALVED) + 1; m++) {
            if (SUM_HALVED % m == 0) {
                if (m % SMALLEST_FACTOR == 0) {
                    k = m + 1;
                } else {
                    k = m + SMALLEST_FACTOR;
                }
                while (k < SMALLEST_FACTOR * m && k <= SUM_HALVED * m) {
                    if (SUM_HALVED * m % k == 0 && gcd(k, m) == 1) {
                        product = (SUM_HALVED * (SMALLEST_FACTOR * m - k) / m) * (SUM * (k - m) / k)
                                * (SUM_HALVED * (k * k - SMALLEST_FACTOR * k * m + SMALLEST_FACTOR * m * m) / (m * k));
                        completed = true;
                        break;
                    }
                    k += SMALLEST_FACTOR;
                }
            }
            if (completed == true) {
                break;
            }
        }
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + product);
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}