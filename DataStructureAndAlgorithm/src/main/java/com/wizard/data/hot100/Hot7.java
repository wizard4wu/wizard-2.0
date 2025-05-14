package com.wizard.data.hot100;

public class Hot7 {
    public static void main(String[] args) {

        Hot7 hot7 = new Hot7();
        int[] height = {4,2,0,3,2,5};
        int sum = hot7.trap(height);
        System.out.println(sum);
    }
    public int trap(int[] height) {

        int leftIndex = 0;
        int rightIndex = height.length - 1;

        int leftMaxValue = height[leftIndex];
        int rightMaxValue = height[rightIndex];
        int sum = 0;
        while(leftIndex < rightIndex){
            if(height[leftIndex] < height[rightIndex]){
                leftMaxValue = Math.max(leftMaxValue, height[leftIndex]);
                if(leftMaxValue > height[leftIndex]){
                    sum += leftMaxValue - height[leftIndex];
                }
                leftIndex ++;
            }else{
                rightMaxValue = Math.max(rightMaxValue, height[rightIndex]);
                if(rightMaxValue > height[rightIndex]){
                    sum += rightMaxValue - height[rightIndex];
                }
                rightIndex --;
            }
        }
        return sum;
    }
}
