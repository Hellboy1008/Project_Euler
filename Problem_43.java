
//龍ONE

import java.util.ArrayList;

public class Problem_43 {

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
        System.out.println("The sum of these special pandigital numbers is: " + answer);
        System.out.println("Time Taken:" + timeTaken / 1000000000 + " seconds");
    }

    private static long specialPandigitalNums() {
        // initialise ArrayLists
        for (int count = 10; count < 1000; count++) {
            if (count < 100 && count / 10 == count % 10 || containSameDigit(count) == true) {
                continue;
            }
            if (count % 2 == 0) {
                setD2D3D4.add(count);
            }
            if (count % 3 == 0) {
                setD3D4D5.add(count);
            }
            if (count % 5 == 0) {
                setD4D5D6.add(count);
            }
            if (count % 7 == 0) {
                setD5D6D7.add(count);
            }
            if (count % 11 == 0) {
                setD6D7D8.add(count);
            }
            if (count % 13 == 0) {
                setD7D8D9.add(count);
            }
            if (count % 17 == 0) {
                setD8D9D10.add(count);
            }
        }
        // run the same digit test 5 times to eliminate all impossible combinations
        for (int count = 0; count < 5; count++) {
            // check last 2 digits of list 1 and first 2 digits of list 2
            compareLists(setD2D3D4, setD3D4D5, 2);
            compareLists(setD3D4D5, setD4D5D6, 2);
            compareLists(setD4D5D6, setD5D6D7, 2);
            compareLists(setD5D6D7, setD6D7D8, 2);
            compareLists(setD6D7D8, setD7D8D9, 2);
            compareLists(setD7D8D9, setD8D9D10, 2);
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
            sum += missingNum * 1000000000 + setD2ThroughD10.get(index);
        }
        return sum;
    }

    private static boolean containSameDigit(int number) {
        // 3 digit numbers
        if (number > 99 && number < 1000) {
            int firstDigit = number / 100;
            int secondDigit = (number / 10) % 10;
            int thirdDigit = number % 10;
            return firstDigit == secondDigit || firstDigit == thirdDigit || secondDigit == thirdDigit;
        }
        // if it is an 8 digit number, add a zero at the end
        if (number > 10000000 && number < 100000000) {
            number *= 10;
        }
        // 9 digit numbers
        boolean[] digits;
        int temp = number;
        if (number > 100000000 && number < 1000000000) {
            digits = new boolean[10];
            while (temp != 0) {
                if (digits[temp % 10] == true) {
                    return true;
                } else {
                    digits[temp % 10] = true;
                }
                temp /= 10;
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
        if (digits == 2) {
            for (int indexOne = 0; indexOne < listOne.size(); indexOne++) {
                numOne = (int) listOne.get(indexOne);
                exists = false;
                for (int indexTwo = 0; indexTwo < listTwo.size(); indexTwo++) {
                    numTwo = (int) listTwo.get(indexTwo);
                    if (numOne % 100 == numTwo / 10) {
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
                    if (numTwo / 100 == numOne % 10) {
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
                if (numOne % 100 == numTwo / 10) {
                    temp.add(numOne * 10 + numTwo % 10);
                }
            }
        }
        listTwo.clear();
        listTwo.addAll(temp);
    }

    private static long findMissingNumber(long number) {
        boolean[] digits = new boolean[10];
        while (number != 0) {
            digits[(int) number % 10] = true;
            number /= 10;
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