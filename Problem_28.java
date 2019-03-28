
//龍ONE

import java.util.ArrayList;

public class Problem_28 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The sum of the diagonal is ";
    private static final int SPIRAL_SIZE = 1001;
    private static final int SMALLEST_SQUARE = 3;
    private static final int SIZE_INCREMENT = 2;
    private static final int MULTIPLIER_FOUR = 4;

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int answer = calculateDiagonalSum(SPIRAL_SIZE);
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + answer);
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
    }

    private static int calculateDiagonalSum(int size) {
        int lengthOfDiagonal = 1; // 1x1 matrix has length 1
        for (int counter = SMALLEST_SQUARE; counter <= size; counter += SIZE_INCREMENT) {
            lengthOfDiagonal++;
        }
        int diagonalSum = 1; // account for the one in the middle
        ArrayList<Integer> holder = new ArrayList<Integer>();
        for (int counter = 1; counter <= lengthOfDiagonal - 1; counter++) {
            // value of upper left diagonal
            holder.add(MULTIPLIER_FOUR * counter * counter + SIZE_INCREMENT * counter + 1);
            // value of lower left diagonal
            holder.add(MULTIPLIER_FOUR * counter * counter + 1);
            // value of upper right diagonal
            holder.add(MULTIPLIER_FOUR * counter * counter + MULTIPLIER_FOUR * counter + 1);
            // value of lower right diagonal
            holder.add(MULTIPLIER_FOUR * counter * counter - SIZE_INCREMENT * counter + 1);
        }
        // sum all values
        for (int index = 0; index < holder.size(); index++) {
            diagonalSum += holder.get(index);
        }
        return diagonalSum;
    }

}