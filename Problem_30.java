
//龍ONE

public class Problem_30 {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int answer = sumDigitPowers(354294);
        System.out.println(
                "The sum of numbers that can be written as the sum of the fifth powers of the digits is: " + answer);
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
    }

    private static int sumDigitPowers(int maxValue) {
        int specialNumbers = 0;
        int sumOfPowers = 0;
        for (int num = 2; num < maxValue; num++) {
            int temp = num;
            while (temp != 0) {
                sumOfPowers += Math.pow(temp % 10, 5);
                temp /= 10;
            }
            if (sumOfPowers == num) {
                specialNumbers += num;
            }
            sumOfPowers = 0;
        }
        return specialNumbers;
    }

}