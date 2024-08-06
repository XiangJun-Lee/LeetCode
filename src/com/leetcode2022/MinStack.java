package com.leetcode2022;

import java.util.ArrayList;

class MinStack {
    private ArrayList<Integer> stack;
    private ArrayList<Integer> minNums;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayList<>();
        minNums = new ArrayList<>();
    }

    public void push(int x) {
        if(minNums.isEmpty()){
            minNums.add(x);
        }else {
            int min = minNums.get(minNums.size()-1);
            if(min>x) minNums.add(x);
        }
        stack.add(x);

    }

    public void pop() {
        int top = stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        if(top==minNums.get(minNums.size()-1)) minNums.remove(minNums.size()-1);
    }

    public int top() {
        return stack.get(stack.size()-1);
    }

    public int getMin() {
        return minNums.get(minNums.size()-1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */