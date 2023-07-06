package com.wizard.data.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Permute_46 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Stack<Integer> stack = new Stack<>();
        if(0 == nums.length){
            return result;
        }
        dfs(result, used, stack, nums, 0);
        return result;
    }

    private static void dfs(List<List<Integer>> result, boolean[] used, Stack<Integer> stack, int[] nums, int depth) {
        if(depth == nums.length){
            result.add(new ArrayList<>(stack));
            return;
        }

        for(int index = 0; index < nums.length; index ++){
            if(used[index]){
                continue;
            }
            used[index] = true;
            stack.add(nums[index]);
            dfs(result, used, stack, nums, depth + 1);
            used[index] = false;
            stack.pop();
        }


    }

}
