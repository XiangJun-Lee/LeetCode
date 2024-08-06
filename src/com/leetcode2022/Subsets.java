package com.leetcode2022;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        int length = nums.length;
        if(nums==null||length==0){
            return res;
        }
        for(int i=1;i<=length;i++){
            getSubSetsByLength(res, new ArrayList<>(),i,0,nums);
        }
        return res;
    }

    private void getSubSetsByLength(List<List<Integer>> res, ArrayList<Integer> list, int length, int cur, int[] nums) {
        if(list.size()==length){
            res.add(new ArrayList<>(list));
        }
        if(cur==nums.length){
            return;
        }
        if(list.size()+nums.length-1-cur>length){
            getSubSetsByLength(res,list,length,cur+1,nums);
        }

        list.add(nums[cur]);
        getSubSetsByLength(res,list,length,cur+1,nums);
        list.remove(list.size()-1);
    }

    @Test
    public void test(){
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }
}
