package com.leetcode2022;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/short-encoding-of-words/
 */
public class MinimumLengthEncoding {
    public static int minimumLengthEncoding(String[] words) {
        if(words.length==1){
            return words[0].length();
        }
        String result = words[0];
        for(int i=1;i<words.length;i++){
            String mix = check(result,words[i]);
            if(mix ==null){
                result+="#"+words[i];
            }else {
                result+=mix;
            }
        }
        result+="#";
        System.out.println(result);
        return result.length();
    }
    public static int minimumLengthEncoding1(String[] words) {
        int N = words.length;
        // 反转每个单词
        String[] reversed_words = new String[N];
        for (int i = 0; i < N; i++) {
            String word = words[i];
            String rword = new StringBuilder(word).reverse().toString();
            reversed_words[i] = rword;
        }
        // 字典序排序
        Arrays.sort(reversed_words);
        String result = "";
        int res = 0;
        for (int i = 0; i < N; i++) {
            if (i+1 < N && reversed_words[i+1].startsWith(reversed_words[i])) {
                // 当前单词是下一个单词的前缀，丢弃
            } else {
                result+=words[i]+"#";
                res += reversed_words[i].length() + 1; // 单词加上一个 '#' 的长度
            }
        }
        System.out.println(result);
        return res;
    }

    private static String check(String result, String next) {
        int maxLength = next.length()>result.length()?result.length():next.length();
        for(int i=maxLength;i>0;i--){
            String n = next.substring(0,i);
            String r = result.substring(result.length()-i);
            if(n.equals(r)){
                return next.substring(i);
            }
        }
        return null;
    }
    public static void main(String[] args){
        String[] words= {"time", "me", "lime", "sometime", "lld", "shell"};
        System.out.println(minimumLengthEncoding1(words));
    }
}
