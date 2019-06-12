
/**
 * Created by: 龍ONE 
 * Date Created: Jan 23, 2018
 * Date Edited: June 11, 2019
 * Purpose: Solution to Project Euler Problem 13
 */

/**
 * This class contains a method that calculates the the first ten digits of the
 * sum of n 50 digit numbers. The main method executes the program.
 */
public class Problem_13 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The first ten digits of the sum is: ";
    private static final double[] list = { 3710728753.3, 4637693767.7, 7432498619.9, 9194221336.3, 2306758820.7,
            8926167069.6, 2811287981.2, 4427422891.7, 4745144573.6, 7038648610.5, 6217645714.1, 6490635246.2,
            9257586771.8, 5820356532.5, 8018119938.4, 3539866437.2, 8651550600.6, 7169388870.7, 5437007057.6,
            5328265410.8, 3612327252.5, 4587657617.2, 1742370690.5, 8114266041.8, 5193432545.1, 6246722164.8,
            1573244438.6, 5503768752.5, 1833638482.5, 8038628759.2, 7818283375.7, 1672632010.0, 4840309812.9,
            8708698755.1, 5995940689.5, 6979395067.9, 4105268470.8, 6537860736.1, 3582903531.7, 9495375976.5,
            8890280257.1, 2526768027.6, 3627021854.0, 2407448690.8, 9143028819.7, 3441306557.8, 2305308117.2,
            1148769693.2, 6378329949.0, 6772018697.1, 9554825530.0, 7608532713.2, 3777424253.5, 2370191327.5,
            2979886027.2, 1849570145.4, 3829820378.3, 3482954382.9, 4095795306.6, 2974615218.5, 4169811622.2,
            6246795719.4, 2318970677.2, 8618808822.5, 1130673970.8, 8295917476.7, 9762333104.4, 4284628018.3,
            5512160354.6, 3223819573.4, 7550616496.5, 6217784275.2, 3292418570.7, 9951867143.0, 7326746080.0,
            7684182252.4, 9714261791.0, 8778364618.2, 1084880252.1, 7132961247.4, 6218407357.2, 6662789198.1,
            6066182629.3, 8578694408.9, 6602439640.9, 6491398268.0, 1673093931.9, 9480937724.5, 7863916702.1,
            1536871371.1, 4078992311.5, 4488991150.1, 4150312888.0, 8123488067.3, 8261657077.3, 2291880205.8,
            7715854250.2, 7210783843.5, 2084960398.0, 5350353422.6 };
    private static final int NUM_OF_DIGITS = 10;

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        long sum = 0;
        // Find sum of first 11 numbers (only the first 11 matters)
        for (int counter = 0; counter < list.length; counter++) {
            sum += list[counter] * NUM_OF_DIGITS;
        }
        sum /= (NUM_OF_DIGITS * NUM_OF_DIGITS * NUM_OF_DIGITS); // take away the last few digits
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + sum);
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
    }
}