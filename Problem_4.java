
//龍ONE

public class Problem_4{
    public static void main (String[] args){

        long startTime = System.nanoTime();        
        int largestPalindrome = 0;
        //assume outcome has to be the product of two numbers greater than 900
        for (int first_number = 900; first_number < 1000; first_number++){
            for (int second_number = 900; second_number < 1000; second_number++){
                int product = first_number * second_number;
                if (checkPalindrome(product) == true && product > largestPalindrome){
                    largestPalindrome = product;
                }
            }
        }

        long finishTime = System.nanoTime();
        double timeTaken = (double)(finishTime - startTime);
        System.out.println(largestPalindrome);
        System.out.println("Time Taken:" + timeTaken/1000000000 + " seconds");
    }

    public static boolean checkPalindrome (int product){
        int originalNumber = product;
        int reverse = 0;
        
        if (product <= 10 || product%10 == 0){
            return false;
        }
        while (product >= 1){
            reverse = reverse*10 + product%10;
            product = product/10;
        }
        if (originalNumber == reverse){
            return true;
        }
        return false;
    }
}