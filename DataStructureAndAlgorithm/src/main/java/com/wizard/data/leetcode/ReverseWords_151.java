package com.wizard.data.leetcode;

import java.lang.reflect.Array;

public class ReverseWords_151 {
    public static void main(String[] args) {

       String a = reverseWords("  hello world  ");
        System.out.println(a);
    }


    public static String reverseWords(String s) {
        StringBuilder stringBuffer = new StringBuilder();
        String[] string = s.split(" ");
        for (int index = string.length - 1; index >= 0; index --){
            String value = string[index];
            if(string[index].length() != 0){
                stringBuffer.append(value).append(" ");
            }
        }
        return stringBuffer.toString().trim();
    }
}
