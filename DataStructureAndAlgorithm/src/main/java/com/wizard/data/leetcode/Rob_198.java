package com.wizard.data.leetcode;

public class Rob_198 {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,7,9,3,1}));
    }

    public static int rob(int[] nums) {
       int[] value = new int[nums.length];
       value [0] = nums[0];
       value [1] = Math.max(nums [1], nums[0]);
       for (int index = 2; index < nums.length; index ++){
           if(nums[index] + value [index - 2] > value [index - 1]){
               value[index] = nums[index] + value [index - 2];
           }else {
               value [index] = value[index - 1];
           }
       }
       return value[nums.length - 1];
    }
}
