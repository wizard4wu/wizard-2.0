package com.wizard.data.leetcode;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 */
public class LongestPalindrome_5 {


    public static void main(String[] args) {

        System.out.println(longestPalindrome2("babad"));
    }

    public static String longestPalindrome2(String s){
        int maxLength = 0;
        int maxStartIndex = 0;
        for(int index = 0; index < s.length(); index ++){
            int left = index;
            int right = index;
            int length = 0;
            //往左直接相同
            while(left - 1 >= 0 && s.charAt(left - 1) == s.charAt(index)){
                left --;
                length ++;
            }
            //往右直接相同；
            while(right + 1 < s.length() && s.charAt(right + 1) == s.charAt(index)){
                right ++;
                length ++;
            }
            //两边同时扩展相同
            while (left - 1 >= 0 && right + 1 < s.length() && s.charAt(right + 1) == s.charAt( left - 1)){
                //由于是两边扩展 所以长度加2；
                length = length + 2;
                right ++;
                left --;
            }

            if(maxLength < length){
                maxLength = length;
                maxStartIndex = left;
            }
        }
        return s.substring(maxStartIndex, maxStartIndex + maxLength + 1);
    }


    public static String longestPalindrome(String s) {
        if(1 == s.length()) return s;
        if(2 == s.length() && s.charAt(0) == s.charAt(1)) return s;

        char[] charArray = s.toCharArray();
        int length = charArray.length;
        String maxString = s.substring(0, 1);
        for(int index = 1; index < length; index++){
            int temp = 1;
            String leftString = charArray[index - 1] == charArray[index]? s.substring(index -1, index + 1) : "";
            String rightString = index < length - 1 && charArray[index] == charArray[index + 1]? s.substring(index, index + 2) : "";
            String middleString = "";
            boolean leftFlag = true;
            boolean rightFlag = true;
            boolean middleFlag = true;
            int max = Math.min(index, length - index - 1);
            while(index >= temp && temp <= max){
                //偶数向左
                if(0 != leftString.length() && leftFlag){
                    int leftIndex = index - 1 - temp;
                    if(leftIndex >= 0 && charArray[leftIndex] == charArray[index + temp]){
                        leftString = s.substring(leftIndex, index + temp + 1);
                    }else {
                        leftFlag = false;
                    }
                }
                //偶数向右
                if(rightString.length() != 0 && rightFlag){
                    int rightIndex = index + 1 + temp;
                    if(rightIndex < length && charArray[rightIndex] == charArray[index + temp]){
                        rightString = s.substring(index + temp, rightIndex + 1);
                    }else {
                        rightFlag = false;
                    }
                }
                //奇数两边
                if(charArray[index - temp] == charArray[index + temp] && middleFlag){
                    middleString = s.substring(index-temp, index + temp + 1);
                }else {
                    middleFlag = false;
                }
                if(!leftFlag && !rightFlag && !middleFlag){
                    break;
                }
                temp ++;
            }

            String tempMaxString = middleString.length() > leftString.length() ? middleString.length() > rightString.length()? middleString:rightString : leftString.length() > rightString.length()? leftString:rightString;
            if(maxString.length() < tempMaxString.length()){
                maxString = tempMaxString;
            }
        }
        return maxString;
    }
}
