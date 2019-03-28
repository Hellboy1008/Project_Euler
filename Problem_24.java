
//龍ONE

import java.util.ArrayList;
import java.lang.StringBuilder;

public class Problem_24 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The millionth lexicographic permutation is: ";
    private static final int TOTAL_DIGITS = 10;
    private static final int TARGET = 1000000;
    private static ArrayList<Integer> numbers = new ArrayList<Integer>();
    private static int[] factorialArray = new int[10];
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        // Initialise numbers ArrayList
        for (int index = 0; index < TOTAL_DIGITS; index++) {
            numbers.add(index);
        }
        // Initialise factorial array
        for (int index = 0; index < factorialArray.length; index++) {
            factorialArray[index] = factorial(index);
        }
        solvePermutation();
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + answer.toString());
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
    }

    private static void solvePermutation() {
        int limit = TARGET;
        int determinedNumbers = 1;
        while (limit != 0) {
            for (int counter = 1; counter < TOTAL_DIGITS; counter++) {
                if (limit - factorialArray[factorialArray.length - determinedNumbers] * counter > 0) {
                } else {
                    limit -= factorialArray[factorialArray.length - determinedNumbers] * (counter - 1);
                    determinedNumbers++;
                    answer.append(numbers.get(counter - 1));
                    numbers.remove(counter - 1);
                    break;
                }
            }
            // check if the sequencing is complete
            if (numbers.size() == 1) {
                answer.append(numbers.get(0));
                limit = 0;
            }
        }
    }

    private static int factorial(int num) {
        int factorialSum = num;
        for (int counter = num - 1; counter > 0; counter--) {
            factorialSum *= counter;
        }
        return factorialSum;
    }

}