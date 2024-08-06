package com.leetcode2022;

public class Nodes {
    private int val;
    private Nodes next;

    public Nodes(int val){
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Nodes getNext() {
        return next;
    }

    public void setNext(Nodes next) {
        this.next = next;
    }
}
