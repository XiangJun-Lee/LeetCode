package com.leetcode2022;

class Queue {
    private int size;
    private int[] data;
    private int front, rear;

    public Queue(int size) {
        this.size = size;
        data = new int[size];
        front = 0; rear = 0;
    }
}