package com.wizard.data.leetcode;

public class Trap_42 {

    public static void main(String[] args) {

        int[] array = {4,2,0,3,2,5};
        System.out.println(trap(array));
    }

    public static int trap(int[] height){

        int waterValue = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMaxValue = 0;
        int rightMaxValue = 0;
        while (left < right){
            if (height[left] < height[right]){
                if(leftMaxValue > height[left]){
                    waterValue += leftMaxValue - height[left];
                }else {
                    leftMaxValue = height[left];
                }
                left ++;
            }else {
                if(rightMaxValue > height[right]){
                    waterValue += rightMaxValue - height[right];
                }else {
                    rightMaxValue = height[right];
                }
                right --;
            }
        }
        return waterValue;
    }
}
