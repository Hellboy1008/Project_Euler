
//龍ONE

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.StringBuilder;

public class Problem_42 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The number of triangular words in the text file is: ";
    private static final File INPUT = new File("./Problem_42_Input.txt");
    private static final int TRIANGLE_NUMBERS_MAX = 35;
    private static final int DIVISOR_TWO = 2;
    private static final int ASCII_INDEX_A = 65;
    private static final String COMMA = ",";
    private static final String DOUBLE_QUOTES = "\"";

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.nanoTime();
        int answer = triangularWords();
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + answer);
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
    }

    private static int triangularWords() throws FileNotFoundException {
        // initialise triangle numbers array (assume word is less than length 20)
        int[] triangleNumbers = new int[TRIANGLE_NUMBERS_MAX];
        for (int count = 0; count < triangleNumbers.length; count++) {
            triangleNumbers[count] = ((count + 1) * count) / DIVISOR_TWO;
        }
        int total = 0;
        Scanner scan = new Scanner(INPUT);
        scan.useDelimiter(COMMA);
        // Find triangular words
        while (scan.hasNext()) {
            StringBuilder word = new StringBuilder(scan.next().replaceAll(DOUBLE_QUOTES, ""));
            int characterSum = 0;
            // calculate the total character sum
            for (int index = 0; index < word.length(); index++) {
                characterSum += (int) word.charAt(index) - (ASCII_INDEX_A - 1);
            }
            // determine whether the character sum is a triangle number
            for (int index = 0; index < triangleNumbers.length; index++) {
                if (characterSum == triangleNumbers[index]) {
                    total++;
                }
            }
        }
        scan.close();
        return total;
    }

}