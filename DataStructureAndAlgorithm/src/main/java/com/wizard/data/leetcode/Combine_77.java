package com.wizard.data.leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Combine_77 {

    public static void main(String[] args) {

        combine(4, 2);

    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(result, new ArrayList<>(), n, k, 1);

        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> list, int n, int k, int startIndex){
        if(list.size() == k){
            List<Integer> tempResult = new ArrayList<>();
            for(Integer value : list){
                tempResult.add(value);
            }
            result.add(tempResult);
            return;
        }
        for(int index = startIndex; index <= n; index ++){
            list.add(index);
            backtrack(result, list, n, k, index);
            list.remove(list.size() - 1);
        }

    }
}
