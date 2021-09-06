package com.LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;

public class IsHappy {
    public boolean isHappy(int n) {
        HashSet<Integer> hasNum = new HashSet<>();
        hasNum.add(n);
        int[] nums = new int[10];
        for(int i=0;i<10;i++){
            nums[i] = i*i;
        }
        while(n!=1){
            int temp =0;
            while(n>0){
                temp+=nums[n%10];
                n/=10;
            }
            if(temp==1){
                System.out.println(hasNum.size());
                return true;
            }else if(!hasNum.contains(temp)){
                hasNum.add(temp);
                n= temp;
                continue;
            }
            break;
        }
        System.out.println(hasNum.size());
        return false;
    }
    public boolean isHappy1(int n){
        int slow = bitSquareSum(n);
        int fast = bitSquareSum(bitSquareSum(n));
        while(slow!=fast){
            slow = bitSquareSum(slow);
            fast = bitSquareSum(bitSquareSum(fast));
        }
        return slow==1;

    }

    private int bitSquareSum(int n){
        int sum =0;
        while(n>0){
            int bit = n%10;
            sum+=bit*bit;
            n/=10;
        }
        return sum;
    }

    @Test
    public void test(){
        System.out.println(isHappy1(39166461));
    }
}
