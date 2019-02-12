
//龍ONE

import java.util.ArrayList;

public class Problem_39 {

    private static ArrayList<Integer> perimeterSum = new ArrayList<Integer>();

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int answer = findMaxPythagoreanSolutions(1000);
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println("The number of solutions is maximized for: " + answer);
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
    }

    private static int findMaxPythagoreanSolutions(int limit) {
        // add all possible pythagorean sums (countOne = n, countTwo = m, countThree =
        // k)
        for (int countOne = 1; countOne < 15; countOne++) {
            for (int countTwo = countOne; countTwo < Math.sqrt(limit / 2); countTwo++) {
                // the two numbers can't be equal and both even -> m > n > 0
                if (countOne == countTwo || (countOne % 2 == 0 && countTwo % 2 == 0)) {
                    continue;
                }
                for (int countThree = 1; countThree < 41; countThree++) {
                    // a = d(m^2-n^2), b = 2*d*m*n, c = d(m^2+n^2)
                    int a = countThree * (countTwo * countTwo - countOne * countOne);
                    int b = 2 * countThree * countTwo * countOne;
                    int c = countThree * (countTwo * countTwo + countOne * countOne);
                    if (a + b + c <= limit) {
                        perimeterSum.add(a + b + c);
                    }
                }
            }
        }
        // find the most common solution
        int maxOccurance = 0;
        int mostCommon = 0;
        for (int indexOne = 0; indexOne < perimeterSum.size(); indexOne++) {
            int occurance = 0;
            for (int indexTwo = indexOne; indexTwo < perimeterSum.size(); indexTwo++) {
                if (indexOne != indexTwo
                        && perimeterSum.get(indexOne).intValue() == perimeterSum.get(indexTwo).intValue()) {
                    occurance++;
                }
            }
            if (occurance > maxOccurance) {
                mostCommon = perimeterSum.get(indexOne);
                maxOccurance = occurance;
            }
        }
        return mostCommon;
    }

}