package com.wizard.data.hot100;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hot9 {

    public static void main(String[] args) {
        List<Integer> result = findAnagrams("cbaebabacd", "abc");

    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int sLength = s.length();
        int pLength = p.length();

        if(sLength < pLength){
            return List.of();
        }
        int[] pArray = new int[26];
        int[] sArray = new int[26];

        for(int index = 0; index < pLength; index ++){
            ++ pArray[p.charAt(index) - 'a'];
            ++ sArray[s.charAt(index) - 'a'];
        }
        if(Arrays.equals(pArray, sArray)){
            result.add(0);
        }
        for(int index = 0; index < sLength - pLength; index ++){
            -- sArray[s.charAt(index) - 'a'];
            ++ sArray[s.charAt(index + pLength) - 'a'];
            if(Arrays.equals(pArray, sArray)){
                result.add(index + 1);
            }
        }
        return result;
    }
}
