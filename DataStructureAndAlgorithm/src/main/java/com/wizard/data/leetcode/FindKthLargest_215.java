package com.wizard.data.leetcode;

//第K大的元素
public class FindKthLargest_215 {

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int result = findKthLargest(nums, 0, nums.length - 1, 4);
        System.out.println(result);
    }
    //第K大的数也就是 从小到大排序后 第nums.length - k
    public static int findKthLargest(int[] nums, int left, int right, int k){
        int position = sort(nums, left,right);
        if(position == nums.length - k){
            return nums[position];
        }else if(nums.length - k < position){
            return findKthLargest(nums, left, position - 1, k);
        }else {
            return findKthLargest(nums, position + 1, right, k);
        }
    }

    public static int sort(int[] nums, int leftIndex, int rightIndex){
        int currentLeftIndex = leftIndex;
        int currentRightIndex = rightIndex;
        int pivot = nums[leftIndex];
        while(currentLeftIndex < currentRightIndex){

            while(currentLeftIndex < currentRightIndex && nums[currentRightIndex] > pivot){
                currentRightIndex --;
            }
            if(currentLeftIndex < currentRightIndex){
                nums[currentLeftIndex] = nums[currentRightIndex];
                currentLeftIndex ++;
            }

            while(currentLeftIndex < currentRightIndex && nums[currentLeftIndex] < pivot){
                currentLeftIndex ++;
            }
            if(currentLeftIndex < currentRightIndex){
                nums[currentRightIndex] = nums[currentLeftIndex];
                currentRightIndex --;
            }
        }
        nums[currentRightIndex] = pivot;
        return currentRightIndex;
    }
}
