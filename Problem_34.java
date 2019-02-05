
//龍ONE

public class Problem_34 {

    private static int[] factorialValue = { 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880 };

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int answer = findCuriousNumbersSum();
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println("The sum of all curious numbers is: " + answer);
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
    }

    private static int findCuriousNumbersSum() {
        int curiousNumberSum = 0;
        int factorialSum = 0;
        // find all curious numbers (ignore 1 and 2)
        for (int counter = 3; counter < 2540160; counter++) {
            int num = counter;
            if (factorialValue[num % 10] > counter) {
                continue;
            }
            while (num != 0) {
                if (factorialValue[num % 10] > counter) {
                    break;
                }
                factorialSum += factorialValue[num % 10];
                num /= 10;
            }
            if (factorialSum == counter) {
                curiousNumberSum += counter;
            }
            factorialSum = 0;
        }
        return curiousNumberSum;
    }

}