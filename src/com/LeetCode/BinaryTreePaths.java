import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-paths/
 */
public class BinaryTreePaths {
    public static List<String> ans;

    public List<String> binaryTreePaths(TreeNode root) {
        ans = new ArrayList<>();
        if (root != null) {
            treePath(root, new StringBuilder());
        }
        return ans;
    }

    private void treePath(TreeNode root, StringBuilder str) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            ans.add(sb.toString());
            return;
        }
        sb.append("->");
        if (root.left != null) {
            treePath(root.left, sb);
        }
        if (root.right != null) {
            treePath(root.right, sb);
        }
    }

    @Test
    public void test() {
        CreateTree createTree = new CreateTree();
        int[] nums = {1, 2, 3, -1, 5};
        TreeNode root = createTree.createTree(nums);
        System.out.println(binaryTreePaths(root));
    }
}
