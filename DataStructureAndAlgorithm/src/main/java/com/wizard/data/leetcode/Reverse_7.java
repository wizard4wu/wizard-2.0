package com.wizard.data.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Reverse_7 {


    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

    public  static  int reverse(int x) {

        int value = 0;
        while(x != 0){
            if(value > Integer.MAX_VALUE / 10 || value < Integer.MIN_VALUE / 10){
                return 0;
            }
            int a = x % 10;
            x = x/10;
            value = 10 * value + a;
        }
        Set<Integer> set = new HashSet();
        set.toArray(new Integer[0]);


        return value;
    }
}
