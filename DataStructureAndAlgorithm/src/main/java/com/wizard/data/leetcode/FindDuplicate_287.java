package com.wizard.data.leetcode;

import java.util.Arrays;

public class FindDuplicate_287 {

    public static void main(String[] args) {
        int[] nums = {1,3,4,2};
        System.out.println(findDuplicate(nums));
    }

    public static int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        char[] a = "ddd".toCharArray();
                Arrays.sort("dd".toCharArray());
        Arrays.sort(a);
        new String(a);

        int[] array = {22,33};
        array = new int[]{11, 33};
        slow = nums[slow];
        fast = nums[nums[fast]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int pre1 = 0;
        int pre2 = slow;
        while(pre1 != pre2){
            pre1 = nums[pre1];
            pre2 = nums[pre2];
        }
        return pre1;
    }


}
