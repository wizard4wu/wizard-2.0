package com.wizard.data.leetcode;

import java.util.ArrayList;
import java.util.List;

public class UglyNumber_264 {

    public static void main(String[] args) {
        int value = nthUglyNumber(5, 2, 11, 13);
        System.out.println(value);
    }

    public static int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int number4Two = 1;
        int number4Three = 1;
        int number4Five = 1;

        for(int index = 2; index <= n; index ++){
            int temp = Math.min(2 * dp[number4Two], Math.min(3 * dp[number4Three], 5 * dp[number4Five]));
            if(temp == dp[number4Two] * 2){
                number4Two ++;
            }
            if(temp == dp[number4Three] * 3){
                number4Three ++;
            }
            if(temp == dp[number4Five] * 5){
                number4Five ++;
            }
            dp[index] = temp;
        }
        return dp[n];
    }

    public static int nthUglyNumber(int n, int a, int b, int c) {

        int counterIndex4A = 1;
        int counterIndex4B = 1;
        int counterIndex4C = 1;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        for(int index = 2; index <= n; index ++){
            int temp = Math.min(a * dp[counterIndex4A], Math.min(b * dp[counterIndex4B], c * dp[counterIndex4C]));
            if(temp == a * dp[counterIndex4A]){
                counterIndex4A ++;
            }
            if(temp == b * dp[counterIndex4B]){
                counterIndex4B ++;
            }
            if(temp == c * dp[counterIndex4C]){
                counterIndex4C ++;
            }
            dp[index] = temp;
        }
        return dp[n];
    }
}
