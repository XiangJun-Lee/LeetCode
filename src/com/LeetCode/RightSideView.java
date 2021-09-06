package com.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class RightSideView {
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        if(root!=null&&(root.right==null&&root.left==null)){
            result.add(root.val);
            return result;
        }
        List<TreeNode> treeNodeList = new ArrayList<>();
        treeNodeList.add(root);
        while (treeNodeList.size()>0){
            int size = treeNodeList.size();
            result.add(treeNodeList.get(0).val);
            for(int i=0;i<size;i++){
                TreeNode treeNode = treeNodeList.get(0);
                treeNodeList.remove(0);
                if(treeNode.right!=null){
                    treeNodeList.add(treeNode.right);
                }
                if(treeNode.left!=null){
                    treeNodeList.add(treeNode.left);
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        TreeNode left = root.left;
        TreeNode right = root.right;
        left.right = new TreeNode(5);
        right.right = new TreeNode(4);
        System.out.println(rightSideView(root));
    }

}
