package com.LeetCode.demo;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Exist {
    public static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public boolean exist(char[][] board, String word) {
        Queue<int[]> next = new LinkedList<>();
        char[] letters = word.toCharArray();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]==letters[0]){
                    next.offer(new int[]{i,j});
                    char[][] temp = clone(board);
                    temp[i][j]='0';
                    if(check(temp,letters,i,j,1)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean check(char[][] board, char[] letters, int i, int j, int next) {
        if(next==letters.length){
            return true;
        }
        for(int[] direction : directions){
            int tempI = i+direction[0];
            int tempJ = j+direction[1];
            if(tempI>=0&&tempJ>=0&&tempI<board.length&&tempJ<board[0].length&&board[tempI][tempJ]==letters[next]){
                char[][] temp = clone(board);
                temp[tempI][tempJ] = '0';
                if (!check(temp,letters,tempI,tempJ,next+1)){
                    continue;
                }else {
                    return true;
                }
            }
        }
        return false;
    }
    private char[][] clone(char[][] board){
        char[][] newBoard = new char[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                newBoard[i][j] = board[i][j];
            }
        }
        return newBoard;
    }

    @Test
    public void test(){
        char[][] board ={{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        String word = "AAB";
        System.out.println(exist(board,word));
    }

}
