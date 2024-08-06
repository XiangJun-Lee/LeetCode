package com.leetcode2022;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leelixiangjun
 * @date 2022/2/15 11:39
 */
public class LuckyNumbers {
    /**
     * 遍历:时间复杂度为n*(m+n)
     * @param matrix
     * @return
     */
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int index = 0, min = matrix[i][index];
            for (int j = 0; j < matrix[i].length; j++) {
                if (min > matrix[i][j]) {
                    min = matrix[i][j];
                    index = j;
                }
            }
            boolean isMax = true;
            for (int n = 0; n < matrix.length; n++) {
                if (min<matrix[n][index]){
                    isMax = false;
                    break;
                }
            }
            if (isMax){
                ans.add(min);
            }
        }
        return ans;
    }
    @Test
    public void test(){
        int[][] matrix = {{3,7,8},{9,11,13},{15,16,17}};
        System.out.println(luckyNumbers(matrix));
    }

}
