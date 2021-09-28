package com.LeetCode;

import java.util.HashMap;

/**
 * @author leelixiangjun
 * @date 2021/9/28 14:57
 * @link https://leetcode-cn.com/problems/path-sum-iii/
 */
public class pathSum3 {
    /**
     * key是前缀和, value是前缀和为key的节点数
     */
    public static HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
    public static int target = 0;

    public int pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        // root节点的前缀和为0，进行初始化。
        prefixSumCount.put(0, 1);
        return recursionPathSum(root, 0);
    }

    /**
     * 前缀和的递归回溯思路
     * 从当前节点反推到根节点，有且仅有一条路径，因为这是一棵树
     * 如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
     * 所以前缀和对于当前路径来说是唯一的，当前记录的前缀和，在回溯结束，回到本层时去除，保证其不影响其他分支的结果
     * @param node 树节点
     * @param currSum 当前路径和
     */
    private int recursionPathSum(TreeNode node, int currSum) {
        // 递归终止条件
        if (node == null) {
            return 0;
        }
        // 满足条件的结果数
        int res = 0;
        // 当前路径上节点的和
        currSum += node.val;
        // 此时prefixSumCount存储的均为当前节点的前缀和
        // 获取前缀和currSum-target的节点数，则当前节点到这些节点的距离为target
        res += prefixSumCount.getOrDefault(currSum - target, 0);
        // 将当前节点的前缀和放入map
        prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);
        // 递归当前节点的左子树
        res += recursionPathSum(node.left, currSum);
        // 递归当前节点的右子树
        res += recursionPathSum(node.right, currSum);
        // 将当前节点剔除。
        prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);
        return res;
    }

}
