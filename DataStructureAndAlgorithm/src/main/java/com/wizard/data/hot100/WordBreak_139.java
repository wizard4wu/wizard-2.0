package com.wizard.data.hot100;

import java.util.List;

public class WordBreak_139 {

    public static void main(String[] args) {

    }

    /**
     * 根据一个dp数组来判断进行动态规划
     * 1.对每个位置 i，遍历前面的位置 j（0 <= j < i）；
     * 2.判断 dp[j] 是否为 true，且 s[j:i] 是否在字典中；
     * 3.如果满足条件，则 dp[i] = true，跳出循环
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; //因为空字符串一定是可以分割的

        for(int index = 1; index < s.length(); index++) {
            for(int innerIndex = 0; innerIndex < index; innerIndex++) {
                if(dp[innerIndex] && wordDict.contains(s.substring(innerIndex, index))) {
                    dp[index] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
