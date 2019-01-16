
//龍ONE

public class Problem_5 {
    public static void main(String[] args) {

        long startTime = System.nanoTime();
        int smallestMultiple = 116280; // 20*19*18*17 = 116280
        // Calculate smallest multiple
        boolean found = false;
        while (found == false) {
            smallestMultiple = smallestMultiple + 116280;
            if (smallestMultiple % 16 == 0 && smallestMultiple % 14 == 0 && smallestMultiple % 13 == 0
                    && smallestMultiple % 11 == 0) {
                found = true;
            }
        }
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(smallestMultiple);
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
    }
}