package com.wizard.data.leetcode;

public class lengthOfLIS_300 {
    public static void main(String[] args) {
        int[] array = {1,3,6,7,9,4,10,5,6};
        System.out.println(lengthOfLIS(array));
    }

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int maxLength = 1;
        dp[0] = 1;
        for(int index = 1; index < nums.length; index ++){
            int max = 0;
            for(int dpIndex = 1; dpIndex <= index; dpIndex ++){
                if(nums[index] > nums[dpIndex - 1]){
                    dp[dpIndex] = dp[dpIndex - 1] + 1;
                }else {
                    dp[dpIndex] = dp[dpIndex - 1];
                }
            }
        }
        return dp[nums.length - 1];
    }
}
