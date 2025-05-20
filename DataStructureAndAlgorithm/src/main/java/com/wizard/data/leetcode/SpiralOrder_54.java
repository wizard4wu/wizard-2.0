package com.wizard.data.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder_54 {
    public static void main(String[] args) {
        int[][] nums = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        spiralOrder(nums);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {

        int leftIndex = 0;
        int rightIndex = matrix[0].length - 1;
        int topIndex = 0;
        int bottomIndex = matrix.length - 1;

        int size = matrix.length * matrix[0].length;
        List<Integer> resultList = new ArrayList<>(size);

        int counter = 0;
        while(leftIndex <= rightIndex && topIndex <= bottomIndex){

            int tempLeftIndex = leftIndex;
            while(tempLeftIndex <= rightIndex){
                resultList.add(matrix[topIndex][tempLeftIndex ++]);
            }
            topIndex ++;

            int tempTopIndex = topIndex;
            while(tempTopIndex <= bottomIndex){
                resultList.add(matrix[tempTopIndex ++][rightIndex]);
            }
            rightIndex --;

            int tempRightIndex = rightIndex;
            while(tempRightIndex >= leftIndex){
                resultList.add(matrix[bottomIndex][tempRightIndex --]);
            }
            bottomIndex --;

            int tempBottomIndex = bottomIndex;
            while(tempBottomIndex >= topIndex){
                resultList.add(matrix[tempBottomIndex --][leftIndex]);
            }
            leftIndex ++;
        }
        return resultList;
    }
}
