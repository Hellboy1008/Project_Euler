
//龍ONE

import java.util.ArrayList;

public class Problem_21 {

    private static ArrayList<Integer> sumOfAllFactors = new ArrayList<Integer>();

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int answer = 0;
        // find sum of primes
        for (int number = 2; number <= 10000; number++) {
            calculateFactorSum(number);
        }
        // find amicable numbers
        answer = sumOfAmicableNumbers(sumOfAllFactors);
        System.out.println("The sum of all the amicable numbers is:" + answer);
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
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
            if (element == 1 || element > 9999 || element == index + 2) {
                continue;
            } else if (index + 2 == (int) (allFactorSums.get(element - 2))) {
                totalSum += (index + 2);
            }
        }
        return totalSum;
    }

}