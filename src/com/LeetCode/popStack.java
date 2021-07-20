package com.LeetCode;

import java.util.Stack;

/**
 * @author leelixiangju
 * @date 2021/5/18 11:49
 */
public class popStack {
    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 4, 5};
        int[] output = new int[]{4, 3, 5, 1, 2};
        System.out.println(isPopList(input, output));
    }

    public static Boolean isPopList(int[] input, int[] output) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;
        while (i < input.length) {
            if (input[i] == output[j]) {
                i++;
                j++;
                continue;
            }
            if (!stack.empty() && stack.peek() == output[j]) {
                j++;
                stack.pop();
                continue;
            }
            stack.push(input[i++]);
        }
        for (; j < output.length; j++) {
            if (stack.empty() || stack.peek() != output[j]) {
                return false;
            }
            stack.pop();
        }
        return true;
    }
}
