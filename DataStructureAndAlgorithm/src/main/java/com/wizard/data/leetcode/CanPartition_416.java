package com.wizard.data.leetcode;

public class CanPartition_416 {

    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        System.out.println(canPartition(nums));
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0 || maxNum * 2 > sum) {
            return false;
        }
        int n = nums.length;
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = target; j >= nums[i - 1]; j--) {
                dp[j] |= dp[j - nums[i - 1]];
            }
        }
        return dp[target];
    }
}
