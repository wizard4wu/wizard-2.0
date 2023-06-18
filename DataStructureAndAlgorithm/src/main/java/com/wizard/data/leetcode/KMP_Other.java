package com.wizard.data.leetcode;

import java.util.Arrays;

public class KMP_Other {
    public static void main(String[] args) {
        //System.out.println(strstr("abababcabcabce", "aabaaac"));
        Arrays.stream(getNext("ABABABD")).forEach(System.out::print);
    }

    public static int strstr(String haystack, String needle) {
//如果是空串,返回0
        if (needle.length() == 0) {
            return 0;
        }
        int[] next = new int[needle.length()]; //获取neXt数组
        getNext(needle, next); //初始化指针
        int i = 0;
        for (int j = 0; j < haystack.length(); j++) {
//如果不相等.进行回溯
            while (i > 0 && haystack.charAt(j) != needle.charAt(i)) {
                i = next[i - 1];
            }
//如果相等,i++
            if (haystack.charAt(j) == needle.charAt(i)) {
                i++;
//如果1到了最后一位,说明匹配到了 if(i==needle.length()){
                return j - needle.length() + 1;
            }
        }
        return -1;
    }

    public static void getNext(String pattern, int[] next) {
        //初始化
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
    }

    public static int[] getNext(String pattern){
        int[] next = new int[pattern.length()];
        int leftIndex = 0;
        for(int rightIndex = 1; rightIndex < pattern.length(); rightIndex ++){
            while(leftIndex > 0 && pattern.charAt(leftIndex) != pattern.charAt(rightIndex)){
                leftIndex = next [leftIndex - 1];
            }
            if(pattern.charAt(leftIndex) == pattern.charAt(rightIndex)){
                leftIndex ++;
            }
            next[rightIndex] = leftIndex;
        }
        return next;
    }
}

