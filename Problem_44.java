
//龍ONE

public class Problem_44 {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int answer = findPentagonalPair(3000); // guess and check
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println("The difference D is: " + answer);
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
    }

    private static int findPentagonalPair(int limit) {
        int pentagonalOne;
        int pentagonalTwo;
        int difference;
        int sum;
        double differenceNVal;
        double sumNVal;
        // loop through pentagonal numbers 1 through 3000
        for (int countOne = 1; countOne < limit; countOne++) {
            for (int countTwo = countOne + 1; countTwo < limit; countTwo++) {
                pentagonalOne = countOne * (3 * countOne - 1) / 2;
                pentagonalTwo = countTwo * (3 * countTwo - 1) / 2;
                difference = pentagonalTwo - pentagonalOne;
                sum = pentagonalOne + pentagonalTwo;
                differenceNVal = (Math.sqrt(24 * difference + 1) + 1) / 6;
                sumNVal = (Math.sqrt(24 * sum + 1) + 1) / 6;
                // check if the difference and sum are pentagonal numbers
                if (differenceNVal == (int) differenceNVal && sumNVal == (int) sumNVal) {
                    return difference;
                }
            }
        }
        return 0;
    }
}