package com.leetcode2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int size = nums.length;
        if(nums==null||size==0){
            return res;
        }
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>(size);
        for(int num :nums){
            list.add(num);
        }
//        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        for(int num :nums){
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(num);
            combineNext(res, list, ans, num, size);
        }
        return res;
    }

    private void combineNext(List<List<Integer>> res, List<Integer> list, ArrayList<Integer> ans, Integer cur, int size) {
        if(ans.size()==size){
            res.add(ans);
        }

    }
}
