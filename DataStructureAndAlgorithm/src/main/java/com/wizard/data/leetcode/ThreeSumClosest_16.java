package com.wizard.data.leetcode;

import java.util.Arrays;

public class ThreeSumClosest_16 {

    public static void main(String[] args) {
        int[] nums =  {0, 0, 0};
        System.out.println(threeSumClosest(nums, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int resultValue = Integer.MAX_VALUE;
        int result = 0;
        for(int index = 0; index < nums.length - 2; index ++){
            int leftIndex = index + 1;
            int rightIndex = nums.length - 1;

            while(leftIndex < rightIndex){
                int sum = nums[index] + nums[leftIndex] + nums[rightIndex] - target;
                if(sum > 0){
                    rightIndex --;
                }else {
                    leftIndex ++;
                }
                if(Math.abs(sum) < resultValue){
                    resultValue = Math.abs(sum);
                    result = sum + target;
                }
            }
        }
        return result;
    }
}
