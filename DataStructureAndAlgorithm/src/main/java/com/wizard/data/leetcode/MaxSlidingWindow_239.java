package com.wizard.data.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 最快的方法是用 单调队列！大概思路是：
 * 维护一个单调递减的双端队列（deque），队首永远是当前窗口的最大值。
 * 每次新进一个元素：
 * 把比它小的元素从队尾弹出（保持递减）。
 * 把新元素放到队尾。
 * 窗口超出时，如果最大值滑出窗口范围了，要弹出队首。
 */
public class MaxSlidingWindow_239 {

    public static void main(String[] args) {

        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(maxSlidingWindow(nums, k));

    }



    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k == 0) return new int[0];

        Deque<Integer> deque = new LinkedList<>();

        int[] resultArray = new int[nums.length - k + 1];
        for(int index = 0; index < nums.length; index++) {
            //1.如果队列的头部所在的index不在滑动窗口内，那么需要去掉
            if(!deque.isEmpty() && deque.peekFirst() <= index - k) {
                deque.removeFirst();
            }

            //2.在新的元素添加之前，需要对于队列中的元素和该元素比较，比这个元素小的全部删除，因为后面也不会用到；
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[index]) {
                deque.removeLast();
            }
            //注意：删除完后队列的首部可能存在，因为这个元素也不一定是这个滑动窗口的最大值，所以需要从队尾添加元素；
            deque.addLast(index);

            int resultArrayIndex = index - k + 1;
            if(resultArrayIndex >= 0) {
                resultArray[resultArrayIndex] = nums[deque.peekFirst()];
            }
        }
        return resultArray;
    }
}
