package com.wizard.data.leetcode;

public class ReversLinkedList2_92 {
    public static void main(String[] args) {

        ListNode head = reverseBetween(createListNode(2), 1, 2);
        System.out.println(head);
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode fake = new ListNode(-1, head);
        ListNode pre = fake;
        for(int index = 0; index < left - 1; index++){
           pre = pre.next;
        }
        ListNode current = pre.next;
        ListNode next;
        while (left < right){
            next = current.next;
            ListNode temp = pre.next;
            pre.next = next;
            current.next = next.next;
            next.next = temp;
            left ++;
        }

        return fake.next;
    }

public static class ListNode {
        int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

 public static ListNode createListNode(int value){
        ListNode head = new ListNode(0);
        ListNode current = head;
        for(int index = 1; index < value; index++){
            current.next = new ListNode(index);
            current = current.next;
        }
        return head;
 }

}
