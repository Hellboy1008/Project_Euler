
//龍ONE

import java.util.ArrayList;

public class Problem_33 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The value of the denominator is: ";
    private static final int SMALLEST_NUMERATOR = 10;
    private static final int LARGEST_NUMERATOR = 100;
    private static final int NUMBERS_IN_FRACTIONS = 2;

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int answer = findCuriosFractionDenominator();
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + answer);
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
    }

    private static int findCuriosFractionDenominator() {
        ArrayList<Integer> curiousFractionNumerator = new ArrayList<Integer>();
        ArrayList<Integer> curiousFractionDenominator = new ArrayList<Integer>();
        // find curious fractions
        for (double numerator = SMALLEST_NUMERATOR; numerator < LARGEST_NUMERATOR; numerator++) {
            for (double denominator = numerator; denominator < LARGEST_NUMERATOR; denominator++) {
                // ignore if numerator and denominator have the same value
                if (numerator == denominator) {
                    continue;
                }
                double division = numerator / denominator;
                double wrongDivision = (double) ((int) (numerator) / SMALLEST_NUMERATOR)
                        / (double) ((int) (denominator) % SMALLEST_NUMERATOR);
                boolean cancellable = (int) (numerator) % SMALLEST_NUMERATOR == (int) (denominator)
                        / SMALLEST_NUMERATOR;
                // determine whether a fraction is curious using these three values
                if (division == wrongDivision && cancellable == true) {
                    curiousFractionNumerator.add((int) numerator);
                    curiousFractionDenominator.add((int) denominator);
                }
            }
        }
        // find product of the 4 curious fractions
        int simplifiedDenominator = 0;
        int denominatorProduct = 1;
        int numeratorProduct = 1;
        for (int index = 0; index < curiousFractionNumerator.size(); index++) {
            numeratorProduct *= curiousFractionNumerator.get(index);
        }
        for (int index = 0; index < curiousFractionDenominator.size(); index++) {
            denominatorProduct *= curiousFractionDenominator.get(index);
        }
        // simply fraction using separate helper method
        simplifiedDenominator = simplyFraction(numeratorProduct, denominatorProduct)[1];
        return simplifiedDenominator;
    }

    private static int[] simplyFraction(int numerator, int denominator) {
        int[] newFraction = new int[NUMBERS_IN_FRACTIONS];
        // find all factors of numerator (excluding 1)
        for (int counter = 1; counter <= Math.sqrt(numerator); counter++) {
            int factor = numerator / counter;
            if (numerator % factor == 0 && denominator % factor == 0) {
                numerator /= factor;
                denominator /= factor;
            }
        }
        newFraction[0] = numerator;
        newFraction[1] = denominator;
        return newFraction;
    }

}