
//龍ONE

public class Problem_47 {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int answer = findConsecutiveNums();
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println("The first number of the 4 consecutive integers is: " + answer);
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
    }

    private static int findConsecutiveNums() {
        return 0;
    }

}