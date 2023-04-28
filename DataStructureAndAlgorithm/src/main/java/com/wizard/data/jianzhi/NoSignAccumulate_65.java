package com.wizard.data.jianzhi;

/**
 * 输入: a = 1, b = 1
 * 输出: 2
 *
 * a+b的结果等于a^b+(a&b)<<1
 */
public class NoSignAccumulate_65 {
    public static void main(String[] args) {

        int result = add(3, 5);
        System.out.println(result);
    }

    public static int add(int a, int b) {
        if(b == 0) return a;
        return add(a^b, (a&b) << 1);
    }
}
