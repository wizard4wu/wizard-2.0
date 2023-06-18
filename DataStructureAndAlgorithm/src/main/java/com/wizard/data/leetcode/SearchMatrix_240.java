package com.wizard.data.leetcode;

public class SearchMatrix_240 {
    public static void main(String[] args) {

        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};


        System.out.println(searchMatrix(matrix, 5));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        int width = matrix[0].length - 1;
        int height = 0;
        while (width >= 0 && height < matrix.length) {
            int value = matrix[height][width];
            if (target == value) {
                return true;
            }
            if (value > target) {
                width--;
            }
            if (value < target) {
                height++;
            }
        }
        return false;
    }
}