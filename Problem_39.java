
//龍ONE

public class Problem_39 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The number of solutions is maximized for: ";
    private static final int UPPER_BOUND = 1000;
    private static final int N_VALUE_MAX = 15;
    private static final int D_VALUE_MAX = 83;
    private static final int EVEN_CHECK = 2;
    private static int[] perimeterOccurance = new int[UPPER_BOUND + 1];

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int answer = findMaxPythagoreanSolutions(UPPER_BOUND);
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + answer);
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
    }

    private static int findMaxPythagoreanSolutions(int limit) {
        // add all possible pythagorean sums (countOne = n, countTwo = m, countThree =
        // k)
        for (int countOne = 1; countOne < N_VALUE_MAX; countOne++) {
            for (int countTwo = countOne; countTwo < Math.sqrt(limit / EVEN_CHECK); countTwo++) {
                // the two numbers can't be equal and both even -> m > n > 0
                if (countOne == countTwo || (countOne % EVEN_CHECK == 0 && countTwo % EVEN_CHECK == 0)) {
                    continue;
                }
                for (int countThree = 1; countThree < D_VALUE_MAX; countThree++) {
                    // a = d(m^2-n^2), b = 2*d*m*n, c = d(m^2+n^2)
                    int a = countThree * (countTwo * countTwo - countOne * countOne);
                    int b = EVEN_CHECK * countThree * countTwo * countOne;
                    int c = countThree * (countTwo * countTwo + countOne * countOne);
                    if (a + b + c <= limit) {
                        perimeterOccurance[a + b + c] += 1;
                    }
                }
            }
        }
        // find the most common solution
        int maxOccurance = 0;
        int mostCommon = 0;
        for (int index = 0; index < perimeterOccurance.length; index++) {
            if (perimeterOccurance[index] > maxOccurance) {
                maxOccurance = perimeterOccurance[index];
                mostCommon = index;
            }
        }
        return mostCommon;
    }

}