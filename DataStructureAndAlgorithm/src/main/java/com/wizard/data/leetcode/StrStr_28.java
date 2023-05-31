package com.wizard.data.leetcode;

import java.util.Arrays;

public class StrStr_28 {

    public static void main(String[] args) {
//        "adcadcaddcadde"
//        "adcadde"
        System.out.println(strStr("adcadcaddcadde", "adcadde"));
    }

    public static int strStr(String haystack, String needle) {

        int[] next = getNext(needle);
        int j = 0;
        for(int index = 0; index < haystack.length(); index ++){

            while (j > 0 && haystack.charAt(index) != needle.charAt(j)){
                j = next[j];
            }
            if(haystack.charAt(index) == needle.charAt(j)){
                j ++;
            }
            if(j == needle.length()){
                return index - needle.length() + 1;
            }
        }
        return -1;
    }

    public static int[] getNext(String needle){
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
    public static int[] getNewNext(String needle){

        int[] next = new int[needle.length()];
        for(int index = 2; index < needle.length(); index ++){
            int newIndex = index;
            while(newIndex > 1){
                if(needle.substring(0, newIndex - 1).equals(needle.substring(index - newIndex + 1, index))){
                    next[index] = newIndex - 1;
                    break;
                }
               newIndex --;
            }
        }
        return next;
    }
}
