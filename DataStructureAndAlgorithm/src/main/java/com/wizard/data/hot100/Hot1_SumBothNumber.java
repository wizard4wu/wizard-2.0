package com.wizard.data.hot100;

import java.util.HashMap;
import java.util.Map;

public class Hot1_SumBothNumber {
    public static void main(String[] args) {

        int[] nums = {3,2,4};
        int[] result= twoSum_2(nums, 6);
        System.out.println(result[0] + " " + result[1]);
    }
    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> indexMap = new HashMap<>(nums.length);
        for(int i = 0; i < nums.length; i++) {
            indexMap.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++) {
            int firstValue = nums[i];
            Integer secondValueIndex = indexMap.get(target - firstValue);
            if(null != secondValueIndex && i != secondValueIndex) {
                return new int[]{i, secondValueIndex};
            }
        }
        return null;
    }
    public static int[] twoSum_2(int[] nums, int target) {

        Map<Integer, Integer> indexMap = new HashMap<>(nums.length);
        for(int index = 0; index < nums.length; index++) {
            int firstValue = nums[index];
            Integer secondValueIndex = indexMap.get(target - firstValue);
            if(null != secondValueIndex) {
                return new int[]{secondValueIndex, index};
            }
            indexMap.put(firstValue, index);
        }
        return null;
    }
}
