package com.dev.wizard.solution.ifelse.util;



public class UtilDemo {

    public static void main(String[] args) {

        System.out.println(tryCatchExeception());
    }
    public static int tryCatchExeception(){
        int number = 19;
        try {
            return number + 5;
        }catch(Exception e){
            return 0;
        }finally {
            System.out.println("hhh");
            number ++;
        }
    }
}
