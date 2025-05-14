package com.wizard.data.hot100;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Hot35_146 {

    public static void main(String[] args) {

    }

    class LRUCache {
        private HashMap<Integer, LinkedNode> cache;
        private LinkedNode head;
        private LinkedNode tail;
        private int capacity;
        private int size;


        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            LinkedNode linkedNode = cache.get(key);
            if(null == linkedNode) {
                return -1;
            }
            moveToHead(linkedNode);
            return linkedNode.value;
        }

        public void put(int key, int value) {
            LinkedNode linkedNode = cache.get(key);
            if(null == linkedNode) {
                linkedNode = new LinkedNode(key, value);
                cache.put(key, linkedNode);
                addToHead(linkedNode);
                size ++;
                if(size > capacity) {
                    //删除双向链表中的node
                    LinkedNode node = removeTail();
                    //删除map中的node
                    cache.remove(node.key);
                    size --;
                }
            }else{
                //如果key存在就更新value，同时将node移动到头部；
                linkedNode.value = value;
                moveToHead(linkedNode);
            }
        }


        private void addToHead(LinkedNode node){
            LinkedNode tempNode = head.next;
            head.next = node;
            node.pre = head;
            node.next = tempNode;
            tempNode.pre = node;
        }
        private LinkedNode removeNode(LinkedNode node){
            LinkedNode preNode = node.pre;
            preNode.next = node.next;
            node.next.pre = preNode;
            return node;
        }

        //for update node
        private void moveToHead(LinkedNode node){
            removeNode(node);
            addToHead(node);
        }

        private LinkedNode removeTail(){
            LinkedNode preNode = tail.pre;
            removeNode(preNode);
            return preNode;
        }

    }
    class LinkedNode{

        private Integer key;
        private Integer value;

        private LinkedNode pre;
        private LinkedNode next;

        public LinkedNode(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }


}
