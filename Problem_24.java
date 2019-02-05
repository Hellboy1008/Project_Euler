
//龍ONE

import java.util.ArrayList;
import java.lang.StringBuilder;

public class Problem_24 {

    private static ArrayList<Integer> numbers = new ArrayList<Integer>();
    private static int[] factorialArray = new int[10];
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        // Initialise numbers ArrayList
        for (int index = 0; index < 10; index++) {
            numbers.add(index);
        }
        // Initialise factorial array
        for (int index = 0; index < factorialArray.length; index++) {
            factorialArray[index] = factorial(index);
        }
        solvePermutation();
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println("The millionth lexicographic permutation is:" + answer.toString());
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
    }

    private static void solvePermutation() {
        int limit = 1000000;
        int determinedNumbers = 1;
        int x = 0;
        while (limit != 0) {
            for (int counter = 1; counter < 10; counter++) {
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