package com.leetcode2022;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/as-far-from-land-as-possible/submissions/
 */

/**
 * 解题思路：广度优先遍历
 *  1.首先找出当前地图中所有的陆地
 *  2.广度优先遍历距离陆地为1的海洋，将海洋转换为陆地
 *  3.广度优先遍历距离新陆地为1的海洋，这些海洋距离原始陆地的距离为2
 *  4.直至遍历到最后一块海洋，遍历的层数即为结果
 */
public class MaxDistance {
    public static int maxDistance(int[][] grid) {
        Queue<int[]> search = new ArrayDeque<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                if(grid[i][j] == 1){
                    search.offer(new int[]{i,j});
                }
            }
        }
        if(search.size()==0||search.size()==grid.length*grid.length){
            return -1;
        }
        return dfs(grid,search);
    }

    private static int dfs(int[][] grid, Queue<int[]> search) {
        int result =0;
        while(search.size()>0){
            int size = search.size();
            loop:for(int n=0;n<size;n++){
                int[] local = search.poll();
                if(local[0]-1>=0&&grid[local[0]-1][local[1]]==0){
                    search.add(new int[]{local[0]-1,local[1]});
                    grid[local[0]-1][local[1]]=1;
                }
                if(local[1]-1>=0&&grid[local[0]][local[1]-1]==0){
                    search.add(new int[]{local[0],local[1]-1});
                    grid[local[0]][local[1]-1]=1;
                }
                if(local[0]+1<grid.length&&grid[local[0]+1][local[1]]==0){
                    search.add(new int[]{local[0]+1,local[1]});
                    grid[local[0]+1][local[1]] = 1;
                }
                if(local[1]+1<grid.length&&grid[local[0]][local[1]+1]==0){
                    search.add(new int[]{local[0],local[1]+1});
                    grid[local[0]][local[1]+1] = 1;
                }
            }
            result++;
        }
        return result-1;
    }

    public static void main(String[] args){
        int[][] grid = {{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1}};
        System.out.println(maxDistance(grid));
    }
}
