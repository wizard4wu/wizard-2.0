package com.wizard.data.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_39_2 {

    /**
     * 1.数组的和必须是偶数；
     * 2.最大值要小于数组和的一半；
     */
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> result = combinationSum(candidates, 7);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> list = new ArrayList<>();

        collectData(candidates, target, result, list, 0);
        return result;
    }

    private static void collectData(int[] candidates, int target, List<List<Integer>> result, List<Integer> list, int startIndex){
        if(target < 0){
            return;
        }
        if(target == 0){
            List<Integer> tempList = new ArrayList<>();
            for(Integer intValue : list){
                tempList.add(intValue);
            }
            result.add(tempList);
            return;
        }
        /**
         * 这里index为0时会出现重复的集合
         * 为了去除重复的集合我们需要对于index进行控制
         */
        for(int index = startIndex; index < candidates.length; index ++){
            list.add(candidates[index]);
            collectData(candidates, target - candidates[index], result, list, index);  //注意这里是index不是index+1，因为题目是可以包含本身的，index+1的话就是会去除本身
            list.remove(list.size() - 1);
        }
    }
}
