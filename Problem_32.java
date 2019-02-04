
//龍ONE

import java.lang.StringBuilder;
import java.util.ArrayList;

public class Problem_32 {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int answer = calculateProduct(1, 99, 100, 9999);
        System.out.println(
                "The sum of all products that can be written as pandigital using multiplication is: " + answer);
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
    }

    private static int calculateProduct(int multiplicandMin, int multiplicandMax, int multiplierMin,
            int multiplierMax) {
        ArrayList<Integer> productsArray = new ArrayList<Integer>();
        String[] digits = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
        StringBuilder digitCollection = new StringBuilder("");
        boolean panDigital = true;
        int sumOfProducts = 0;
        for (int firstNum = multiplicandMin; firstNum <= multiplicandMax; firstNum++) {
            for (int secondNum = multiplierMin; secondNum <= multiplierMax; secondNum++) {
                if (firstNum * secondNum >= 10000) { // product has to be 4 digits long
                    continue;
                }
                digitCollection.append(firstNum);
                digitCollection.append(secondNum);
                digitCollection.append(firstNum * secondNum);
                for (int index = 0; index < digits.length; index++) {
                    if (digitCollection.toString().contains(digits[index]) == false) {
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