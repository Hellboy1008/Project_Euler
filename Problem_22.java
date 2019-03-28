
//龍ONE

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Problem_22 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The total of all the name scores is: ";
    private static final File NAMES = new File("./Problem_22_Input.txt");
    private static final String COMMA = ",";
    private static final int ASCII_OF_A = 65;
    private static ArrayList<String> listOfNames = new ArrayList<String>();

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.nanoTime();
        int alphabeticalValue = 0;
        int answer = 0;
        sortFile();
        // Calculate total sum
        for (int element = 0; element < listOfNames.size(); element++) {
            alphabeticalValue = 0;
            for (int index = 1; index < listOfNames.get(element).length() - 1; index++) {
                alphabeticalValue += (listOfNames.get(element).charAt(index) - (ASCII_OF_A - 1)) * (element + 1);
            }
            answer += alphabeticalValue;
        }
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + answer);
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
    }

    // Sort file using ArrayList and Collections
    private static void sortFile() throws FileNotFoundException {
        Scanner scan = new Scanner(NAMES);
        scan.useDelimiter(COMMA);
        // Enter each name into the ArrayList
        while (scan.hasNext()) {
            listOfNames.add(scan.next());
        }
        scan.close();
        // Sort ArrayList
        Collections.sort(listOfNames);
    }

}