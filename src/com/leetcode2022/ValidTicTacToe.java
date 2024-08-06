package com.leetcode2022;

/**
 * @author leeixiangjun
 * @date 2021/12/9 11:07 下午
 */
public class ValidTicTacToe {
    public boolean validTicTacToe(String[] board) {
        int cntX = 0, cntO = 0;
        for (String row : board) {
            for (char c : row.toCharArray()) {
                cntX = c == 'X' ? cntX + 1 : cntX;
                cntO = c == 'O' ? cntO + 1 : cntO;
            }
        }
        if (cntO != cntX && cntO != cntX - 1) {
            return false;
        }
        if (win(board,'X')&&cntO != cntX - 1){
            return false;
        }
        if (win(board,'O')&&cntO != cntX){
            return false;
        }
        return true;
    }

    private boolean win(String[] board, char c) {
        for (int i = 0; i < board.length; i++) {
            if (c == board[0].charAt(i)&&c == board[1].charAt(i)&&c == board[2].charAt(i)){
                return true;
            }
            if (c == board[i].charAt(0)&&c == board[i].charAt(1)&&c == board[i].charAt(2)){
                return true;
            }
        }
        if (c == board[0].charAt(0)&&c == board[1].charAt(1)&&c == board[2].charAt(2)){
            return true;
        }
        if (c == board[0].charAt(2)&&c == board[1].charAt(1)&&c == board[2].charAt(0)){
            return true;
        }
        return  false;
    }
}
