package com.leetcode2022;

import java.util.ArrayList;
import java.util.List;

public class FindMode {
    private int pre = 0,count=0,max=0;
    private List<Integer> vals = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        findModes(root);
        int[] res = new int[vals.size()];
        for (int i=0;i<vals.size();i++){
            res[i] = vals.get(i);
        }
        return res;
    }

    private void findModes(TreeNode root) {
        if (root==null){
            return;
        }
        findModes(root.left);
        update(root.val);
        findModes(root.right);
    }

    private void update(int val) {
        if (pre==val){
            count++;
        }else {
            count=1;
            pre=val;
        }
        if (count==max){
            vals.add(val);
        }else if (count>max){
            vals.clear();
            max=count;
            vals.add(val);
        }
    }
}
