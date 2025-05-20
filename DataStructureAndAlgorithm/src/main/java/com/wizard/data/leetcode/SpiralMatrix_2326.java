package com.wizard.data.leetcode;

public class SpiralMatrix_2326 {

    public static void main(String[] args) {

        int m = 1;
        int n = 4;
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        spiralMatrix(m, n, head);
    }

    public static int[][] spiralMatrix(int m, int n, ListNode head) {
        int topIndex = 0;
        int bottomIndex = m - 1;
        int leftIndex = 0;
        int rightIndex = n - 1;


        int[][] resultArray = new int[m][n];


        int counterIndex = 1;
        ListNode currentNode = head;
        while (counterIndex <= n * m) {
            //从左到右；
            int tempLeftIndex = leftIndex;
            while (topIndex <= bottomIndex && tempLeftIndex <= rightIndex) {
                resultArray[topIndex][tempLeftIndex] = -1;
                if (currentNode != null) {
                    resultArray[topIndex][tempLeftIndex] = currentNode.val;
                    currentNode = currentNode.next;
                }

                tempLeftIndex++;
                counterIndex++;

            }
            topIndex++;

            //从上到下；
            int tempTopIndex = topIndex;
            while (leftIndex <= rightIndex && tempTopIndex <= bottomIndex) {
                resultArray[tempTopIndex][rightIndex] = -1;
                if (currentNode != null) {
                    resultArray[tempTopIndex][rightIndex] = currentNode.val;
                    currentNode = currentNode.next;
                }
                tempTopIndex++;
                counterIndex++;
            }
            rightIndex--;


            //从右到左；
            int tempRightIndex = rightIndex;
            while (topIndex <= bottomIndex && tempRightIndex >= leftIndex) {
                resultArray[bottomIndex][tempRightIndex] = -1;
                if (currentNode != null) {
                    resultArray[bottomIndex][tempRightIndex] = currentNode.val;
                    currentNode = currentNode.next;
                }
                tempRightIndex--;
                counterIndex++;
            }
            bottomIndex--;

            //从下到上；
            int tempBottomIndex = bottomIndex;
            while (leftIndex <= rightIndex && tempBottomIndex >= topIndex) {
                resultArray[tempBottomIndex][leftIndex] = -1;
                if (currentNode != null) {
                    resultArray[tempBottomIndex][leftIndex] = currentNode.val;
                    currentNode = currentNode.next;
                }
                tempBottomIndex--;
                counterIndex++;
            }
            leftIndex++;
        }
        return resultArray;
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
