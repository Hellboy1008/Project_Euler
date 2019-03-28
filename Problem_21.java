
//龍ONE

import java.util.ArrayList;

public class Problem_21 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The sum of all the amicable numbers is:";
    private static final int LOWER_BOUND = 2;
    private static final int UPPER_BOUND = 10000;
    private static ArrayList<Integer> sumOfAllFactors = new ArrayList<Integer>();

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int answer = 0;
        // find sum of all factors
        for (int number = LOWER_BOUND; number <= UPPER_BOUND; number++) {
            calculateFactorSum(number);
        }
        // find amicable numbers
        answer = sumOfAmicableNumbers(sumOfAllFactors);
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + answer);
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
    }

    private static void calculateFactorSum(int input_number) {
        int factorSum = 0;
        for (int counter = 1; counter <= Math.sqrt(input_number); counter++) {
            if (input_number % counter == 0) {
                factorSum += counter;
                if (counter != 1 && counter != (input_number / counter)) {
                    factorSum += (input_number / counter);
                }
            }
        }
        sumOfAllFactors.add(factorSum);
    }

    private static int sumOfAmicableNumbers(ArrayList allFactorSums) {
        int totalSum = 0;
        for (int index = 0; index < allFactorSums.size(); index++) {
            int element = (int) (allFactorSums.get(index));
            if (element == 1 || element > UPPER_BOUND - 1 || element == index + LOWER_BOUND) {
                continue;
            } else if (index + LOWER_BOUND == (int) (allFactorSums.get(element - LOWER_BOUND))) {
                totalSum += (index + LOWER_BOUND);
            }
        }
        return totalSum;
    }

}