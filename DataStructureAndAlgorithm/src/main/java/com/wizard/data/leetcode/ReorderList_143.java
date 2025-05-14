package com.wizard.data.leetcode;

public class ReorderList_143 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        reorderList(head);
    }

    //1.链表切半
    //2.右侧链表反转；
    //交叉组装链表
    public static void reorderList(ListNode head) {
        ListNode slowNode = head;
        ListNode fastNode = head;

        while(fastNode != null && fastNode.next != null){
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = slowNode.next;
        //切断链表
        slowNode.next = null;

        //反转后半节链表
        ListNode pre = null;
        ListNode current = dummy.next;
        while(current != null){
            ListNode tempNode = current.next;
            current.next = pre;
            pre = current;
            current = tempNode;
        }
        ListNode after = pre;

        ListNode currentNode4Head = head;
        while(currentNode4Head != null && after != null){
            ListNode tempNode = currentNode4Head.next;
            currentNode4Head.next = after;
            after.next = tempNode;
            currentNode4Head = currentNode4Head.next;
            after = after.next;
        }
    }

    private static class ListNode {
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
