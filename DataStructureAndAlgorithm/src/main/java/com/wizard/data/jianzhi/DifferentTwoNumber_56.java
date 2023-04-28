package com.wizard.data.jianzhi;

/**
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 */
public class DifferentTwoNumber_56 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,5,2};
        int[] result = singleNumbers(nums);
        System.out.println(result.toString());
    }

    //使用位的异或运算， 因为相同的数字异或后结果肯定为0

    /**
     * 1.将整个数据进行异或运算；
     * 2.异或运算后的结果找到第一个不为0的为数;
     * 3.例如第3位不为0 则为0100；
     * 4.根据该数对数组分成两组，因为该数一定可以将两个不同的数分开；
     */
    public static int[] singleNumbers(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        //获取步骤3中的值
        int temp = 1;
        while ((temp & result) <= 0) {
            temp = temp << 1;
        }
        int numOne = 0;
        int numTwo = 0;
        for (int num : nums) {
            if ((temp & num) > 0) {
                numOne ^= num;
            } else {
                numTwo ^= num;
            }
        }
        return new int[]{numOne, numTwo};
    }

}
