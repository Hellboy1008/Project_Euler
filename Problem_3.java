
//龍ONE

public class Problem_3{
    public static void main (String[] args){

        long startTime = System.nanoTime();
        long target_number = Long.parseLong("600851475143");
        // Use prime factorization to find largest prime factor
        for (int factor = 2; factor < Math.sqrt(target_number); factor++){
            if (checkPrime(factor) == true){
                if (target_number % factor == 0){
                    target_number = target_number / factor;
                }
            }
        }

        long finishTime = System.nanoTime();
        double timeTaken = (double)(finishTime - startTime);
        System.out.println(target_number);
        System.out.println("Time Taken:" + timeTaken/1000000000 + " seconds");
    }
    public static boolean checkPrime(long check_number){
        for (int counter = 2; counter <= Math.sqrt(check_number); counter++){
            if (check_number % counter == 0){
                return false;
            }
        }
        return true;
    }
}