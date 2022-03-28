package com.LeetCode.March;

/**
 * @author leelixiangjun
 * @date 2022/3/29 0:21
 * @link https://leetcode-cn.com/problems/maximize-the-confusion-of-an-exam/
 */
public class March29 {

    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(maxConsecutiveChars(answerKey, k, 'T'), maxConsecutiveChars(answerKey, k, 'F'));
    }

    private int maxConsecutiveChars(String answerKey, int k, char targetChar) {
        int left = 0, right = 0, sum = 0, ans = 0, n = answerKey.length();
        while (right < n) {
            sum += answerKey.charAt(right++) != targetChar ? 1 : 0;
            while (sum > k) {
                sum -= answerKey.charAt(left++) != targetChar ? 1 : 0;
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}
