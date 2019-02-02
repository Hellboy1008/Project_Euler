
//龍ONE

public class Problem_31 {

    private static int limit = 200;
    private static int[] coins = { 1, 2, 5, 10, 20, 50, 100, 200 };
    private static int[][] array = new int[limit + 1][coins.length];

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        createArray();
        int answer = array[array.length - 1][array[0].length - 1];
        System.out.println("The total number of ways is: " + answer);
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
    }

    private static void createArray() {
        // the first column should all be 1s
        for (int row_index = 0; row_index < array.length; row_index++) {
            array[row_index][0] = 1;
        }
        // calcuate the rest of the values
        for (int row_index = 0; row_index < array.length; row_index++) {
            for (int column_index = 1; column_index < array[row_index].length; column_index++) {
                if (row_index >= coins[column_index]) {
                    array[row_index][column_index] += array[row_index][column_index - 1];
                    array[row_index][column_index] += array[row_index - coins[column_index]][column_index];
                } else {
                    array[row_index][column_index] = array[row_index][column_index - 1];
                }
            }
        }
    }

}