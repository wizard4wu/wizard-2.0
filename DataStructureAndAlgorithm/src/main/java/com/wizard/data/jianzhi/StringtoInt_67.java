package com.wizard.data.jianzhi;

public class StringtoInt_67 {

    public static void main(String[] args) {

        System.out.println(strToInt("4193 with words"));
    }

    public static int strToInt(String str) {
        long value = 0;
        int sign = 1;
        int signIndex = 0;
        for(int index = 0; index < str.length(); index ++){
            if(' ' == str.charAt(index)){

                continue;
            }
            if('+' != str.charAt(index) && '-' != str.charAt(index) && ('0' > str.charAt(index) || '9' < str.charAt(index))){
                return 0;
            }
            if(signIndex == 0 && '-' == str.charAt(index)){
                sign = -1;
            }
            signIndex ++;
            if('0' <= str.charAt(index) && '9' >= str.charAt(index)){
                value = 10 * value + str.charAt(index) - 48;
            }else {
                if(value != 0){
                    break;
                }
            }
        }
        value = sign * value;
        value = Math.min(value, Integer.MAX_VALUE);
        value = Math.max(value, Integer.MIN_VALUE);
        return (int)value;
    }
}
