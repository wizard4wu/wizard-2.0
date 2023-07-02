package com.wizard.data.structure.sort;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class QuickSort {

    public static void main(String[] args) {
//        int[] array = {1,4,9,4,2,1,0};
//        quickSort(array, 0, array.length - 1);
//        System.out.println(array.toString());
        Queue<String> queue = new ArrayDeque();
        queue.add("eee");
        queue.add("ee");
        String s = queue.peek();

        System.out.println();
    }

    private static void quickSort(int[] array, int leftIndex, int rightIndex) {

        //防止出现死递归
        if(leftIndex >= rightIndex){
            return;
        }
        int position = partition(array, leftIndex, rightIndex);

        quickSort(array, leftIndex, position - 1);
        quickSort(array, position + 1, rightIndex);
    }

    private static int partition(int[] array, int leftIndex, int rightIndex){
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
        return currentLeftIndex;
    }
}
