package com.wizard.data.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TwoSum_1 {
    public static void main(String[] args) {

    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i ++){
            int remain = target - nums[i];
            if(hashMap.containsKey(remain)){
                return new int[]{hashMap.get(remain), i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[0];
    }
}
