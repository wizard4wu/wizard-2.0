package com.wizard.data.leetcode;

/**
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 */
public class TwoAdd_2 {

    public static void main(String[] args) {

        ListNode l1 = create(7);
        ListNode l2 = create(4);

        ListNode result = addTwoNumbers(l1, l2);
        System.out.println(result);
    }

    static ListNode create(int size) {
        ListNode result = null;
        ListNode l = null;
        for (int i = 0; i < size; i++) {

            if(result == null){
                result = new ListNode(9, null);
                l = result;
            }else {
                ListNode temp = new ListNode(9, null);
                l.next = temp;
                l = l.next;
            }
        }
        return result;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = null;
        int quotient = 0;
        ListNode temp = null;
        while (null != l1 || null != l2) {
            int l1Value = null != l1? l1.val:0;
            int l2Value = null != l2? l2.val:0;

            int sum = l1Value + l2Value;

            int remain = (sum + quotient) % 10;
            quotient = (sum + quotient) / 10;

            if (null == result) {
                result = new ListNode(remain);
                temp = result;
            } else {
                temp.next = new ListNode(remain);
                temp = temp.next;
            }
            l1 = null != l1? l1.next : null;
            l2 = null != l2? l2.next : null;
        }
            if(quotient !=0){
                temp.next = new ListNode(quotient);
            }
        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
