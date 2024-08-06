package com.leetcode2022;

/**
 * @author leelixiangjun
 * @date 2021/9/17 16:45
 */
public class IsValidSudoku {
    // 遍历
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][][] subBoard = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int index = c - '0' - 1;
                    row[i][index]++;
                    col[j][index]++;
                    subBoard[i / 3][j / 3][index]++;
                    if (row[i][index] > 1 || col[j][index] > 1 || subBoard[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }

            }
        }
        return true;
    }

    // 位运算
    public boolean isValidSudoku2(char[][] board) {
        int[] row = new int[9];
        int[] col = new int[9];
        int[] sub = new int[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int val = c - '0';
                    if (!occupied(row[i], val) || !occupied(col[j], val) || !occupied(sub[i / 3 * 3 + j / 3], val)) {
                        return false;
                    }
                    set(row, i, val);
                    set(col, j, val);
                    set(sub, i / 3 * 3 + j / 3, val);
                }
            }
        }
        return true;
    }

    private void set(int[] data, int i, int val) {
        data[i] |= (1 << val);
    }

    private boolean occupied(int data, int index) {
        return ((data >> index) & 1) == 1;
    }
}
