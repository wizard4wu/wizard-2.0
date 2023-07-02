package com.wizard.data.leetcode;

public class Rob2_213 {

    public static void main(String[] args) {

        int[] nums = {1, 2,3, 1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }

    public static int rob(int[]nums, int startIndex, int endIndex){
        int[] value = new int[nums.length];
        value[startIndex] = nums[startIndex];
        value[startIndex + 1] = Math.max(nums[startIndex], nums[startIndex + 1]);
        for(int index = startIndex + 2; index < endIndex; index ++){
            value[index] = Math.max(value[index - 2] + nums[index], value[index - 1]);
        }
        return value[endIndex - 1];
    }

}
