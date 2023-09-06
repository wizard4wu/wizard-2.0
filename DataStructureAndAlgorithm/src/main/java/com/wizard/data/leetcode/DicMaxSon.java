package com.wizard.data.leetcode;

import java.util.HashMap;
import java.util.Map;

public class DicMaxSon {
    public static void main(String[] args) {
        String value = "ababba";
        String newValue = sort(value);
        System.out.println(newValue);
        Map<Integer, Integer> map = new HashMap<>();
    }
    public static String sort(String value){

        StringBuilder sb = new StringBuilder();
        int indexValue = 0;
        for(char ch = 'z'; ch >= 'a'; ch --){
            for(int index = indexValue; index < value.length(); index ++){
                if(value.charAt(index) == ch){
                    sb.append(ch);
                    indexValue = index;
                }
            }
        }
        return sb.toString();
    }
}
