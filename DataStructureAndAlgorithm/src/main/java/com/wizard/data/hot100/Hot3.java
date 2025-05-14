package com.wizard.data.hot100;

import java.util.HashSet;
import java.util.Set;

public class Hot3 {
    public static void main(String[] args) {

        int[] nums = {1,0,1,2};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>(nums.length);
        for (int num : nums) {
            numSet.add(num);
        }
        int maxCounter = 0;

        for (int num : numSet) {
            if(numSet.contains(num - 1)) {
                continue;
            }
            int tempCounter = 0;
            while (numSet.contains(num)) {
                tempCounter++;
                num ++;
            }
           maxCounter = Math.max(maxCounter, tempCounter);
        }
        return maxCounter;
    }
}
