package com.LeetCode.May;

import com.LeetCode.TreeNode;
import com.LeetCode.TreeNodeUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leelixiangjun
 * @date 2022/5/1 15:32
 */

public class May01 {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> nums1 = new ArrayList<>();
        List<Integer> nums2 = new ArrayList<>();
        inorder(root1, nums1);
        inorder(root2, nums2);

        int index1 = 0, index2 = 0;
        List<Integer> ans = new ArrayList<>();
        while (true) {
            if (index1 == nums1.size()) {
                ans.addAll(nums2.subList(index2, nums2.size()));
                break;
            }
            if (index2 == nums2.size()) {
                ans.addAll(nums1.subList(index1, nums1.size()));
                break;
            }
            if (nums1.get(index1) < nums2.get(index2)) {
                ans.add(nums1.get(index1++));
            } else{
                ans.add(nums2.get(index2++));
            }
        }

        return ans;

    }

    private void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }


    @Test
    public void test() {
        TreeNode root1 = TreeNodeUtil.createTreeNode(new Integer[]{2,1,4});
        TreeNode root2 = TreeNodeUtil.createTreeNode(new Integer[]{1,0,3});
        System.out.println(getAllElements(root1, root2));
    }
}
