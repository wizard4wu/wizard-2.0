package com.wizard.data.leetcode;

/**
 * 3 ->   *
 *       * *
 *      * * *
 *
 * 5 ->      *
 *          * *
 *         * * *
 *        * * * *
 *       * * * * *
 *
 *  打印圣诞树  只有树冠没有树干
 */
public class PrintChristmasTree {
    public static void main(String[] args) {
        printTree(5);
    }
    private static void printTree(int height) {

        for(int highIndex = 1; highIndex <= height; highIndex++) {
            //打印空格
            for(int index = height - highIndex; index > 0; index--) {
                System.out.print(" ");
            }
            //打印星号
            for(int xingIndex = 1; xingIndex <= highIndex; xingIndex++) {
                System.out.print("*" + " ");
            }
            //换行
            System.out.println();
        }
    }
}
