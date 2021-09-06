import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        if(root.left==null&&root.right==null){
            ans.add(root.val);
            return ans;
        }
        if(root.left!=null){
            ans.addAll(inorderTraversal(root.left));
        }
        ans.add(root.val);
        if(root.right!=null){
            ans.addAll(inorderTraversal(root.right));
        }
        return ans;
    }

    @Test
    public void test(){
        int[] nodes = {1,-1,2,3};
        CreateTree createTree = new CreateTree();
        TreeNode root = createTree.createTree(nodes);
        System.out.println(inorderTraversal(root));
    }
}
