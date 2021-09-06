package com.LeetCode;

/**
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 */
public class LongestCommonSubsequence {
    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] max = new int[text1.length()+1][text2.length()+1];
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int result = 0;
        for(int i=0;i<chars1.length;i++){
            for (int j=0;j<chars2.length;j++){
                if(chars1[i]==chars2[j]){
                    max[i+1][j+1] = max[i][j]+1;
                    continue;
                }
                max[i+1][j+1] = Math.max(max[i][j+1],max[i+1][j]);
            }
        }
        return max[text1.length()][text2.length()];
    }
    public static void main(String[] args){
        String text1 = "abc";
        String text2 = "ace";
        System.out.println(longestCommonSubsequence(text1,text2));

    }
}
