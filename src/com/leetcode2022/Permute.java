package com.leetcode2022;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 */
public class Permute {
    public static List<List<Integer>> permute(int[] nums) {
        int size = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> temp = new ArrayList<>();
        if(size==1){
            List<Integer> para = new ArrayList<>(size);
            para.add(nums[0]);
            result.add(para);
            return result;
        }
        for(int num :nums){
            List<Integer> para = new ArrayList<>(size);
            para.add(num);
            temp.add(para);
        }
        while(temp.size()>0){
            int length = temp.size();
            for(int i=0;i<length;i++){
                List<Integer> num = temp.get(0);
                temp.remove(0);
                for(int n : nums){
                    if(!num.contains(n)){
                        List<Integer> tempNum = new ArrayList<>(size);
                        tempNum.addAll(num);
                        tempNum.add(n);
                        if(tempNum.size()==size){
                            result.add(tempNum);
                        }else {
                            temp.add(tempNum);
                        }
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        int[] nums = {1,2};
        List<List<Integer>> result =permute(nums);
        System.out.println(result.size());
        System.out.println(permute(nums));
    }
}
