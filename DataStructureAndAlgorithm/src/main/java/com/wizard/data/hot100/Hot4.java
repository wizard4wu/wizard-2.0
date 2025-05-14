package com.wizard.data.hot100;

public class Hot4 {

    public static void main(String[] args) {
        int[] array = {3,4,5,0,1,3,4};
        moveZeroes(array);
    }

    public static void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 1) {
            return;
        }
        int leftZeroIndex = 0;
        for (int arrayIndex = 0; arrayIndex < nums.length; arrayIndex++) {
            if (nums[arrayIndex] != 0) {
                int temp = nums[leftZeroIndex];
                nums[leftZeroIndex] = nums[arrayIndex];
                nums[arrayIndex] = temp;
                leftZeroIndex ++;
            }
        }
    }
}
