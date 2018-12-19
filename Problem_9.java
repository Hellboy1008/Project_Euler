
//龍ONE

public class Problem_9{
    public static void main (String[] args){

        long startTime = System.nanoTime();
        int m = 0;
        int k = 0;
        int product = 0;
        boolean completed = false;     
        // Calculate answer using Euclid's Pythagorean Triplets
        for (m = 2; m < 23; m++){
            if (500%m == 0){
                if (m%2 == 0){
                    k = m+1;
                } else {
                    k = m+2;
                }
                while (k < 2*m && k<= 500*m){
                    if (500*m % k == 0 && gcd(k,m) == 1){
                        product = ( 500*(2*m-k) / m) * ( 1000*(k-m) / k ) * ( 500*(k*k-2*k*m+2*m*m) / (m*k) );
                        completed = true;
                        break;
                    }
                    k+=2;
                }
            }
            if (completed == true){
                break;
            }
        }
        long finishTime = System.nanoTime();
        double timeTaken = (double)(finishTime - startTime);
        System.out.println(product);
        System.out.println("Time Taken:" + timeTaken/1000000000 + " seconds");
    }

    public static int gcd (int a, int b){
        if (b == 0){
            return a;
        }
        return gcd(b,a%b);
    }
}