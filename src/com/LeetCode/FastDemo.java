import org.junit.Test;

import java.util.Scanner;

public class FastDemo {
    private int[] check(int[] nums, int start, int end) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        if(start>end){
            return nums;
        }
        int left=start,right=end;
        int target = nums[start];
        while (left<right){
            while (target<=nums[right]&&left<right){
                right--;
            }
            while (target>=nums[left]&&left<right){
                left++;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        nums[start] = nums[left];
        nums[left] = target;
        check(nums,start,right-1);
        check(nums,right+1,end);
        return nums;
    }

    @Test
    public void test(){
        int[] nums = {2,1,5,9,10,6,7,11};
        int[] res = check(nums,0,nums.length-1);
        for(int n: res){
            System.out.print(n+",");
        }
    }
}
