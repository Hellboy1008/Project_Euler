
/**
 * Created by: 龍ONE 
 * Date Created: Jan 19, 2018
 * Date Edited: July 2, 2020
 * Purpose: Solution to Project Euler Problem 9
 */

/**
 * This class contains a method that calculates the product of the pythagorean
 * triplet with the sum 1000. The main method executes the program.
 */
public class Problem_09 {

    // divisor for halving
    private static final int DIVISOR_HALF = 2;
    // smallest prime number
    private static final int SMALLEST_PRIME = 2;
    // sum of the triplets
    private static final int SUM_OF_TRIPLETS = 1000;

    // conversion from nanoseconds to seconds
    private static final long TIME_CONVERSION = 1000000000;

    // answer prompt
    private static final String ANSWER = "The product of abc is: ";
    // time take to solve the problem
    private static final String TIME_TAKEN = "Time Taken:%s seconds";

    /**
     * The main method executes the solution and prints it alongside the time taken
     * to solve the program.
     * 
     * @param args The arguments given to the main method
     * @return None
     */
    public static void main(String[] args) {
        // solution for the problem
        int solution;
        // end time of the program
        long endTime;
        // start time of the program
        long startTime;

        startTime = System.nanoTime();
        solution = findProductOfTriplets(SUM_OF_TRIPLETS);
        endTime = System.nanoTime();

        // print answer and time taken
        System.out.println(ANSWER + solution);
        System.out.printf(TIME_TAKEN, (double) (endTime - startTime) / TIME_CONVERSION);
    }

    /**
     * This method finds the product of the triplets with a given sum using Euclid's
     * Pythagorean Triplets theorem.
     * 
     * @param sum The sum of the triplets
     * @return The product of the triplets
     */
    private static int findProductOfTriplets(int sum) {
        // holds whether the calculations are completed
        boolean completed = false;

        // product of the triplets
        int product = 0;
        // half of the sum
        int sumHalved = sum / DIVISOR_HALF;
        // variable "k" used in calculations
        int varK = 0;

        // Calculate answer using Euclid's Pythagorean Triplets
        for (int varM = SMALLEST_PRIME; varM < Math.sqrt(sumHalved) + 1; varM++) {
            if (sumHalved % varM == 0) {
                if (varM % SMALLEST_PRIME == 0) {
                    varK = varM + 1;
                } else {
                    varK = varM + SMALLEST_PRIME;
                }
                while (varK < SMALLEST_PRIME * varM && varK <= sumHalved * varM) {
                    if (sumHalved * varM % varK == 0 && gcd(varK, varM) == 1) {
                        product = (sum - (sumHalved * varK) / varM) * (sum - (sum * varM) / varK)
                                * (-1 * sum + (sumHalved * varK) / varM + (sum * varM) / varK);
                        completed = true;
                        break;
                    }
                    varK += SMALLEST_PRIME;
                }
            }
            if (completed == true) {
                break;
            }
        }

        return product;
    }

    /**
     * This method returns the greatest common divisor between two numbers.
     * 
     * @param numOne The first number
     * @param numTwo The second number
     * @return The greatest common divisor between the two numbers
     */
    private static int gcd(int numOne, int numTwo) {

        // base case for recursion
        if (numTwo == 0) {
            return numOne;
        }

        return gcd(numTwo, numOne % numTwo);
    }
}