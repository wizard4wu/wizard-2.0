package com.wizard.data.structure.sort;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = {5, 2, 3, 1};
        iteratorQuickSort(array);
//        System.out.println(array.toString());
        Queue<String> queue = new ArrayDeque();
        queue.add("eee");
        queue.add("ee");
        String s = queue.peek();

        System.out.println();
    }

    public static void iteratorQuickSort(int[] array){

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(array.length - 1);

        while(!stack.isEmpty()){
            int right = stack.pop();
            int left = stack.pop();
            if (right - left < 2) {
                continue;
                            }
            int index = partition(array, left, right);
            stack.push(index + 1);
            stack.push(right);
            stack.push(left);
            stack.push(index);
        }
    }



    //recursion
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
            }
        }
        //找到pivot的合适位置进行替换
        array[currentLeftIndex] = pivot;
        return currentLeftIndex;
    }
}
