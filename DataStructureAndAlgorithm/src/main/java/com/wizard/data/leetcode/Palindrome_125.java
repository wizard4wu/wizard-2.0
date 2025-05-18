package com.wizard.data.leetcode;

public class Palindrome_125 {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        isPalindrome(s);
    }

    public static boolean isPalindrome(String s) {
        //1.保留字符串，去除空格和，之类的
        //2.判断回文
        StringBuilder sb = new StringBuilder();

        for(int index = 0; index < s.length(); index ++){
            char charValue = Character.toLowerCase(s.charAt(index));
            if(charValue >= '0' && charValue <= '9'){
                sb.append(charValue);
            }
            if(charValue >= 'A' && charValue <= 'Z'){
                sb.append(Character.toLowerCase(charValue));
            }
            if(charValue >= 'a' && charValue <= 'z'){
                sb.append(charValue);
            }
        }
        String newString = sb.toString();

        int length = newString.length();

        if(length % 2 == 0){
            int leftIndex = length / 2 - 1;
            int rightIndex = length / 2;

            while(leftIndex >= 0 && rightIndex < newString.length()){
                if(newString.charAt(leftIndex) != newString.charAt(rightIndex)){
                    return false;
                }
                leftIndex --;
                rightIndex ++;
            }
        }else{
            int leftIndex = length / 2 - 1;
            int rightIndex = length / 2 + 1;
            while(leftIndex >= 0 && rightIndex < newString.length()){
                if(newString.charAt(leftIndex) != newString.charAt(rightIndex)){
                    return false;
                }
                leftIndex --;
                rightIndex ++;
            }
        }
        return true;
    }
}
