package com.leetcode2025.february;

import java.util.HashMap;

/**
 * @author leelixiangjun
 * @date 2025/2/10 22:32
 */
public class LRUCache {

    private HashMap<Integer, Node> cache;

    private int capacity;

    private Node head;

    private Node tail;

    public static class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node() {

        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)){
            return -1;
        }
        Node node = cache.get(key);
        removeToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)){
            Node node = cache.get(key);
            node.value = value;
            removeToHead(node);
            return;
        }
        if (cache.size() == capacity){
            Node lastNode = removeLastNode();
            cache.remove(lastNode.key);
        }
        Node node = new Node(key,value);
        addNewNode(node);
        cache.put(node.key,node);
    }

    private Node removeLastNode() {
        Node lastNode = tail.prev;
        removeNode(lastNode);
        return lastNode;
    }

    private void addNewNode(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void removeToHead(Node node) {
        removeNode(node);
        addNewNode(node);
    }
}
