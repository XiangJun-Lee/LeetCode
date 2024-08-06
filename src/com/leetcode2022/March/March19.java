package com.leetcode2022.March;

/**
 * @author leeixiangjun
 * @date 2022/3/19 11:55 上午
 */
public class March19 {
    StringBuilder ans = new StringBuilder();

    public String tree2str(TreeNode root) {
        if (root == null) {
            return ans.toString();
        }
        ans.append(root.val);
        if (root.left == null && root.right == null) {
            return ans.toString();
        }
        ans.append("(");
        tree2str(root.left);
        ans.append(")");
        if (root.right != null) {
            ans.append("(");
            tree2str(root.right);
            ans.append(")");
        }
        return ans.toString();
    }

    public String tree2strOfficial(TreeNode root) {
        if (root == null) {
            return "";
        }
        if (root.left == null && root.right == null) {
            return Integer.toString(root.val);
        }
        if (root.right == null) {
            return new StringBuffer().append(root.val).append("(").append(tree2strOfficial(root.left)).append(")").toString();
        }
        return new StringBuffer().append(root.val).append("(").append(tree2strOfficial(root.left)).append(")(").append(tree2strOfficial(root.right)).append(")").toString();
    }
}
