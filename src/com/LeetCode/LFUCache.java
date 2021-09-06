package com.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class LFUCache {
    public int capacity;
    public HashMap<Integer,Integer> values;
    public LinkedHashMap<Integer,Integer> nums;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.values = new HashMap<>(capacity);
        this.nums = new LinkedHashMap<>(capacity);
    }

    public int get(int key) {
        if(nums.containsKey(key)){
            nums.put(key,nums.get(key)+1);
            return values.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if(capacity==0){
            return;
        }
        if(nums.containsKey(key)){
            nums.put(key,nums.get(key)+1);
            values.put(key,value);
            return;
        }
        if(!nums.containsKey(key)&&values.size()<capacity){
            nums.put(key,1);
            values.put(key,value);
            return;
        }
        if(!nums.containsKey(key)&&values.size()==capacity){
            int min = Integer.MAX_VALUE;
            int outKey = 0;
            for(int k : nums.keySet()){
                if(nums.get(k)<=min){
                    min=nums.get(k);
                    outKey = k;
                }
            }
            nums.remove(outKey);
            values.remove(outKey);
            values.put(key,value);
            return;
        }

    }
}
