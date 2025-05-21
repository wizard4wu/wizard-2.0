package com.wizard.data.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Interview_2 {
    public static void main(String[] args) {
        System.out.println(maxNoDuplicateLength("abcdabcd"));
        System.out.println(maxNoDuplicateLength("kwwkew"));

    }
    //String 找出最长子串，输出长度，要求连续的，不能出现重复值
    //abcdabcd 输出四
    //kwwkew

    private static int maxNoDuplicateLength(String valueString){
        Set<Character> charSet = new HashSet<>();
        int leftIndex = 0;
        int maxLength = 0;
        for(int rightIndex = 0; rightIndex < valueString.length(); rightIndex++){
            while(charSet.contains(valueString.charAt(rightIndex))){
                charSet.remove(valueString.charAt(leftIndex));
                leftIndex ++;
            }
            charSet.add(valueString.charAt(rightIndex));
            maxLength = Math.max(maxLength, rightIndex - leftIndex + 1);
        }
        return maxLength;
    }

}
