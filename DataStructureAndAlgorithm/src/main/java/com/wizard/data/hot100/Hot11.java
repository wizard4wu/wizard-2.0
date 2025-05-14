package com.wizard.data.hot100;

//算法题
//1.给定一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//示例：
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
//要求 1.考虑边界情况  2.要求一次遍历实现
public class Hot11 {

    public static void main(String[] args) {

        LinkNode node5 = new LinkNode(5, null);
        LinkNode node4 = new LinkNode(4, node5);
        LinkNode node3 = new LinkNode(3, node4);
        LinkNode node2 = new LinkNode(2, node3);
        LinkNode node1 = new LinkNode(1, node2);

        LinkNode head = deleteLinked(node1, 5);

        System.out.println("");
    }

    public static LinkNode deleteLinked(LinkNode head,int num) {

        LinkNode dummy = new LinkNode(0, head);
        LinkNode fastIndex = dummy;
        LinkNode slowIndex = dummy;
        for(int index = 0; index <= num; index++) {
            fastIndex = fastIndex.next;
        }
        while(null != fastIndex){
            slowIndex = slowIndex.next;
            fastIndex = fastIndex.next;
        }
        slowIndex.next = slowIndex.next.next;
        return dummy.next;
    }

    static class LinkNode{
        LinkNode(int value, LinkNode next) {
            this.value = value;
            this.next = next;
        }
        private LinkNode next;
        private int value;
    }
}
