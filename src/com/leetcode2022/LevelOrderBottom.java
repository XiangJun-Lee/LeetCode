package com.leetcode2022;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 */
public class LevelOrderBottom {
//    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//        List<List<Integer>> res = new ArrayList<>();
//        if (root==null){
//            return res;
//        }
//        Queue<TreeNode> nodes = new LinkedList();
//        nodes.offer(root);
//        while (!nodes.isEmpty()){
//            List<Integer> temp = new ArrayList<>();
//            int size = nodes.size();
//            for(int i=0;i<size;i++){
//                TreeNode node = nodes.poll();
//                temp.add(node.val);
//                if(node.left!=null){
//                    nodes.offer(node.left);
//                }
//                if(node.right!=null){
//                    nodes.offer(node.right);
//                }
//
//            }
//            res.add(0,temp);
//        }
//        return res;
//    }
//
//    @Test
//    public void test(){
//        int[] nums = new int[]{3,9,20,-1,-1,15,7};
//        CreateTree createTree = new CreateTree();
//        TreeNode root = createTree.createTree(nums);
//        System.out.println(levelOrderBottom(root));
//    }
}
