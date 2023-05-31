package com.wizard.data.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum_15 {

    public static void main(String[] args) {

        int[] nums = {-2,0,1,1,2};
        System.out.println(threeSum(nums));

    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for(int index = 0; index < nums.length; index ++){
            int rightIndex = nums.length - 1;
            int leftIndex = index + 1;
            if(nums[index] > 0) break;
            while (leftIndex < rightIndex){
                if(nums[index] + nums[leftIndex] + nums[rightIndex] == 0){
                    set.add(List.of(nums[index], nums[leftIndex], nums[rightIndex]));
                }
                if(nums[index] + nums[leftIndex] + nums[rightIndex] > 0){
                    rightIndex --;
                }else {
                    leftIndex ++;
                }
            }
        }
        return set.stream().toList();
    }
}
