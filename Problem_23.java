
//龍ONE

import java.util.ArrayList;

public class Problem_23 {

    private static ArrayList<Integer> abundantNumbers = new ArrayList<Integer>();
    private static boolean[] sumOfAbundantNumbers = new boolean[28124];

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int sum = 0;
        int answer = 0;
        // Find abundant numbers
        for (int number = 2; number < 28123; number++) {
            findAbundantNumbers(number);
        }
        // Make all sum of abundant numbers "true" in the boolean array
        for (int element = 0; element < abundantNumbers.size() - 1; element++) {
            for (int index = element; index < abundantNumbers.size(); index++) {
                sum = abundantNumbers.get(element) + abundantNumbers.get(index);
                if (sum <= 28123) {
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
        System.out.println(answer);
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
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