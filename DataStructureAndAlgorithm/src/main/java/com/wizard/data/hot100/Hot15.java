package com.wizard.data.hot100;

public class Hot15 {


    public void rotate(int[] nums, int k) {
        k = k % nums.length; //防止溢出数组
        revertArray(nums, 0, nums.length - 1);
        revertArray(nums, 0, k - 1);
        revertArray(nums, k, nums.length - 1);
    }
    public void revertArray(int[] nums, int leftIndex, int rightIndex){
        while(leftIndex < rightIndex){
            int tempValue = nums[leftIndex];
            nums[leftIndex] = nums[rightIndex];
            nums[rightIndex] = tempValue;
            leftIndex ++;
            rightIndex --;
        }
    }
}
