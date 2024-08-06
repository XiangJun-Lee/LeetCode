package com.leetcode2022;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        combinationSum(n,k,1,res,new ArrayList<Integer>());
        return res;
    }

    private void combinationSum(int target, int times, int n, List<List<Integer>> res, ArrayList<Integer> list) {
        if(target==0&&times==0){
            res.add(new ArrayList<>(list));
            return;
        }
        if(times==0||n==10||target<0||(target==0&&times!=0)){
            return;
        }
        if(n<target){
            combinationSum(target,times,n+1, res, list);
        }
        list.add(n);
        combinationSum(target-n,times-1,n+1,res,list);
        list.remove(list.size()-1);
    }

    @Test
    public void test(){
        System.out.println(combinationSum3(3,9));
    }
}
