package com.LeetCode;

import java.util.ArrayList;

public class NumberOfSubarrays {
    public static int numberOfSubarrays(int[] nums, int k) {
        int length = nums.length;
        if(length==0){
            return 0;
        }
        ArrayList<Integer> site = new ArrayList<>(length);
        for(int i=0;i<length;i++){
            if(nums[i]%2!=0){
                site.add(i);
            }
        }
        int listSize = site.size();
        if(listSize<k){
            return 0;
        }
        int head = 0;
        int end = k-1;
        int result =0;
        while(end<listSize){
            int siteHead = site.get(head);
            int siteEnd = site.get(end);
            int beforeHead = head==0? -1:site.get(head-1);
            int afterEnd = end==listSize-1? length:site.get(end+1);
            int x = siteHead-beforeHead<=1? 1:siteHead-beforeHead;
            int y = afterEnd-siteEnd<=1? 1:afterEnd-siteEnd;
            result+=x*y;
            head++;
            end++;
        }
        return result;
    }

    public static int numberOfSubarrays1(int[] nums, int k) {
        int length = nums.length;
        if(length==0){
            return 0;
        }
        int[] site = new int[length];
        int listSize=0;
        for(int i=0;i<length;i++){
            if(nums[i]%2!=0){
                site[listSize] =i;
                listSize++;
            }
        }
        if(listSize<k){
            return 0;
        }
        int head = 0;
        int end = k-1;
        int result =0;
        while(end<listSize){
            int siteHead = site[head];
            int siteEnd = site[end];
            int beforeHead = head==0? -1:site[head-1];
            int afterEnd = end==listSize-1? length:site[end+1];
            int x = siteHead-beforeHead<=1? 1:siteHead-beforeHead;
            int y = afterEnd-siteEnd<=1? 1:afterEnd-siteEnd;
            result+=x*y;
            head++;
            end++;
        }
        return result;
    }
    public static void main(String[] args){
        int[]nums = {1,1,2,1,1};
        System.out.println(numberOfSubarrays1(nums,3));
    }
}
