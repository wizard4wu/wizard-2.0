package com.wizard.data.leetcode;

public class MergeArray_88 {
    public static void main(String[] args) {

        int[] a = {1, 2, 3, 0, 0, 0};
        int[] b = {2, 5, 6};
        merge(a, 3, b, 3);
    }

    // solution one: Time complexity:O(n), Space complexity:O(n), from first to last;
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int length = m + n;
        int[] resultArray = new int[length];
        //statement a array, the array can replace the nums1

        int arrayOneIndex = 0;
        int arrayTwoIndex = 0;

        for (int index = 0; index < length; index++) {
            if (m == arrayOneIndex) {
                resultArray[index] = nums2[arrayTwoIndex];
                arrayTwoIndex++;
            } else if (n == arrayTwoIndex) {
                resultArray[index] = nums1[arrayOneIndex];
                arrayOneIndex++;
            } else if (nums1[arrayOneIndex] < nums2[arrayTwoIndex]) {
                resultArray[index] = nums1[arrayOneIndex];
                arrayOneIndex++;
            } else {
                resultArray[index] = nums2[arrayTwoIndex];
                arrayTwoIndex++;
            }
        }
        for (int index = 0; index < resultArray.length; index++) {
            nums1[index] = resultArray[index];
        }
    }
}
