package com.wizard.data.leetcode;

public class Search_33 {
    public static void main(String[] args) {

    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int middle = (left + right) >> 1;
            if(nums[middle] == target){
                return middle;
            }

            if(nums[0] < nums[middle]) {//有序段
                //在有序的左侧
                if(nums[0] <= target && target < nums[middle]){
                    //middle =
                }else {
                    //在有序的右侧

                }

            } else {//无序段

            }




        }

        return 0;
    }
}
