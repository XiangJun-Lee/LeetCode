package com.LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int length=0;
        ArrayList<Character> list = new ArrayList<>();
        for(char c : s.toCharArray()){
            if(list.contains(c)){
                int index= list.indexOf(c);
                for(int i=0;i<index+1;i++){
                    list.remove(0);
                }
                list.add(c);
            }else {
                list.add(c);
            }
            int size = list.size();
            length = length<size? size:length;
        }
        return length;
    }

    @Test
    public void test(){
        String s= "aabaab!bb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
