package com.wizard.data.leetcode;



import java.util.HashMap;

import java.util.Map;

public class LRUCache {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.getValue(2));
        lruCache.put(3, 3);
        System.out.println(lruCache.getValue(2));
        lruCache.put(4, 4);
        lruCache.put(5, 5);
        System.out.println(lruCache.getValue(2));
    }
    private final int capacity;
    private final Map<Integer, Node> cache;
    private final Node head;
    private final Node tail;


    public Map<Integer, Node> getCache() {
        return cache;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(-1, -1); //dummy node;
        this.tail = new Node(-1, -1); //dummy node;
        head.next = tail;
        tail.prev = head;
    }
    public void put(int key, int value){
        //检查是否存在
        //如果存在就更新
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.value = value;
            //move to header
            move2Head(node);
        }else{
            //检查如果超过容量 需要删除
            if(cache.size() >= capacity){
                removeTail();
            }
            Node node = new Node(key, value);
            cache.put(key, node);
            //添加到头部
            addNode(node);
        }
    }
    public int getValue(int key){
        Node node = cache.get(key);
        if(node == null){
            return -1;
        }
        move2Head(node);
        return node.value;
    }

    private void addNode(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void move2Head(Node node){
        removeNode(node);
        addNode(node);
    }
    private void removeTail(){
        Node tailNode = tail.prev;
        removeNode(tailNode);
        cache.remove(tailNode.key);
    }

    static class Node {
        int key;
        int value;
        Node next;
        Node prev;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
