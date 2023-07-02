package com.wizard.data.leetcode;

public class LongestCommonSubsequence_95 {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("bsbininm",
                "jmjkbkjkv"));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] resultArray = new int[text1.length() + 1][text2.length() + 1];

        for(int text1Index = 1; text1Index <= text1.length(); text1Index ++){
            char charValue = text1.charAt(text1Index - 1);
            for(int text2Index = 1; text2Index <= text2.length(); text2Index ++){
                if(charValue == text2.charAt(text2Index - 1)){
                    resultArray[text1Index][text2Index] = resultArray[text1Index - 1][text2Index - 1] + 1;
                }else{
                    resultArray[text1Index][text2Index] = Math.max(resultArray[text1Index - 1][text2Index], resultArray[text1Index][text2Index - 1]);
                }
            }
        }
        return resultArray[text1.length()][text2.length()];
    }
}
