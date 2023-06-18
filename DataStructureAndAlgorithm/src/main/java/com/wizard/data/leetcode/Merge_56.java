package com.wizard.data.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Merge_56 {
    public static void main(String[] args) {

        while(true){

        }
//        int[][] arrays = {{1,4},{2,3}};
//        int[][] result = merge(arrays);
//        System.out.println(result);
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int max = intervals[0][1];
        List<int[]> resultList = new ArrayList<>();
        int resultIndex = 0;
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int index = 1; index < intervals.length; index ++){
            if(intervals[index][0] <= max){
                if(intervals[index][1] > end){
                    end = intervals[index][1];
                }
            }else {
                resultIndex ++;
                resultList.add(new int[]{start, end});
                start = intervals[index][0];
                end = intervals[index][1];
            }
            if(intervals[index][1] > max){
                max = intervals[index][1];
            }
        }
        resultList.add(new int[]{start, end});
        return resultList.toArray(new int[][]{});
    }
}
