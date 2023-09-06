package com.wizard.data.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_39 {

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        combinationSum(candidates, target);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        combinationSum(candidates, list, new ArrayList<Integer>(), target, 0);
        return list;
    }

    public static void combinationSum(int[] candidates, List<List<Integer>> list, List<Integer> tempResult, int target, int nextIndex){
        if(target < 0){
            return;
        }
        if(target == 0){
            list.add(new ArrayList(tempResult));
            return;
        }
        for(int index = 0; index < candidates.length; index ++){
            tempResult.add(candidates[index]);
            System.out.println("递归调用前：" + tempResult + "  target:" + (target - candidates[index]));
            combinationSum(candidates, list, tempResult, target - candidates[index], index);
            tempResult.remove(tempResult.size() - 1);
            System.out.println("递归调用后：" + tempResult + "  target:" + target);
        }
    }
}
