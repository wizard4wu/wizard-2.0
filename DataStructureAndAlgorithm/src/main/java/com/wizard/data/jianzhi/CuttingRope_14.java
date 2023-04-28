package com.wizard.data.jianzhi;

/**
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 */

public class CuttingRope_14 {
    public static void main(String[] args) {

        System.out.println(cuttingRope(10));
    }

    public static int cuttingRope(int number) {
        if(2 == number) return 1;
        if(3 == number) return 2;
        int counter = 1;
        while (number > 4) {
            number = number - 3;
            counter = 3 * counter;
        }
        counter = number * counter;
        return counter;
    }
}
