package com.leetcode2026.lru_cache_146;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private static class Node {
        int value;

        int key;

        Node pre;

        Node next;

        public Node() {

        }

        public Node(int key, int value) {
            this.value = value;
            this.key = key;
        }
    }

    private int capacity;
    private Node head;
    private Node tail;
    private Map<Integer, Node> nodeMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
        nodeMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = nodeMap.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(Node node) {
        node.pre = head;
        node.next = head.next;
        node.pre.next = node;
        node.next.pre = node;
    }

    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void put(int key, int value) {
        Node node = nodeMap.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
            return;
        }
        node = new Node(key, value);
        addToHead(node);
        nodeMap.put(key, node);
        if (nodeMap.size() > capacity) {
            Node tailNode = removeTail();
            nodeMap.remove(tailNode.key);
        }
    }

    private Node removeTail() {
        Node node = tail.pre;
        removeNode(node);
        return node;
    }
}
