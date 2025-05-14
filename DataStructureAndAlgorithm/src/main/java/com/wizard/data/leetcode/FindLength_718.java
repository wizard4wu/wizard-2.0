package com.wizard.data.leetcode;

public class FindLength_718 {
    public static void main(String[] args) {
        int[] nums1 = {0,0,0,0,1};
        int[] nums2 = {1,0,0,0,0};
        findLength(nums1, nums2);
    }

    public static int findLength(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[][] resultArray = new int[length1 + 1][length2 + 1];
        int maxLength = 0;
        for(int index = 0; index < length1; index ++){
            for(int index2 = 0; index2 < length2; index2 ++){
                if(nums1[index] == nums2[index2]){
                    resultArray[index + 1][index2 + 1] = resultArray[index][index2] + 1;
                }else{
                    //这里注意，和公共子序列不一样，因为这道题目要求连续，因此一旦出现不连续就要归零了；
                    resultArray[index + 1][index2 + 1] = 0;
                }
                maxLength = Math.max(maxLength, resultArray[index + 1][index2 + 1]);
            }
        }
        return maxLength;
    }
}
