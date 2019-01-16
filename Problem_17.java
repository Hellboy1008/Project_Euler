
//龍ONE

public class Problem_17 {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int one_to_nine = 36;
        int ten_to_nineteen = 70;
        int twenty_to_ninety = 46;
        int one_to_ninety_nine = one_to_nine + ten_to_nineteen + twenty_to_ninety * 10 + one_to_nine * 8;
        int hundereds = 7 * 9 + one_to_nine;
        int hundered_and = 10 * 99 * 9;
        int numbers_before_hundred = one_to_nine * 99;
        int numbers_after_hundred = one_to_ninety_nine * 9;
        int one_thousand = 11;
        int answer = one_to_ninety_nine + hundereds + hundered_and + numbers_before_hundred + numbers_after_hundred
                + one_thousand;
        System.out.println(answer);
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
    }

}