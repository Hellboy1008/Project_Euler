
//龍ONE

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.StringBuilder;

public class Problem_42 {

    private static File input = new File("./Problem_42_Input.txt");

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.nanoTime();
        int answer = triangularWords();
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println("The number of triangular words in the text file is: " + answer);
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
    }

    private static int triangularWords() throws FileNotFoundException {
        // initialise triangle numbers array (assume word is less than length 20)
        int[] triangleNumbers = new int[35];
        for (int count = 0; count < triangleNumbers.length; count++) {
            triangleNumbers[count] = ((count + 1) * count) / 2;
        }
        int total = 0;
        Scanner scan = new Scanner(input);
        scan.useDelimiter(",");
        // Find triangular words
        while (scan.hasNext()) {
            StringBuilder word = new StringBuilder(scan.next().replaceAll("\"", ""));
            int characterSum = 0;
            // calculate the total character sum
            for (int index = 0; index < word.length(); index++) {
                characterSum += (int) word.charAt(index) - 64;
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