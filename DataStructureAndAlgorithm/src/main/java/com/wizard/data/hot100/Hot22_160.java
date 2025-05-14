package com.wizard.data.hot100;

public class Hot22_160 {

    public static void main(String[] args) {

        ListNode e = new ListNode(5, null);
        ListNode f = new ListNode(4, e);
        ListNode g = new ListNode(8, f);


        ListNode h = new ListNode(8, g);
        ListNode i = new ListNode(64, h);


        ListNode j = new ListNode(77, g);
        ListNode k = new ListNode(97, j);
        ListNode l = new ListNode(98, k);

        getIntersectionNode(l, i);



    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode currentNodeA = headA;
        ListNode currentNodeB = headB;

        while (currentNodeA != currentNodeB) {
            currentNodeA = null != currentNodeA ? currentNodeA.next : headB;
            currentNodeB = null != currentNodeB ? currentNodeB.next : headA;
        }
        return currentNodeB;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x, ListNode next) {
            this.val = x;
            this.next = next;
        }
    }
}
