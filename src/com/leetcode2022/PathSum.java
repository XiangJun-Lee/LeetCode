package com.leetcode2022;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root!=null){
            nextPathSum(root,sum,res,new ArrayList<>(),0);
        }
        return res;
    }

    private void nextPathSum(TreeNode root, int sum, List<List<Integer>> res, ArrayList<Integer> list, int cur) {
        int rootVal = root.val;
        if(root.left==null&&root.right==null){
            if(cur+rootVal==sum){
                list.add(rootVal);
                res.add(new ArrayList<>(list));
                list.remove(list.size()-1);
            }
            return;
        }
        list.add(rootVal);
        if(root.left!=null){
            nextPathSum(root.left,sum,res,list,cur+rootVal);
        }
        if(root.right!=null){
            nextPathSum(root.right,sum,res,list,cur+rootVal);
        }
        list.remove(list.size()-1);
    }


    @Test
    public void test(){
        Integer[] nums = new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1};
        TreeNode root = TreeNodeUtil.createTreeNode(nums);
        System.out.println(pathSum(root, 22));
    }
}
