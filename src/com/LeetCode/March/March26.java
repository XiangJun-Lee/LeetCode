package com.LeetCode.March;

import java.util.Stack;

/**
 * @author Xiangjun_Lee
 * @date 2022/3/26 11:59
 */
public class March26 {

    public int calPoints(String[] ops) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (String op : ops) {
            switch (op) {
                case "D":
                    stack.push(stack.peek() * 2);
                    break;
                case "C":
                    stack.pop();
                    break;
                case "+":
                    Integer firstScore = stack.pop();
                    Integer secondScore = stack.peek();
                    stack.push(firstScore);
                    stack.push(firstScore + secondScore);
                    break;
                default:
                    stack.push(Integer.valueOf(op));
            }
        }

        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    private void calScore(String op) {
    }
}
