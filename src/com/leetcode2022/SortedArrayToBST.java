package com.leetcode2022;

import org.junit.Test;

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortTree(nums,0,nums.length-1);
    }

    private TreeNode sortTree(int[] nums, int start, int end) {
        if(start>end) return null;
        if(start==end){
            return new TreeNode(nums[start]);
        }
        int rootNum = start+(end-start)/2;
        TreeNode root = new TreeNode(nums[rootNum]);
        root.left = sortTree(nums,start,rootNum-1);
        root.right = sortTree(nums,rootNum+1,end);
        return root;
    }

    @Test
    public void test(){
        int[] nums = {-10,-3,0,5,9};
        TreeNode root = sortedArrayToBST(nums);
        System.out.println(root);
    }
}
