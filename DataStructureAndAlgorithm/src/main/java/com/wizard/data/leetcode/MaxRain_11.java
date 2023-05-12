package com.wizard.data.leetcode;

public class MaxRain_11 {

    public static void main(String[] args) {

        int[] array = {1,8,6,2,5,4,8,3,7};

        System.out.println(maxArea(array));
    }


    public static int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int maxValue = 0;
        while(start < end){
            int width = end - start;
            int result = width * Math.min(height[end], height[start]);
            if(maxValue < result){
                maxValue = result;
            }
            if(height[end] > height[start]){
                start ++;
            }else {
                end --;
            }
        }
        return maxValue;
    }
}
