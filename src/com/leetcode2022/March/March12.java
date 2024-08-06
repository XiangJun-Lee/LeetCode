package com.leetcode2022.March;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leeixiangjun
 * @date 2022/3/12 11:41 上午
 */
public class March12 {
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList();
        // 递归解后序遍历，深度优先遍历
        postorder(root, ans);
        return ans;
    }

    private void postorder(Node root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        for (Node child : root.children) {
            postorder(child, ans);
        }
        ans.add(root.val);
    }
}
