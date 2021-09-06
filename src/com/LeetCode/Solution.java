package com.LeetCode;

import org.junit.Test;

import java.util.*;

public class Solution {
    /**
     * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root ==null) return null;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left!=null&&right!=null) return root;
        if(left==null&&right==null) return (root.val==p.val||root.val==q.val)? root:null;
        if(root.val==p.val||root.val==q.val) return root;
        return left==null? right:left;
    }

    /**
     * https://leetcode-cn.com/problems/single-number/
     * @date 2020年5月14日
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
//        Arrays.sort(nums);
//        int len = nums.length;
//        for(int i=1;i<len;i+=2){
//            if(nums[i-1]!=nums[i]){
//                return nums[i-1];
//            }
//        }
//        return nums[len-1];
        int num = 0;
        for(int i=1;i<nums.length;i++){
            nums[0]^=nums[i];
        }
        return nums[0];
    }

    /**
     * https://leetcode-cn.com/problems/subarray-sum-equals-k/
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
//        int len = nums.length; int sum=0;
//        int[] tempNums = new int[len];
//        tempNums[0] = nums[0];
//        if(nums[0]==k) sum++;
//        for(int i=1;i<len;i++){
//            int num = nums[i]+tempNums[i-1];
//            tempNums[i] = num;
//            for(int j=0;j<=i;j++){
//                if(num==k) sum++;
//                num-=nums[j];
//            }
//
//        }
//        return sum;
        int res=0,sum=0;
        HashMap<Integer,Integer> sums = new HashMap<>();
        sums.put(sum,1);
        for(int num :nums){
            sum+=num;
            if(sums.containsKey(sum-k)) res+=sums.get(sum-k);
            sums.put(sum,sums.getOrDefault(sum,0)+1);
        }
        return res;
    }

    @Test
    public void test(){
        int[] nums = {3,4,7,2,-3,1,4,2};
        System.out.println(subarraySum(nums,7));
    }
}
