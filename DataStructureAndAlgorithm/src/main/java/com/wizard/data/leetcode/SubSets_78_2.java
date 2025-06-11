package com.wizard.data.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SubSets_78_2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        subsets(nums);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();  //用于收集返回的结果集
        collectData(nums, result, new ArrayList<>(), 0); //调用递归方法，初始的index是0
        return result;
    }
    //path是用来存储子集的，且在回溯的过程中会发生改变
    // startIndex用来控制是否复用集合中的数据，下文会专门讲讲
    private static void collectData(int[] nums, List<List<Integer>> result, List<Integer> path, int startIndex){
        //一般此处会有条件判断来决定结束递归，但是根据题意直接收集数据，因为path会变动，所以要深拷贝
        result.add(new ArrayList<>(path));
        for(int index = startIndex; index < nums.length; index ++){
            //添加数据到子集中
            path.add(nums[index]);
            collectData(nums, result, path, index + 1); //递归调用，index + 1表示对于提供数组数据不重用
            //回溯回退，需要剔除加入的当前值

            path.remove(path.size() - 1);
        }
    }
}
