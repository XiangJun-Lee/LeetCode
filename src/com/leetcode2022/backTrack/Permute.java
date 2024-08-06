package com.leetcode2022.backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leeixiangjun
 * @date 2022/3/3 11:15 下午
 * @number 46
 */
public class Permute {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        dfs(new ArrayList<>(),nums,used);
        return ans;
    }

    private void dfs(List<Integer> list, int[] nums,boolean[] used){
        if(list.size()==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!used[i]){
                list.add(nums[i]);
                used[i] = true;
                dfs(list,nums,used);
                list.remove(list.size()-1);
                used[i] = false;
            }
        }
    }
}
