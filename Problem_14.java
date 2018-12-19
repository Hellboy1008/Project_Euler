
//龍ONE

public class Problem_14{

    public static void main (String[] args){
        long startTime = System.nanoTime();
        long maximum_length = 0;
        long length = 0;
        long answer = 0;
        // Iterate through all numbers from 1 to 1 million
        for (long counter = 10; counter < 1000000; counter++){
            length = 0;
            long number = counter;
            while (number != 1){
                if (number % 2 == 0){
                    number /= 2;
                    length++;
                } else {
                    number = 3*number + 1;
                    length++;
                }
            }
            if (length > maximum_length){
                maximum_length = length;
                answer = counter;
            }
        }
        long finishTime = System.nanoTime();
        double timeTaken = (double)(finishTime - startTime);
        System.out.println(answer);
        System.out.println("Time Taken:" + timeTaken/1000000000 + " seconds");
    }
}