
//龍ONE

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Problem_22 {

    private static File names = new File("./Problem_22_Input.txt");
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
                alphabeticalValue += (listOfNames.get(element).charAt(index) - 64) * (element + 1);
            }
            answer += alphabeticalValue;
        }
        System.out.println("The total of all the name scores is: " + answer);
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
    }

    // Sort file using ArrayList and Collections
    private static void sortFile() throws FileNotFoundException {
        Scanner scan = new Scanner(names);
        scan.useDelimiter(",");
        // Enter each name into the ArrayList
        while (scan.hasNext()) {
            listOfNames.add(scan.next());
        }
        scan.close();
        // Sort ArrayList
        Collections.sort(listOfNames);
    }

}