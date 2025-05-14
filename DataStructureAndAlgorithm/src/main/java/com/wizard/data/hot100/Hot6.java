package com.wizard.data.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hot6 {


    public static void main(String[] args) {

        Hot6 hot6 = new Hot6();
        List<List<Integer>> result = hot6.threeSum(new int[]{0, 0, 0, 0});
        System.out.println("hh");
    }
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();
        for(int arrayIndex = 0; arrayIndex < nums.length - 2; arrayIndex++) {
            //如果选定的当前数大于0的话，那么右侧的任何数都大于0，三个大于0的数肯定会大于0的
            if(nums[arrayIndex] > 0) {
                break;
            }
            //如果两个值相同会导致重复的数据,所以需要跳过
            if(arrayIndex >= 1 && nums[arrayIndex - 1] == nums[arrayIndex]) {
                continue;
            }

            int leftIndex = arrayIndex + 1;
            int rightIndex = nums.length - 1;

            while (leftIndex < rightIndex) {
                int sum = nums[arrayIndex] + nums[leftIndex] + nums[rightIndex];
                if(leftIndex > arrayIndex + 1 && nums[leftIndex - 1] == nums[leftIndex]){
                    continue;
                }
                if(sum == 0) {
                    resultList.add(List.of(nums[arrayIndex], nums[leftIndex], nums[rightIndex]));
                    while(nums[leftIndex - 1] != nums[leftIndex])leftIndex++;
                    rightIndex--;
                }
                if(sum < 0) {
                    leftIndex++;
                }
                if(sum > 0){
                    rightIndex--;
                }
            }
        }
        return resultList;
    }
}
