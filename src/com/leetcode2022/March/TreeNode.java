package com.leetcode2022.March;

/**
 * @author leeixiangjun
 * @date 2022/3/19 11:56 上午
 */
public class TreeNode {
    int val;
    TreeNode left;

    TreeNode right;


    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }


    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
