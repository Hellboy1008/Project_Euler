
//龍ONE

public class Problem_39 {

    private static int[] perimeterOccurance = new int[1000 + 1];

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
                for (int countThree = 1; countThree < 83; countThree++) {
                    // a = d(m^2-n^2), b = 2*d*m*n, c = d(m^2+n^2)
                    int a = countThree * (countTwo * countTwo - countOne * countOne);
                    int b = 2 * countThree * countTwo * countOne;
                    int c = countThree * (countTwo * countTwo + countOne * countOne);
                    if (a + b + c <= limit) {
                        perimeterOccurance[a + b + c] += 1;
                    }
                }
            }
        }
        // find the most common solution
        int maxOccurance = 0;
        int mostCommon = 0;
        for (int index = 0; index < perimeterOccurance.length; index++) {
            if (perimeterOccurance[index] > maxOccurance) {
                maxOccurance = perimeterOccurance[index];
                mostCommon = index;
            }
        }
        return mostCommon;
    }

}