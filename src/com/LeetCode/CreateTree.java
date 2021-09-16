package com.LeetCode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class CreateTree {
    public TreeNode createTree(int[] nodes) {
        int len = nodes.length;
        if (len == 0) {
            return null;
        }
        TreeNode root = new TreeNode(nodes[0]);
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(root);
        int i = 1;
        while (!treeNodes.isEmpty() && i < len) {
            TreeNode tempNodes = treeNodes.poll();
            if (tempNodes == null) {
                continue;
            }
            int val = nodes[i];
            tempNodes.left = new TreeNode(val);
            if (val == -1) tempNodes.left = null;
            i++;
            if (i == len) break;
            val = nodes[i];
            tempNodes.right = new TreeNode(val);
            if (val == -1) tempNodes.right = null;
            i++;
            treeNodes.offer(tempNodes.left);
            treeNodes.offer(tempNodes.right);
        }
        return root;
    }

    @Test
    public void test() {
        int[] nodes = {3, 5, -1, 6};
        createTree(nodes);
    }
}
