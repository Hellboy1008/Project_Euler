
//龍ONE

import java.util.ArrayList;

public class Problem_43 {

    private static final long TIME_CONVERSION = 1000000000;
    private static final String TIME_TAKEN = "Time Taken:%s seconds";
    private static final String ANSWER = "The sum of these special pandigital numbers is: ";
    private static final int TENS_DIGIT = 10;
    private static final int THREE_DIGIT_MAX = 999;
    private static final int MODULAR_FACTOR_ONE = 2;
    private static final int MODULAR_FACTOR_TWO = 3;
    private static final int MODULAR_FACTOR_THREE = 5;
    private static final int MODULAR_FACTOR_FOUR = 7;
    private static final int MODULAR_FACTOR_FIVE = 11;
    private static final int MODULAR_FACTOR_SIX = 13;
    private static final int MODULAR_FACTOR_SEVEN = 17;
    private static final int RUN_TIME = 5;
    private static ArrayList<Integer> setD2D3D4 = new ArrayList<Integer>();
    private static ArrayList<Integer> setD3D4D5 = new ArrayList<Integer>();
    private static ArrayList<Integer> setD4D5D6 = new ArrayList<Integer>();
    private static ArrayList<Integer> setD5D6D7 = new ArrayList<Integer>();
    private static ArrayList<Integer> setD6D7D8 = new ArrayList<Integer>();
    private static ArrayList<Integer> setD7D8D9 = new ArrayList<Integer>();
    private static ArrayList<Integer> setD8D9D10 = new ArrayList<Integer>();
    private static ArrayList<Integer> setD2ThroughD10 = new ArrayList<Integer>();

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        long answer = specialPandigitalNums();
        long finishTime = System.nanoTime();
        double timeTaken = (double) (finishTime - startTime);
        System.out.println(ANSWER + answer);
        System.out.printf(TIME_TAKEN, timeTaken / TIME_CONVERSION);
    }

    private static long specialPandigitalNums() {
        // initialise ArrayLists
        for (int count = TENS_DIGIT; count < (THREE_DIGIT_MAX + 1); count++) {
            if (count < (TENS_DIGIT * TENS_DIGIT) && count / TENS_DIGIT == count % TENS_DIGIT
                    || containSameDigit(count) == true) {
                continue;
            }
            if (count % MODULAR_FACTOR_ONE == 0) {
                setD2D3D4.add(count);
            }
            if (count % MODULAR_FACTOR_TWO == 0) {
                setD3D4D5.add(count);
            }
            if (count % MODULAR_FACTOR_THREE == 0) {
                setD4D5D6.add(count);
            }
            if (count % MODULAR_FACTOR_FOUR == 0) {
                setD5D6D7.add(count);
            }
            if (count % MODULAR_FACTOR_FIVE == 0) {
                setD6D7D8.add(count);
            }
            if (count % MODULAR_FACTOR_SIX == 0) {
                setD7D8D9.add(count);
            }
            if (count % MODULAR_FACTOR_SEVEN == 0) {
                setD8D9D10.add(count);
            }
        }
        // run the same digit test 5 times to eliminate all impossible combinations
        for (int count = 0; count < RUN_TIME; count++) {
            // check last 2 digits of list 1 and first 2 digits of list 2
            compareLists(setD2D3D4, setD3D4D5, MODULAR_FACTOR_ONE);
            compareLists(setD3D4D5, setD4D5D6, MODULAR_FACTOR_ONE);
            compareLists(setD4D5D6, setD5D6D7, MODULAR_FACTOR_ONE);
            compareLists(setD5D6D7, setD6D7D8, MODULAR_FACTOR_ONE);
            compareLists(setD6D7D8, setD7D8D9, MODULAR_FACTOR_ONE);
            compareLists(setD7D8D9, setD8D9D10, MODULAR_FACTOR_ONE);
            // check last digit of list 1 and first digit of list 2
            compareLists(setD6D7D8, setD8D9D10, 1);
            compareLists(setD5D6D7, setD7D8D9, 1);
            compareLists(setD4D5D6, setD6D7D8, 1);
            compareLists(setD3D4D5, setD5D6D7, 1);
            compareLists(setD2D3D4, setD4D5D6, 1);
        }
        // check all possible combinations and root out non pandigital options
        findCombinations(setD2D3D4, setD3D4D5);
        findCombinations(setD3D4D5, setD4D5D6);
        findCombinations(setD4D5D6, setD5D6D7);
        findCombinations(setD5D6D7, setD6D7D8);
        findCombinations(setD6D7D8, setD7D8D9);
        findCombinations(setD7D8D9, setD8D9D10);
        for (int index = 0; index < setD8D9D10.size(); index++) {
            int num = setD8D9D10.get(index);
            if (containSameDigit(num) == false) {
                setD2ThroughD10.add(num);
            }
        }
        // find sum of pandigital numbers
        long sum = 0;
        for (int index = 0; index < setD2ThroughD10.size(); index++) {
            long missingNum = findMissingNumber((long) setD2ThroughD10.get(index));
            sum += missingNum * TIME_CONVERSION + setD2ThroughD10.get(index);
        }
        return sum;
    }

    private static boolean containSameDigit(int number) {
        // 3 digit numbers
        if (number >= (TENS_DIGIT * TENS_DIGIT) && number < (THREE_DIGIT_MAX + 1)) {
            int firstDigit = number / (TENS_DIGIT * TENS_DIGIT);
            int secondDigit = (number / TENS_DIGIT) % TENS_DIGIT;
            int thirdDigit = number % TENS_DIGIT;
            return firstDigit == secondDigit || firstDigit == thirdDigit || secondDigit == thirdDigit;
        }
        // if it is an 8 digit number, add a zero at the end
        if (number > (TIME_CONVERSION / TENS_DIGIT / TENS_DIGIT) && number < (TIME_CONVERSION / TENS_DIGIT)) {
            number *= TENS_DIGIT;
        }
        // 9 digit numbers
        boolean[] digits;
        int temp = number;
        if (number > (TIME_CONVERSION / TENS_DIGIT) && number < TIME_CONVERSION) {
            digits = new boolean[TENS_DIGIT];
            while (temp != 0) {
                if (digits[temp % TENS_DIGIT] == true) {
                    return true;
                } else {
                    digits[temp % TENS_DIGIT] = true;
                }
                temp /= TENS_DIGIT;
            }
        }
        return false;
    }

    private static void compareLists(ArrayList<Integer> listOne, ArrayList<Integer> listTwo, int digits) {
        boolean exists;
        int numOne;
        int numTwo;
        // remove numbers in listOne if the last two digits of listOne doesn't match the
        // first two digits of listTwo
        if (digits == MODULAR_FACTOR_ONE) {
            for (int indexOne = 0; indexOne < listOne.size(); indexOne++) {
                numOne = (int) listOne.get(indexOne);
                exists = false;
                for (int indexTwo = 0; indexTwo < listTwo.size(); indexTwo++) {
                    numTwo = (int) listTwo.get(indexTwo);
                    if (numOne % (TENS_DIGIT * TENS_DIGIT) == numTwo / TENS_DIGIT) {
                        exists = true;
                        break;
                    }
                }
                if (exists == false) {
                    listOne.remove(indexOne);
                    indexOne--;
                }
            }
        } else if (digits == 1) {
            // remove numbers in listTwo if the first digit of listTwo doesn't match the
            // last digit of listOne
            for (int indexTwo = 0; indexTwo < listTwo.size(); indexTwo++) {
                numTwo = (int) listTwo.get(indexTwo);
                exists = false;
                for (int indexOne = 0; indexOne < listOne.size(); indexOne++) {
                    numOne = (int) listOne.get(indexOne);
                    if (numTwo / (TENS_DIGIT * TENS_DIGIT) == numOne % TENS_DIGIT) {
                        exists = true;
                        break;
                    }
                }
                if (exists == false) {
                    listTwo.remove(indexTwo);
                    indexTwo--;
                }
            }
        }
    }

    private static void findCombinations(ArrayList<Integer> listOne, ArrayList<Integer> listTwo) {
        int numOne;
        int numTwo;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for (int indexOne = 0; indexOne < listOne.size(); indexOne++) {
            numOne = (int) listOne.get(indexOne);
            for (int indexTwo = 0; indexTwo < listTwo.size(); indexTwo++) {
                numTwo = (int) listTwo.get(indexTwo);
                if (numOne % (TENS_DIGIT * TENS_DIGIT) == numTwo / TENS_DIGIT) {
                    temp.add(numOne * TENS_DIGIT + numTwo % TENS_DIGIT);
                }
            }
        }
        listTwo.clear();
        listTwo.addAll(temp);
    }

    private static long findMissingNumber(long number) {
        boolean[] digits = new boolean[TENS_DIGIT];
        while (number != 0) {
            digits[(int) number % TENS_DIGIT] = true;
            number /= TENS_DIGIT;
        }
        // find digit that doesn't exist
        int missing = 0;
        for (int index = 0; index < digits.length; index++) {
            if (digits[index] == false) {
                missing = index;
                break;
            }
        }
        return missing;
    }

}