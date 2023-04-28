package com.wizard.data.jianzhi;

/**
 * 输入：n = 11 (控制台输入 00000000000000000000000000001011)
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 */
public class OneNumberInBinary_15 {
    public static void main(String[] args) {
        int resutl = hammingWeight(13);
        System.out.println(resutl);
    }

    public static int hammingWeight(int n) {

        int index = 0;
        int counter = 0;
        while (index <= 32) {
            //注意负数
            if ((n & (1 << index)) != 0) {
                counter++;
            }
            index++;
        }
        return counter;
    }
}
