package com.wizard.data.hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 */
public class Hot8 {

    public static void main(String[] args) {
        Hot8 hot8 = new Hot8();

        final String s = "pwwkew";

        int max = hot8.lengthOfLongestSubstring(s);
        System.out.println(max);
    }
    public int lengthOfLongestSubstring(String s) {
        int longestSubStringLength = 0;
        Set<Character> characterSet = new HashSet<>();
        int leftIndex = 0;
        for (int index = 0; index < s.length(); index++) {
            char currentChar = s.charAt(index);
            while(characterSet.contains(currentChar)) {
                characterSet.remove(s.charAt(leftIndex ++));
            }
            characterSet.add(s.charAt(index));
            longestSubStringLength = Math.max(longestSubStringLength, characterSet.size());
        }
        return longestSubStringLength;
    }
}
