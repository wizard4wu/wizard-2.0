package com.wizard.data.leetcode;

public class FirstMissingPositive_41 {
    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};

        int result = firstMissingPositive(nums);
    }

    public static int firstMissingPositive(int[] nums) {

        int n = nums.length;
        // 将每个数放到它应该在的位置
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // 交换 nums[i] 和 nums[nums[i] - 1]
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        // 找到第一个位置 i，使得 nums[i] != i + 1
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // 如果所有位置都正确，返回 n + 1
        return n + 1;
    }
}
