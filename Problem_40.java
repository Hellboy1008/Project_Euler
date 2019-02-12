
//龍ONE

public class Problem_40 {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int[] digitPart = { 1, 10, 100, 1000, 10000, 100000, 1000000 };
        int answer = findProduct(digitPart);
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println("The value of the expression is: " + answer);
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
    }

    private static int findProduct(int[] digits) {
        int currentDigit = 0;
        int index = 0;
        int product = 1;
        for (int count = 1; count < 1000000; count++) {
            // add to digit count accordingly
            if (count < 10) {
                currentDigit++;
            } else if (count >= 10 && count < 100) {
                currentDigit += 2;
            } else if (count >= 100 && count < 1000) {
                currentDigit += 3;
            } else if (count >= 1000 && count < 10000) {
                currentDigit += 4;
            } else if (count >= 10000 && count < 100000) {
                currentDigit += 5;
            } else if (count >= 100000 && count < 1000000) {
                currentDigit += 6;
            }
            if (currentDigit > digits[index]) {
                int difference = currentDigit - digits[index];
                int temp = count;
                for (int counter = 0; counter < difference; counter++) {
                    temp /= 10;
                }
                product *= temp % 10;
                index++;
            } else if (currentDigit == digits[index]) {
                int temp = count;
                while (temp > 10) {
                    temp /= 10;
                }
                product *= temp;
                index++;
            }
            if (index == digits.length) {
                break;
            }
        }
        return product;
    }
}