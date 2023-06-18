package com.wizard.data.structure.sort;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = {1,4,9,4,2,1,0};
        quickSort(array, 0, array.length - 1);
        System.out.println(array.toString());
    }

    private static void quickSort(int[] array, int leftIndex, int rightIndex) {

        //防止出现死递归
        if(leftIndex >= rightIndex){
            return;
        }
        //获取第一个作为中转值
        int pivot = array[leftIndex];
        int currentLeftIndex = leftIndex;
        int currentRightIndex = rightIndex;
        //找到pivot的所在位置 跳出循环
        while(currentLeftIndex < currentRightIndex){

            while (currentLeftIndex < currentRightIndex && array[currentRightIndex] > pivot){
                currentRightIndex --;
            }
            if(currentLeftIndex < currentRightIndex){
               array[currentLeftIndex] = array[currentRightIndex];
               currentLeftIndex ++;
            }

            while (currentLeftIndex < currentRightIndex && array[currentLeftIndex] < pivot){
                currentLeftIndex ++;
            }
            if (currentLeftIndex < currentRightIndex){
                array[currentRightIndex] = array[currentLeftIndex];
                currentRightIndex --;
            }
        }
        //找到pivot的合适位置进行替换
        array[currentRightIndex] = pivot;
        quickSort(array, leftIndex, currentRightIndex - 1);
        quickSort(array, currentRightIndex + 1, rightIndex);
    }
}
