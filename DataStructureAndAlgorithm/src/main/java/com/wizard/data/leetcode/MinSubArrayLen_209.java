package com.wizard.data.leetcode;

public class MinSubArrayLen_209 {

    public static void main(String[] args) {

    }
    public int minSubArrayLen(int target, int[] nums) {
        //滑动窗口解决
        //窗口大小指针
        int l=0;
        int r=0;
        //记录窗口内的值的大小
        int sum=nums[0];
        //记录窗口元素最短长度
        int len=Integer.MAX_VALUE;
        while(l<=r){
            if(sum>=target){//窗口内元素符合条件，记录窗口大小，移动窗口
                len=Math.min(len,r-l+1);//记录窗口元素大小
                sum=sum-nums[l];
                l++;
            }else{//扩大窗口
                if(++r>nums.length-1)break;
                sum+=nums[r];
            }

        }
        return len==Integer.MAX_VALUE ? 0 : len;
    }
}
