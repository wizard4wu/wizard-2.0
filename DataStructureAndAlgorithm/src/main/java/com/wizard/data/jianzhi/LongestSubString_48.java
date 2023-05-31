package com.wizard.data.jianzhi;

import java.util.HashMap;
import java.util.Map;

public class LongestSubString_48 {

    public static void main(String[] args) {


        System.out.println(lengthOfLongestSubstring("au"));

    }

    public static int lengthOfLongestSubstring(String s) {

        int length = s.length();
        if(0 == length) return 0;
        Map<Character, Integer> indexMap = new HashMap<>(length);

        char[] chars = s.toCharArray();
        int maxLength = 1;
        int headIndex = 0;
        indexMap.put(chars[0], 0);
        int tempLength = 1;
        for(int index = 1; index < length; index ++){
            char tail = chars[index];
            if(indexMap.containsKey(tail)){
                Integer newIndex = indexMap.get(tail);
                if(newIndex >= headIndex){
                    headIndex = newIndex + 1;
                }
                tempLength = index - headIndex + 1;
            }else {
                tempLength ++;
            }
            indexMap.put(tail, index);
            if(maxLength < tempLength){
                maxLength = tempLength;
            }
        }
        return maxLength;
    }
    public static int test2(String s){
        int n = s.length();
        HashMap<Character, Integer> maphash = new HashMap<Character, Integer>();
        int head = 0, res = 0;
        for (int i = 0; i < n; i++) {
            if ( maphash.containsKey(s.charAt(i)) ) {
                head = Math.max(head, maphash.get(s.charAt(i)));
            }
            maphash.put(s.charAt(i), i + 1);
            res = Math.max(res, i - head + 1);
        }
        return res;
    }

}
