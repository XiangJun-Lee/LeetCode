package com.LeetCode.March;

/**
 * @author leelixiangjun
 * @date 2022/3/24 11:00
 */
public class March24 {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0, sum = 0;
                for (int x = i - 1; x <= i + 1; x++) {
                    for (int y = j - 1; y <= j + 1; y++) {
                        if (x >= 0 && x < m && y >= 0 && y < n) {
                            count++;
                            sum += img[x][y];
                        }
                    }
                }
                res[i][j] = sum / count;
            }
        }
        return res;
    }
}
