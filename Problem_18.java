
//龍ONE

public class Problem_18 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The maximum total from top to bottom is: ";
    private static final int[][] pyramid = { { 75 }, { 95, 64 }, { 17, 42, 82 }, { 18, 35, 87, 10 },
            { 20, 4, 82, 47, 65 }, { 19, 1, 23, 75, 3, 34 }, { 88, 2, 77, 73, 7, 63, 67 },
            { 99, 65, 4, 28, 6, 16, 70, 92 }, { 41, 41, 26, 56, 83, 40, 80, 70, 33 },
            { 41, 48, 72, 33, 47, 32, 37, 16, 94, 29 }, { 53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14 },
            { 70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57 }, { 91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48 },
            { 63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31 },
            { 4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23 } };
    private static final int SECOND_LAST_ROW = 2;

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int answer;
        for (int indexOne = pyramid.length - SECOND_LAST_ROW; indexOne > 0; indexOne--) {
            for (int indexTwo = 0; indexTwo < pyramid[indexOne].length; indexTwo++) {
                if (pyramid[indexOne][indexTwo] + pyramid[indexOne + 1][indexTwo] > pyramid[indexOne][indexTwo]
                        + pyramid[indexOne + 1][indexTwo + 1]) {
                    pyramid[indexOne][indexTwo] = pyramid[indexOne][indexTwo] + pyramid[indexOne + 1][indexTwo];
                } else {
                    pyramid[indexOne][indexTwo] = pyramid[indexOne][indexTwo] + pyramid[indexOne + 1][indexTwo + 1];
                }
            }
        }
        // calculate largest sum
        if (pyramid[1][0] > pyramid[1][1]) {
            answer = pyramid[0][0] + pyramid[1][0];
        } else {
            answer = pyramid[0][0] + pyramid[1][1];
        }
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + answer);
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
    }

}