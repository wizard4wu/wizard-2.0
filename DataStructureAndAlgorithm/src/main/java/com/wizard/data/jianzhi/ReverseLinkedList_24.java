package com.wizard.data.jianzhi;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class ReverseLinkedList_24 {

    public static void main(String[] args) {

       ListNode listNode = createNode(7);

       ListNode result = reverseList(listNode);
        System.out.println(result);
    }


    public static ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode currentNode = head;
        while (currentNode != null){
            //保存下一个节点
            ListNode temp = currentNode.next;
            currentNode.next = pre;
            pre = currentNode;
            currentNode = temp;
        }
        return pre;
    }

    public static ListNode createNode(int size){
        ListNode head = new ListNode(3);
        ListNode current = head;
        for(int i = 4; i < size; i++){
            current.next = new ListNode(i);
            current = current.next;
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
