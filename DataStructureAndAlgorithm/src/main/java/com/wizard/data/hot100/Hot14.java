package com.wizard.data.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hot14 {

    public static void main(String[] args) {
       int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(merge(intervals));
    }


    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (prev, next) -> prev[0] - next[0]);
        int leftValue = intervals[0][0];
        int rightValue = intervals[0][1];

        List<int[]> resultList = new ArrayList<>();
        for (int index = 1; index < intervals.length; index ++) {
            if(rightValue >= intervals[index][0]) {
                rightValue = Math.max(rightValue, intervals[index][1]);
            }else{
                resultList.add(new int[]{leftValue, rightValue});
                leftValue = intervals[index][0];
                rightValue = intervals[index][1];
            }
        }
        resultList.add(new int[]{leftValue, rightValue});
        return resultList.toArray(new int[resultList.size()][]);
    }
}
