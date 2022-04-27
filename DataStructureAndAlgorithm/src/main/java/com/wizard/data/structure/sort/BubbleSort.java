package com.wizard.data.structure.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int [] array = {3,9,7,4,3,11,33,5,77,8};
        int [] result = bubbleSort(array);
        Arrays.stream(result).forEach(r -> System.out.print(r + " "));
    }


    public static int[] bubbleSort(int[] array){
        for(int i = 0; i < array.length; i ++){
            for ( int j = i + 1; j < array.length; j ++){
                if( array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}
