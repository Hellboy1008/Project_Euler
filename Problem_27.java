
//龍ONE

import java.util.ArrayList;

public class Problem_27 {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int answer = productOfCoefficients(1000, 1000);
        System.out.println("The product of the coefficients is " + answer);
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
    }

    private static int productOfCoefficients(int max_value_one, int max_value_two) {
        ArrayList<Integer> b_values = new ArrayList<Integer>();
        int largestNumOfPrimes = 0;
        int largest_a_value = 0;
        int largest_b_value = 0;
        // values for b must be prime
        for (int counter = 2; counter <= max_value_two; counter++) {
            if (checkPrime(counter) == true) {
                b_values.add(counter);
            }
        }
        // calculate largest coefficients
        int n_value = 0;
        int numberOfPrimes = 0;
        for (int counter = -max_value_one; counter < max_value_one; counter++) {
            for (int index = 0; index < b_values.size(); index++) {
                while (checkPrime(Math.abs(n_value * n_value + counter * n_value + b_values.get(index))) == true) {
                    n_value++;
                    numberOfPrimes++;
                }
                n_value = 0;
                if (numberOfPrimes > largestNumOfPrimes) {
                    largestNumOfPrimes = numberOfPrimes;
                    largest_a_value = counter;
                    largest_b_value = b_values.get(index);
                }
                numberOfPrimes = 0;
            }
        }
        return largest_a_value * largest_b_value;
    }

    private static boolean checkPrime(int check_number) {
        for (int counter = 2; counter <= Math.sqrt(check_number); counter++) {
            if (check_number % counter == 0) {
                return false;
            }
        }
        return true;
    }

}