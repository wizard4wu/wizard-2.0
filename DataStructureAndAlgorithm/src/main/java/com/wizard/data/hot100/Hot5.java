package com.wizard.data.hot100;

public class Hot5 {
    public static void main(String[] args) {
        int[] array = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(array));
    }

    public static int maxArea(int[] height) {
        int maxWaterArea = 0;

        int leftIndex = 0;
        int rightIndex = height.length - 1;
        while (leftIndex < rightIndex) {

            int tempWater = (rightIndex - leftIndex) * Math.min(height[leftIndex], height[rightIndex]);
            if(height[leftIndex] < height[rightIndex]) {
                leftIndex++;
            }else{
                rightIndex--;
            }
            maxWaterArea = Math.max(maxWaterArea, tempWater);
        }
        return maxWaterArea;
    }
}
