
//龍ONE

public class Problem_45 {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        long answer = findSpecialTriangular(287, 60000); // guess and check upper bound
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println("The second triangular number that is also pentagonal and hexagonal is: " + answer);
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
    }

    private static long findSpecialTriangular(int start, int end) {
        long triangularNum;
        double pentagonalNval;
        // loop through triangular numbers from start to end
        for (long count = start; count < end; count += 2) {
            triangularNum = (count * (count + 1)) / 2;
            pentagonalNval = (Math.sqrt(24 * triangularNum + 1) + 1) / 6;
            if (pentagonalNval == (long) pentagonalNval) {
                return triangularNum;
            }
        }
        return 0;
    }
}