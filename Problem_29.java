
//龍ONE

import java.util.ArrayList;

public class Problem_29 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The number of distinct terms are: ";
    private static final int LOWEST_BASE = 2;
    private static final int HIGHEST_POWER = 100;
    private static ArrayList<Double> values = new ArrayList<Double>();

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        addTerms(LOWEST_BASE, HIGHEST_POWER, LOWEST_BASE, HIGHEST_POWER);
        int answer = values.size();
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + answer);
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
    }

    private static void addTerms(int aMinValue, int aMaxValue, int bMinValue, int bMaxValue) {
        // add all terms
        for (int aValue = aMinValue; aValue <= aMaxValue; aValue++) {
            for (int bValue = bMinValue; bValue <= bMaxValue; bValue++) {
                double num = Math.pow(aValue, bValue);
                if (values.contains(num) == false) {
                    values.add(num);
                }
            }
        }
    }

}