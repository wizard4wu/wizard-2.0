package com.wizard.data.leetcode;

public class Rotate_189 {
    public static void main(String[] args) {

        int k = 2;
        int[] array = {1,2};
        rotate(array, 0, array.length - 1);
        rotate(array, 0, k - 1);
        rotate(array, k, array.length - 1);
        System.out.println("ddd");
    }

    public static void rotate(int[] nums, int start, int end) {

        int middle = (end - start)/2 + start;
        int endIndex = end;

        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }
}
