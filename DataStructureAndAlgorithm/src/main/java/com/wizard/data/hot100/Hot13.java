package com.wizard.data.hot100;

public class Hot13 {


    public static void main(String[] args) {
        int[] nums = {-2,-1};

        int resultValue = maxSubArray(nums);
        System.out.println(resultValue);

    }

    public static int maxSubArray(int[] nums) {

        int maxValue = nums[0];
        int sum = 0;
        for(int index = 0; index < nums.length; index++) {
            if(sum > 0){
                sum += nums[index];
            }else{
                sum = nums[index];
            }
            maxValue = Math.max(maxValue, sum);
        }
        return maxValue;
    }
}
