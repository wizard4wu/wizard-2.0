package com.wizard.data.hot100;

public class Hot24_234 {

    public static void main(String[] args) {

        ListNode end = new ListNode(1, null);
        ListNode s = new ListNode(2, end);
        ListNode z = new ListNode(2, s);
        ListNode head = new ListNode(1, z);
        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {

        //使用快慢指针对前一半做链表反转，然后遍历反转后的链表和剩下的一半进行比较；
        ListNode fastIndex = head;
        ListNode preNode = null;
        ListNode currentNode = head;

        while(null != fastIndex && null != fastIndex.next){
            fastIndex = fastIndex.next.next;
            ListNode nextNode = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = nextNode;
        }
        //对于奇数个节点的时候需要处理一下 往前移动一个
        if(null != fastIndex){
            currentNode = currentNode.next;
        }

        while(null != currentNode && null != preNode){
            if(currentNode.val != preNode.val){
                return false;
            }
            currentNode = currentNode.next;
            preNode = preNode.next;
        }
        return true;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
