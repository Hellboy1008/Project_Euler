
//龍ONE

import java.lang.StringBuilder;
import java.util.ArrayList;

public class Problem_32 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The sum of all products that can be written as pandigital"
            + " using multiplication is: ";
    private static final int MULTIPLICAND_MAX = 99;
    private static final int MULTIPLIER_MIN = 100;
    private static final int MULTIPLIER_MAX = 9999;
    private static final int PRODUCT_MAX = 10000;
    private static final String[] DIGITS = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int answer = calculateProduct(1, MULTIPLICAND_MAX, MULTIPLIER_MIN, MULTIPLIER_MAX);
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + answer);
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
    }

    private static int calculateProduct(int multiplicandMin, int multiplicandMax, int multiplierMin,
            int multiplierMax) {
        ArrayList<Integer> productsArray = new ArrayList<Integer>();
        StringBuilder digitCollection = new StringBuilder("");
        boolean panDigital = true;
        int sumOfProducts = 0;
        for (int firstNum = multiplicandMin; firstNum <= multiplicandMax; firstNum++) {
            for (int secondNum = multiplierMin; secondNum <= multiplierMax; secondNum++) {
                if (firstNum * secondNum >= PRODUCT_MAX) { // product has to be 4 digits long
                    continue;
                }
                digitCollection.append(firstNum);
                digitCollection.append(secondNum);
                digitCollection.append(firstNum * secondNum);
                for (int index = 0; index < DIGITS.length; index++) {
                    if (digitCollection.toString().contains(DIGITS[index]) == false) {
                        panDigital = false;
                        break;
                    }
                }
                if (panDigital == true && productsArray.contains(firstNum * secondNum) == false) {
                    productsArray.add(firstNum * secondNum);
                } else {
                    panDigital = true;
                }
                // reset the stringbuilder
                digitCollection.delete(0, digitCollection.toString().length());
            }
        }
        // sum all products
        for (int index = 0; index < productsArray.size(); index++) {
            sumOfProducts += productsArray.get(index);
        }
        return sumOfProducts;
    }

}