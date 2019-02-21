
//龍ONE

public class Problem_44 {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int answer = findPentagonalPair();
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println("The difference D is: " + answer);
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
    }

    private static int findPentagonalPair() {
        int pentagonalOne;
        int pentagonalTwo;
        int difference;
        int sum;
        double differenceNVal;
        double sumNVal;
        for (int countOne = 1; countOne < 3000; countOne++) {
            for (int countTwo = countOne + 1; countTwo < 3000; countTwo++) {
                pentagonalOne = countOne * (3 * countOne - 1) / 2;
                pentagonalTwo = countTwo * (3 * countTwo - 1) / 2;
                difference = pentagonalTwo - pentagonalOne;
                sum = pentagonalOne + pentagonalTwo;
                differenceNVal = (Math.sqrt(24 * difference + 1) + 1) / 6;
                sumNVal = (Math.sqrt(24 * sum + 1) + 1) / 6;
                if (differenceNVal == (int) differenceNVal && sumNVal == (int) sumNVal) {
                   return difference;
                }
            }
        }
        return 0;
    }

}