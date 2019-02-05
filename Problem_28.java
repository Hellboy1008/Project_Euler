
//龍ONE

import java.util.ArrayList;

public class Problem_28 {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int answer = calculateDiagonalSum(1001);
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println("The sum of the diagonal is " + answer);
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
    }

    private static int calculateDiagonalSum(int size) {
        int lengthOfDiagonal = 1; // 1x1 matrix has length 1
        for (int counter = 3; counter <= size; counter += 2) {
            lengthOfDiagonal++;
        }
        int diagonalSum = 1; // account for the one in the middle
        ArrayList<Integer> holder = new ArrayList<Integer>();
        for (int counter = 1; counter <= lengthOfDiagonal - 1; counter++) {
            // value of upper left diagonal
            holder.add(4 * counter * counter + 2 * counter + 1);
            // value of lower left diagonal
            holder.add(4 * counter * counter + 1);
            // value of upper right diagonal
            holder.add(4 * counter * counter + 4 * counter + 1);
            // value of lower right diagonal
            holder.add(4 * counter * counter - 2 * counter + 1);
        }
        // sum all values
        for (int index = 0; index < holder.size(); index++) {
            diagonalSum += holder.get(index);
        }
        return diagonalSum;
    }

}