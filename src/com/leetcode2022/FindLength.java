import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
 */
public class FindLength {
    public int findLength(int[] A, int[] B) {
        int res=0;
        int aLength=A.length,bLength=B.length;
        int[][] dp = new int[aLength+1][bLength+1];
        for(int i=0;i<aLength;i++){
            for (int j=0;j<bLength;j++){
                if(A[i]==B[j]){
                    dp[i+1][j+1]=dp[i][j]+1;
                    res=Math.max(res,dp[i+1][j+1]);
                }else {
                    res=Math.max(res,dp[i][j]);
                }
            }
        }
        return res;
    }


    @Test
    public void test(){
        int[] A = {1,2,3,2,1,9};
        int[] B= {3,2,1,4,7};
        System.out.println(findLength(A,B));
    }
}
