
//龍ONE

public class Problem_08 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The maximum product in this 1000 digit number is: ";
    private static final String INPUT = "73167176531330624919225119674426574742355349194934969"
            + "8352031277450632623957831801698480186947885184385861560789112949495459501737958"
            + "3319528532088055111254069874715852386305071569329096329522744304355766896648950"
            + "4452445231617318564030987111217223831136222989342338030813533627661428280644448"
            + "6645238749303589072962904915604407723907138105158593079608667017242712188399879"
            + "7908792274921901699720888093776657273330010533678812202354218097512545405947522"
            + "4352584907711670556013604839586446706324415722155397536978179778461740649551492"
            + "9086256932197846862248283972241375657056057490261407972968652414535100474821663"
            + "7048440319989000889524345065854122758866688116427171479924442928230863465674813"
            + "9191231628245861786645835912456652947654568284891288314260769004224219022671055"
            + "6263211111093705442175069416589604080719840385096245544436298123098787992724428"
            + "4909188845801561660979191338754992005240636899125607176060588611646710940507754"
            + "100225698315520005593572972571636269561882670428252483600823257530420752963450";
    private static final int ADJACENT_VALUES = 13;

    public static void main(String[] args) {

        long startTime = System.nanoTime();
        long maximum_product = 0;
        // Calculate answer using substring
        for (int counter = 0; counter <= INPUT.length() - ADJACENT_VALUES; counter++) {
            long product = 1;
            for (int counterTwo = counter; counterTwo <= counter + ADJACENT_VALUES - 1; counterTwo++) {
                product *= Integer.parseInt("" + INPUT.charAt(counterTwo));
            }
            if (product > maximum_product) {
                maximum_product = product;
            }
        }
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + maximum_product);
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
    }
}