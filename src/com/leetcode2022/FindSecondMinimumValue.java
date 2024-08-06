package com.leetcode2022;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leelixiangjun
 * @date 2021/7/27 11:26
 */
public class FindSecondMinimumValue {
    public int findSecondMinimumValue(TreeNode root) {
        if (root.left == null && root.right == null) {
            return -1;
        }
        int result = Integer.MAX_VALUE;
        boolean hasSecond = false;
        int min = root.val;
        boolean stop = false;
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        while (nodes.size() > 0 && !stop) {
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.get(0);
                nodes.remove(0);
                if (node.val == min && node.left == null && node.right == null) {
                    stop = true;
                }
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
                if (node.val > min && node.val <= result) {
                    result = node.val;
                    hasSecond = true;
                }
            }
        }
        return hasSecond ? result : -1;
    }
}
