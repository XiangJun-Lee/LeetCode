package com.leetcode2022;

/**
 * https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class Trap {
    public static int trap(int[] height) {
        if(height.length<=2){
            return 0;
        }
        int rain = 0;
        int max = 0;
        for(int h :height){
            max = h>max?h:max;
        }
        for(int i=0;i<max;i++){
            int start = -1;
            int end=0;
            for(int j=0;j<height.length;j++){
                if(height[j]!=0&&start!=-1){
                    end =j;
                    rain+=end-start-1;
                    start = end;
                    height[j]--;
                    continue;
                }
                if(height[j]!=0){
                    start = j;
                    height[j]--;
                }
            }

        }
        return rain;
    }
    public static void main(String[] args){
        int[] height = {2,0,2};
        System.out.println(trap(height));
    }

}
