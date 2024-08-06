package com.leetcode2022;

import java.util.Arrays;

class MinIncrementForUnique {
	   public static int minIncrementForUnique(int[] A) {
		   int result = 0;
		   Arrays.sort(A);
		   int end = A[0];
		   for(int i =1;i<A.length;i++) {
			   if(A[i]<=end) {
				   result+=end-A[i]+1;
				   end++;
			   }else {
				   end = A[i];
			   }
		   }
		   return result;
	    }
	   
	   public static void main(String[] args) {
		   int[] A = new int[] {3,2,1,2,1,7};
		   System.out.println(minIncrementForUnique(A));
	   }
}
