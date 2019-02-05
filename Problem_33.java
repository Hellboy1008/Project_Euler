
//龍ONE

import java.util.ArrayList;

public class Problem_33 {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int answer = findCuriosFractionDenominator();
        System.out.println("The value of the denominator is: " + answer);
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
    }

    private static int findCuriosFractionDenominator() {
        ArrayList<Integer> curiousFractionNumerator = new ArrayList<Integer>();
        ArrayList<Integer> curiousFractionDenominator = new ArrayList<Integer>();
        // find curious fractions
        for (double numerator = 10; numerator < 100; numerator++) {
            for (double denominator = numerator; denominator < 100; denominator++) {
                // ignore if numerator and denominator have the same value
                if (numerator == denominator) {
                    continue;
                }
                double division = numerator / denominator;
                double wrongDivision = (double) ((int) (numerator) / 10) / (double) ((int) (denominator) % 10);
                boolean cancellable = (int) (numerator) % 10 == (int) (denominator) / 10;
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
        int[] newFraction = new int[2];
        ArrayList<Integer> factors = new ArrayList<Integer>();
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