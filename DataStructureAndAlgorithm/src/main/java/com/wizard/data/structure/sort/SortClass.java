package com.wizard.data.structure.sort;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author wizard
 * @date 2022/03/10
 */

public class SortClass {


    public static int[] split(int[] array, int min, int max) {
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
        int[] array2 = Arrays.copyOfRange(array, middle + 1, max);
        int[] newArray1 = split(array1, min, middle);
        int[] newArray2 = split(array2, middle + 1, max);
        return mergeData(newArray1, newArray2);
    }
    public static int[] mergeSort(int[] array, int left, int right){
        if(left < right){
            int middle = (left + right) >> 1;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
        return array;
    }

    public static int[] iteratorMergeSort(int[] array, int left, int right){
        Stack<Integer> stack = new Stack<>();
        stack.push(left);
        int middle = (left + right) >> 1;
        stack.push(middle);
        stack.push(right);
        while(!stack.isEmpty()){
            int end = stack.peek();
            int start = stack.peek();
            middle = (end + start) >> 1;

            if(start < end){
                    stack.push(middle + 1);
                    stack.push((end + middle + 1) >> 1);
                    stack.push(end);
                    stack.push(start);
                    stack.push((start + middle) >> 1);
                    stack.push(middle);
                }else {
                merge(array, start, middle, end);
            }


        }
        return array;
    }
    public static void merge(int[] array, int left, int middle, int right){
        System.out.println("合并数组: " + array + ", left: " + left + ", middle: " + middle + ", right: " + right);

        //分成两段：1.left ~ middle; 2.middle + 1 ~ right
        int leftIndex = left;
        int rightIndex = middle + 1;

        int index = 0;
        int[] temp = new int[right - left + 1];
        while(leftIndex <= middle && rightIndex <= right){
            if(array[leftIndex] < array[rightIndex]){
                temp[index ++] = array[leftIndex ++];
            }else{
                temp[index ++] = array[rightIndex ++];
            }
        }
        //右侧结束 左侧有剩余
        while (leftIndex <= middle){
            temp[index ++] = array[leftIndex ++];
        }
        //左侧结束 右侧有剩余
        while (rightIndex <= right){
            temp[index ++] = array[rightIndex ++];
        }
        for (int i = 0; i < index; i++){
            array[left + i] = temp[i];
        }
    }


    public static int[] merge(int[] arrayOne, int[] arrayTwo){
        int oneLength = arrayOne.length;
        int twoLength = arrayTwo.length;
        if (oneLength == 0) {
            return arrayTwo;
        } else if (twoLength == 0) {
            return arrayOne;
        }

        int resultLength = oneLength + twoLength;
        int[] resultArray = new int[resultLength];
        int oneIndex = 0;
        int twoIndex = 0;
        int index = 0;
        while(oneIndex < oneLength && twoIndex < twoLength){
            if(arrayOne[oneIndex] < arrayTwo[twoIndex]){
                resultArray[index ++] = arrayOne[oneIndex ++];
            }else{
                resultArray[index ++] = arrayTwo[twoIndex ++];
            }
        }

        while (oneIndex < oneLength){
            resultArray[index ++] = arrayOne[oneIndex ++];
        }
        while (twoIndex < twoLength){
            resultArray[index ++] = arrayTwo[twoIndex ++];
        }
        return  resultArray;
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
        int[] testData1 = {5,2,3,1};
        int[] resultArray = new int[testData.length];
        iteratorMergeSort(testData, 0, testData.length - 1);
        System.out.println();
    }

    public void mergeArray(int[] first, int[] second){
        int[] resultArray = new int[first.length + second.length];

        int firstIndex = 0;
        int secondIndex = 0;
        int resultIndex = 0;
        while(first.length > firstIndex && second.length > secondIndex){
            if(first[firstIndex] > second[secondIndex]){
                resultArray[resultIndex] = second[secondIndex];
                secondIndex ++;
            }else {
                resultArray[resultIndex] = second[firstIndex];
                firstIndex ++;
            }
            resultIndex++;
        }
    }
}
