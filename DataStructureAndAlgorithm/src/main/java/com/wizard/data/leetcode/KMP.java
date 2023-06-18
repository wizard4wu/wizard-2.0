package com.wizard.data.leetcode;

import java.util.Arrays;

public class KMP {
    public static void main(String[] args) {

        String targetString = "abababcabcabce";
        String paternString = "aabaaac";

        int result = check(targetString, paternString);
        Arrays.stream(getNext(paternString)).forEach(System.out::print);
        System.out.println("");
        Arrays.stream(getRealNext(paternString)).forEach(System.out::print);
        System.out.println("");
       Arrays.stream(getNext(paternString.toCharArray())).forEach(System.out::print);
        //System.out.println(result);
    }

    public static int check(String target, String pattern) {
        int[] next = getNext(pattern.toCharArray());
        char[] targetChar = target.toCharArray();
        int j = 0;
        char[] patternChar = pattern.toCharArray();
        for (int i = 0; i < targetChar.length; i++) {
            while (j > 0 && patternChar[j] != targetChar[i]) {
                j = next[j];
            }
            if (targetChar[i] == patternChar[j]) {
                j++;
            }
            if (j == pattern.length()) {
                return i - pattern.length() + 1;
            }
        }
        return -1;
    }

    public static int[] getRealNext(String needle){
        //build the next array

        int[] next = new int[needle.length()];
        for(int index = 2; index < needle.length(); index ++){
            int left = 0;
            int right = 1;
            while(right < index){
                if(needle.charAt(left) != needle.charAt(right)){
                    left = 0;
                }
                if(needle.charAt(left) == needle.charAt(right)){
                    left ++;
                    next[index] = left;
                }
                right ++;
            }


        }
        return next;
    }

    public static int[] getNext(char[] array) {
        int[] next = new int[array.length];
        for (int index = 2; index < array.length; index++) {

            int left = 0, right = 1;

            while (right <= index - 1) {
                if (array[left] == (array[right])) {
                    left++;
                    next[index] = left;
                } else {
                    left = 0;
                }
                right++;
            }
        }
        return next;
    }

    public static int[] getNext(String pattern) {
        //初始化
        int[] next = new int[pattern.length()];
        int len = 0;
        for (int pos = 1; pos < pattern.length(); pos++) {
            //如果没有相同前后缀,向前回退
            while (len > 0 && pattern.charAt(len) != pattern.charAt(pos)) {
                len = next[len - 1];
            }
//如果有相同前后缀，len++
            if (pattern.charAt(len) == pattern.charAt(pos)) {
                len++;
            }
            next[pos] = len;
        }
        return next;
    }
}
