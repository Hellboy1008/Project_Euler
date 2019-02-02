
//龍ONE

import java.util.ArrayList;

public class Problem_29 {

    private static ArrayList<Double> values = new ArrayList<Double>();

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        addTerms(2, 100, 2, 100);
        int answer = values.size();
        System.out.println("The number of distinct terms are: " + answer);
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
    }

    private static void addTerms(int aMinValue, int aMaxValue, int bMinValue, int bMaxValue) {
        // add all terms
        for (int aValue = aMinValue; aValue <= aMaxValue; aValue++) {
            for (int bValue = bMinValue; bValue <= bMaxValue; bValue++) {
                double num = Math.pow(aValue, bValue);
                if (values.contains(num) == false){
                    values.add(num);
                }
            }
        }
    }

}