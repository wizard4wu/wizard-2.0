package com.wizard.data.leetcode;

public class KMP {
    public static void main(String[] args) {


        int result = check("abababcabcabce", "aabaaac");
        System.out.println(result);
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
}
