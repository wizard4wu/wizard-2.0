package com.wizard.data.hot100;

public class Hot16 {


    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};
        int[] resultArray = productExceptSelf(arr);
        System.out.println(resultArray);
    }

    public static int[] productExceptSelf(int[] nums) {

        int length = nums.length;
        int[] left2Right = new int[length];
        int[] right2Left = new int[length];
        int[] resultArray = new int [length];
        left2Right[0] = 1;
        right2Left[length - 1] = 1;
        for(int index = 1; index < length; index ++){
            left2Right[index] = left2Right[index - 1] * nums[index - 1];
            right2Left[length - index - 1] = right2Left[length - index] * nums[length - index];
        }

        for(int index = 0; index < length; index ++){
            resultArray[index] = left2Right[index] * right2Left[index];
        }
        return resultArray;
    }
}
