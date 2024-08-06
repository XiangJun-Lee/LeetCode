package com.leetcode2022;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> subSum =new LinkedList<>();
        nodes.offer(root);
        subSum.offer(root.val);
        while (!nodes.isEmpty()){
            TreeNode node = nodes.poll();
            int temp = subSum.poll();
            if(node.left==null&&node.right==null){
                if (temp==sum) return true;
                continue;
            }
            if(node.left!=null){
                nodes.offer(node.left);
                subSum.offer(node.left.val+temp);
            }
            if(node.right!=null){
                nodes.offer(node.right);
                subSum.offer(node.right.val+temp);
            }
        }
        return false;
    }
}
