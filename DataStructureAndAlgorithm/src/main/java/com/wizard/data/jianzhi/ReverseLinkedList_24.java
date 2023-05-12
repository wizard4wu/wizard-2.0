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

//        ListNode listNode = createNode(7);
//        int[] result2 = reversePrint(listNode);
//        System.out.println(result2);
//        ListNode result = reverseList(listNode);
//        System.out.println(result);
//        ListNode result3 = deleteNode(createNode(7), 5);
//        System.out.println(result3);

        ListNode result4 = mergeTwoLists(createNode(5), createNode(7));
        System.out.println(result4);
    }


    public static ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode currentNode = head;
        while (currentNode != null) {
            //保存下一个节点
            ListNode temp = currentNode.next;
            currentNode.next = pre;
            pre = currentNode;
            currentNode = temp;
        }
        return pre;
    }

    public static ListNode createNode(int size) {
        ListNode head = new ListNode(3);
        ListNode current = head;
        for (int i = 4; i < size; i++) {
            current.next = new ListNode(i);
            current = current.next;
        }
        return head;
    }

    public static int[] reversePrint(ListNode head) {
        ListNode temp = head, currentNode = head;
        int length = 0;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        int[] result = new int[length];
        for (int index = length - 1; index >= 0; index--) {
            result[index] = currentNode.val;
            currentNode = currentNode.next;
        }
        return result;
    }
    public static ListNode deleteNode(ListNode head, int val) {

        if(val == head.val) return head.next;
        ListNode currentNode = head.next;
        ListNode preNode = head;

        while (currentNode != null){
            ListNode next = currentNode.next;
            int tempValue = currentNode.val;
            if(val == tempValue){
                preNode.next = next;
                break;
            }
            preNode = currentNode;
            currentNode = next;
        }
        return head;
    }

    public ListNode getKthFromEnd(ListNode head, int k) {

        ListNode result = head;
        ListNode current = head;
        while (k>=0){
            current = current.next;
            k --;
        }
        while (current != null){
            result = result.next;
            current = current.next;
        }
        return result;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0 );
        ListNode currentNode = head;
        while (null != l1 && null != l2){
            if(l1.val < l2.val){
                currentNode.next = new ListNode(l1.val);
                l1 = l1.next;
            }else {
                currentNode.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            currentNode = currentNode.next;
        }
        if(null != l1){
            while (null != l1){
                currentNode.next = new ListNode(l1.val);
                l1 = l1.next;
                currentNode = currentNode.next;
            }
        }
        if(null != l2){
            while (null != l2){
                currentNode.next = new ListNode(l2.val);
                l2 = l2.next;
                currentNode = currentNode.next;
            }
        }
            return head.next;
    }


    /**
     * 剑指 Offer 52. 两个链表的第一个公共节点
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        return null;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
