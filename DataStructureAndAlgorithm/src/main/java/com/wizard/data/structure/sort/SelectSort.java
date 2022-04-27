package com.wizard.data.structure.sort;

import java.util.Arrays;

public class SelectSort {


    public static void main(String[] args) {
        int [] array = {3,9,7,4,3,11,33,5,77,8};

        int[] result = selectSort(array);

        Arrays.stream(result).forEach( r -> System.out.print(r + " "));

    }

    private static int[] selectSort(int[] array) {

        for (int i = 0; i < array.length; i++){
            int index = i;
            int max = array[i];
            for(int j = i + 1; j < array.length; j++){
                if(array[j] < max){
                   index = j;
                   max = array[j];
                }
            }
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
        return array;
    }


}
