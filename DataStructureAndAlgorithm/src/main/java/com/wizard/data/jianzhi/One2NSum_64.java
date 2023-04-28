package com.wizard.data.jianzhi;

public class One2NSum_64 {
    public static void main(String[] args) {

        int sum = sum(9);
        System.out.println(sum);
    }

    //递归
    public static int sum(int number){
        if(number == 1) return 1;
        return sum(number - 1) + number;
    }
    //循环
    public static int sum2(int number){

        int result = 0;
        for (int value = 1; value <= number; value++){
            result += value;
        }
        return result;
    }
}
