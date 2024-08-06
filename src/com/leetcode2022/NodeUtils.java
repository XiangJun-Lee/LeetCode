package com.leetcode2022;

public class NodeUtils {
    public static Nodes create(Integer[] nums){
        Nodes root = new Nodes(nums[0]);
        Nodes temp  = root;
        for (int i=1;i<nums.length;i++){
            Nodes node = new Nodes(nums[i]);
            temp.setNext(node);
            temp = temp.getNext();
        }
        return root;
    }
}
