package com.wizard.data.jianzhi;

public class MaxValueInRotateArray_153 {
    public static void main(String[] args) {
        int[] nums = {2,1};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int middle = (left + right) >> 1;

            //左侧有序
            if(nums[0] <= nums[middle]){
                left = middle + 1;
            }else{
                //右侧有序
                right = middle - 1;
            }
        }

        return nums[left];
    }
}
