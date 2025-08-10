package com.wizard.data.interview;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。
 *
 * 比如：k = 1
 *
 *   3
 *   / \
 * 1   4
 * /  \
 * 0  2
 *
 * 结果为 1
 */
public class Temp1 {
    private static int k = 3;
    private static int res;
    public static void main(String[] args) {
        TreeNode value0 = new TreeNode(0, null, null);
        TreeNode value2 = new TreeNode(2, null, null);
        TreeNode value1 = new TreeNode(1, value0, value2);
        TreeNode value4 = new TreeNode(4, null, null);
        TreeNode root = new TreeNode(3, value1, value4);
        inOrder(root);
        System.out.println(res);

    }

    private static void inOrder(TreeNode root) {
        if (root == null) {return;}
        inOrder(root.left);
        if(--k == 0) {
            res = root.val;
            return;
        }
        inOrder(root.right);
    }


    public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;

         public TreeNode(int val, TreeNode lt, TreeNode rt) {
             this.val = val;
             this.left = lt;
             this.right = rt;
         }
    }
}
