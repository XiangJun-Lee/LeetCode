public class canJump {
    public static boolean canJump(int[] nums) {
        int length = nums.length;
        int[] jump = new int[length];
        jump[0] =1;
        for(int i=0;i<length-1;i++){
            if(jump[i]==1){
                int j = i+nums[i];
                if(j>=length-1){
                    return true;
                }
                while(j>i){
                    if(jump[j]==1){
                        j=i;
                        continue;
                    }
                    jump[j] =1;
                    j--;
                }
            }
            if(jump[i]==0){
                return false;
            }
        }
        if(jump[length-1]==1){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        int[] nums = {3,2,1,0,4};
        System.out.println(canJump(nums));
    }
}
