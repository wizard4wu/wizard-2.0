package com.wizard.data.leetcode;

public class Interview_3 {
    /***
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     * 示例 1：
     * 输入：strs = ["flower","flow","flight"] 输出："fl"
     * 示例 2：
     * 输入：strs = ["dog","racecar","car"] 输出："" 解释：输入不存在公共前缀。
     *
     * 提示：
     * 1 <= strs.length <= 200 0 <= strs[i].length <= 200 strs[i] 仅由小写英文字母组成
     ***/

    public static void main(String[] args) {
        String[] inputStringArray = {"flower","flowe","fliwet"};
        String result = intersection(inputStringArray);
        if("".equals(result)){
            System.out.println("空字符串");
        }
        System.out.println(result);
    }

    public static String intersection(String[] strs) {
        String firstString = strs[0];
        StringBuilder result = new StringBuilder("");
        boolean isBreak = false;
        for(int index = 0; index < firstString.length(); index++) {
            boolean flag = true;
            for(int arrayIndex = 1; arrayIndex < strs.length; arrayIndex++) {
                String value = strs[arrayIndex];
                if(index < value.length() && firstString.charAt(index) != value.charAt(index)) {
                    flag = false;
                    isBreak = true;
                }
            }
            if(flag) {
                result.append(firstString.charAt(index));
            }
            if(isBreak){
                break;
            }
        }
        return result.toString();
    }
}
