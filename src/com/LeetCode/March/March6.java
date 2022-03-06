package com.LeetCode.March;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leeixiangjun
 * @date 2022/3/6 9:43 上午
 */
public class March6 {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> ans = new ArrayList<>();
        int n = security.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i=1;i<n;i++){
            if(security[i]<=security[i-1]){
                left[i] = left[i-1]+1;
            }
            if(security[n-i-1]<=security[n-i]){
                right[n-i-1] = right[n-i]+1;
            }
        }
        for(int i=0;i<n;i++){
            if(left[i]>=time&&right[i]>=time){
                ans.add(i);
            }
        }
        return ans;
    }
}
