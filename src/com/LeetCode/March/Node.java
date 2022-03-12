package com.LeetCode.March;

import java.util.List;

/**
 * @author leeixiangjun
 * @date 2022/3/12 11:43 上午
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
