import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutation-sequence/
 */
public class GetPermutation {
    public String getPermutation(int n, int k) {
        if(n==1){
            return String.valueOf(n);
        }
        List<Integer> nums = new ArrayList<>(n);
        int factorial =1;
        for(int i=1;i<=n;i++){
            nums.add(i);
            factorial*=i;
        }
        return getNextNum(nums,factorial/n,k,n-1).toString();
    }
    private StringBuilder getNextNum(List<Integer> nums, int factorial, int k,int n) {
        StringBuilder res = new StringBuilder();
        int local = k/factorial;
        int nextK = k%factorial;
        int size = nums.size();
        if(nextK==0){
            res.append(nums.get(local-1));
            nums.remove(local-1);
            for(int i=size-2;i>=0;i--){
                res.append(nums.get(i));
            }
            return res;
        }

        if(size>2){
            res.append(nums.get(local));
            nums.remove(local);
            return res.append(getNextNum(nums,factorial/n,nextK,n-1));
        }
        res.append(nums.get(0)).append(nums.get(1));
        if(k==1){
            return res;
        }
        return res.reverse();
    }

    public String getPermutation1(int n, int k) {
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; ++i) {
            factorial[i] = factorial[i - 1] * i;
        }

        --k;
        StringBuffer ans = new StringBuffer();
        int[] valid = new int[n + 1];
        Arrays.fill(valid, 1);
        for (int i = 1; i <= n; ++i) {
            int order = k / factorial[n - i] + 1;
            for (int j = 1; j <= n; ++j) {
                order -= valid[j];
                if (order == 0) {
                    ans.append(j);
                    valid[j] = 0;
                    break;
                }
            }
            k %= factorial[n - i];
        }
        return ans.toString();
    }

    @Test
    public void test(){
        System.out.println(getPermutation1(3,3));
    }
}
