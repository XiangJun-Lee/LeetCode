import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LevelOrder {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while(!nodes.isEmpty()){
            int size = nodes.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node = nodes.poll();
                temp.add(node.val);

                if(node.left!=null){
                    nodes.offer(node.left);
                }
                if(node.right!=null){
                    nodes.offer(node.right);
                }
            }
            res.add(temp);
        }
        return res;
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        TreeNode left = root.left;
        left.left = new TreeNode(15);
        left.right = new TreeNode(7);
        System.out.println(levelOrder(root));

    }
}