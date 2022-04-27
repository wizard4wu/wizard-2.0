package com.wizard.data.structure.sort;

import java.util.Arrays;

/**
 * @author wizard
 * @date 2022/03/10
 */

public class SortClass {

    public static int[] splitData(int[] array, int min, int max) {


        return null;
    }

    public static int[] mergeSort(int[] array, int min, int max) {

        if (array.length == 1) {
            return array;
        }
        if (array.length == 2) {
            if (array[0] > array[1]) {
                int temp = array[0];
                array[0] = array[1];
                array[1] = temp;
            }
            return array;
        }

        int middle = array.length / 2;


        int[] array1 = Arrays.copyOfRange(array, min, middle);
        int[] array2 = Arrays.copyOfRange(array, middle, max);
        return mergeData(mergeSort(array1, 0, array1.length), mergeSort(array2, 0, array2.length));
    }


    public static int[] mergeData(int[] arrayOne, int[] arrayTwo) {

        int lengthOne = arrayOne.length;
        int lengthTwo = arrayTwo.length;
        if (lengthOne == 0) {
            return arrayOne;
        } else if (lengthTwo == 0) {
            return arrayTwo;
        }

        int resultLength = lengthOne + lengthTwo;
        int[] resultArray = new int[resultLength];
        int indexOne = 0;
        int indexTwo = 0;
        for (int index = 0; index < resultLength; index++) {
            if (indexOne == lengthOne) {
                resultArray[index] = arrayTwo[indexTwo];
                indexTwo++;
            } else if (indexTwo == lengthTwo) {
                resultArray[index] = arrayOne[indexOne];
                indexOne++;
            } else if (arrayOne[indexOne] > arrayTwo[indexTwo]) {
                resultArray[index] = arrayTwo[indexTwo];
                indexTwo++;

            } else {
                resultArray[index] = arrayOne[indexOne];
                indexOne++;

            }
        }
        return resultArray;
    }

    public static void main(String[] args) {

        int[] a = {1, 3, 5, 6, 15, 17};
        int[] b = {2, 7, 8, 9, 15, 76};

        int[] testData = {2, 6, 20, 35, 7, 3, 12, 7, 9, 0, 2};
        int[] testData1 = {6, 7, 3, 12};

        int[] result = mergeSort(testData, 0, testData.length);

        Arrays.stream(result).forEach(value -> System.out.print(value + " "));


    }
}
