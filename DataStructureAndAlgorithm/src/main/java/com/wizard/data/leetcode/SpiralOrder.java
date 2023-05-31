package com.wizard.data.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

    public static void main(String[] args) {

        int[][] array= {{3}, {6}, {9}};
        List<Integer> result = spiralOrder(array);
        System.out.println(result);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int high = matrix.length;
        int length = matrix[0].length;
        int min = Math.min(high, length);
        int cursor = (min - 1)/2;
        List<Integer> result = new ArrayList<>(high * length);
        for (int start = 0; start <= cursor; start ++){
            collectData(matrix, start, length - start, high - start, length, high, result);
        }
        return result;
    }
    public static void collectData(int[][] matrix, int start, int length, int high, int realLength, int realHigh, List<Integer> result){

        for(int index = start; index < length; index ++){
            result.add(matrix[start][index]);
        }
        for(int index = start + 1; index < high - 1; index ++){
            result.add(matrix[index][realLength - start - 1]);
        }
        for(int index = start; index < length; index ++){
            int left = realHigh - start - 1;
            int right = realLength - index - 1;
            if(start!=left){
                result.add(matrix[left][right]);
            }
        }
        for(int index = start + 1; index < high - 1; index ++){
            int left = realHigh - index - 1;
            if(start != realLength-start-1){
                result.add(matrix[left][start]);
            }
        }
    }
}
