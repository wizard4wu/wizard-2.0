package com.wizard.data.leetcode;

/**
 * 在未排序的数组中找到第k个最大的元素。请注意，你需要找的是数组排序后的第k个最大的元素，而不是第k个不同的元素。
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 * 说明:你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class Interview_1 {

    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        int k = 2;
        int result = findKthLargest(arr, k - 1);
        System.out.println(result);
    }

    public static int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, k);
    }
    public static int quickSort(int[] nums, int leftIndex, int rightIndex, int k) {
        if(leftIndex == rightIndex){
            return nums[leftIndex];
        }
        int pivotIndex = partition(nums, leftIndex, rightIndex);

        if(k == pivotIndex){
            return nums[k];
        }else if(k < pivotIndex){
            return quickSort(nums, leftIndex, pivotIndex - 1, k);
        }else{
            return quickSort(nums, pivotIndex + 1, rightIndex, k);
        }
    }
    private static int partition(int[] nums, int leftIndex, int rightIndex) {
        int pivot = nums[leftIndex];
        int i = leftIndex + 1;
        for(int index = i; index <= rightIndex; index++){
            if(nums[index] > pivot){
                swap(nums, i, index);
                i ++;
            }
        }
        swap(nums, leftIndex, i - 1);
        return i - 1;
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
