package com.wizard.data.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class isValid_22 {

    public static void main(String[] args) {

        System.out.println(isValid("()[}{}"));
    }

    public static boolean isValid(String s) {

        int length = s.length();
        if (length % 2 != 0) {
            return false;
        }
        Map<Character, Character> map = new HashMap(3);
        map.put('(', ')');
        map.put('[', ']');
        map.put('{','}');


        Stack<Character> stack = new Stack<>();

        char[] charArray = s.toCharArray();
        for(int index = 0; index < length; index ++){
            if(stack.size() == 0){
                stack.push(charArray[index]);
            }else {
                Character character = stack.peek();
                Character left = map.get(character);
                if(null == left){
                    return false;
                }
                if(left == charArray[index]){
                    stack.pop();
                }else {
                    stack.push(charArray[index]);
                }
            }
        }
        return stack.size() == 0;
    }
}
