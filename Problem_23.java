
//龍ONE

import java.util.ArrayList;

public class Problem_23 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The sum of all non-abundant numbers is: ";
    private static final int LOWER_BOUND = 2;
    private static final int UPPER_BOUND = 28123;
    private static ArrayList<Integer> abundantNumbers = new ArrayList<Integer>();
    private static boolean[] sumOfAbundantNumbers = new boolean[28124];

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int sum = 0;
        int answer = 0;
        // Find abundant numbers
        for (int number = LOWER_BOUND; number < UPPER_BOUND; number++) {
            findAbundantNumbers(number);
        }
        // Make all sum of abundant numbers "true" in the boolean array
        for (int element = 0; element < abundantNumbers.size() - 1; element++) {
            for (int index = element; index < abundantNumbers.size(); index++) {
                sum = abundantNumbers.get(element) + abundantNumbers.get(index);
                if (sum <= UPPER_BOUND) {
                    sumOfAbundantNumbers[sum] = true;
                }
            }
        }
        // Sum all non-abundant numbers
        for (int index = 0; index < sumOfAbundantNumbers.length; index++) {
            if (sumOfAbundantNumbers[index] == false) {
                answer += index;
            }
        }
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + answer);
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
    }

    private static void findAbundantNumbers(int input_number) {
        int factorSum = 0;
        for (int counter = 1; counter <= Math.sqrt(input_number); counter++) {
            if (input_number % counter == 0) {
                factorSum += counter;
                if (counter != 1 && counter != (input_number / counter)) {
                    factorSum += (input_number / counter);
                }
            }
        }
        if (factorSum > input_number) {
            abundantNumbers.add(input_number);
        }
    }

}