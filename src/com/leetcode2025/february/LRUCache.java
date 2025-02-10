package com.leetcode2025.february;

import java.util.HashMap;

/**
 * @author leelixiangjun
 * @date 2025/2/10 22:32
 */
public class LRUCache {

    private HashMap<Integer, Node> cache;

    private int size;

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
        this.size = 0;
        cache = new HashMap<>(capacity);
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
        } else {
            if (size == capacity) {
                Node lastNode = removeLastNode();
                cache.remove(lastNode.key);
                size--;
            }
            Node newNode = new Node(key, value);
            addNewNode(newNode);
            cache.put(key, node);
            size++;
        }

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

    private void moveToHead(Node node) {
        removeNode(node);
        addNewNode(node);
    }
}
