package com.wizard.data.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        getSubSets(result, nums, used, new ArrayList<Integer>(), 0);
        System.out.println(result);
    }


    public static void getSubSets(List<List<Integer>> result, int[] nums, boolean[] used, List<Integer> tempList, int size){

        result.add(new ArrayList(tempList));

        for(int index = size; index < nums.length; index ++){
            if(used[index]){
                continue;
            }
            tempList.add(nums[index]);
            used[index] = true;
            getSubSets(result, nums, used, tempList, index + 1);
            used[index] = false;
            tempList.remove(tempList.size() - 1);
        }
    }
}
