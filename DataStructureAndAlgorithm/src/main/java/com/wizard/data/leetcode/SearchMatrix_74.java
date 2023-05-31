package com.wizard.data.leetcode;

public class SearchMatrix_74 {

    public static void main(String[] args) {

        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        boolean result = searchMatrix(matrix, 3);
        System.out.println(result);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        int length = matrix[0].length;
        int high = matrix.length;
        int end = length * high - 1;
        int start = 0;
        while (start <= end){
            int middle = (start + end) / 2;
            int value = matrix[middle/length][middle % length];
            if(value > target){
                end = middle - 1;
            }else if(value < target){
                start = middle + 1;
            }else {
                return true;
            }
        }
        return false;
    }
}
