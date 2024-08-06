package com.leetcode2022.March;

import java.util.HashSet;
import java.util.Set;

/**
 * @author leeixiangjun
 * @date 2022/3/21 12:03 下午
 */
public class March21 {
    Set<Integer> set = new HashSet<>();

    // 深度优先搜索+哈希表
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}
