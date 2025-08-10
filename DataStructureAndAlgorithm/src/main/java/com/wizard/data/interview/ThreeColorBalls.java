package com.wizard.data.interview;

public class ThreeColorBalls {
    public static void main(String[] args) {
        int[] array = {2, 0, 2, 1, 1, 0};
        threeColorSort(array);
        for(int value : array) {
            System.out.print(value + " ");
        }
    }
    private static void threeColorSort(int[] array){
        int leftIndex = 0;
        int rightIndex = array.length - 1;

        int currentIndex = 0;
        while(currentIndex < rightIndex){
            if(array[currentIndex] == 0){
                swap(array, leftIndex, currentIndex);
                leftIndex++;
                currentIndex++;
            }else if(array[currentIndex] == 2){
                swap(array, rightIndex, currentIndex);
                rightIndex--;
            }else {
                currentIndex++;;
            }
        }
    }
    private static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
