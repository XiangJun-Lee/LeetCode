import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class FindCurrentDigital {
    public static int[] nums={2,3,5};

    public int findCurrentDigital(int bitNum){
        bitNum-=1;
        ArrayList<Integer> number = new ArrayList<>();

        while (bitNum>0){
            int temp = bitNum%10;
            number.add(temp);
            bitNum/=10;
        }
        int size = number.size();
        int[] tempResult = init(size);

        for(int i=size-1;i>=0;i--){
            int tempI = number.get(i);
            if(tempI>nums[2]){
                break;
            }else if(tempI<nums[2]&&tempI>nums[1]){
                tempResult[i]=1;
                break;
            }else if(tempI<nums[1]&&tempI>nums[0]){
                tempResult[i]=0;
                break;
            }else if(tempI==nums[2]){
                tempResult[i]=2;
                continue;
            } else if(tempI==nums[1]){
                tempResult[i]=1;
                continue;
            } else if(tempI==nums[0]){
                tempResult[i]=0;
                continue;
            } else if(tempI<nums[0]){
                if(i+1==size){
                    tempResult[i]=-1;
                    break;
                }
                for(int j=i+1;j<size;j++){
                    if(tempResult[j]==0){
                        if(j!=size-1){
                            tempResult[j]=2;
                        }else {
                            tempResult[j]=-1;
                        }
                    }else {
                        tempResult[j]=tempResult[j]-1;
                        break;
                    }
                }
                break;
            }
        }
        int res=0;
        if(tempResult[size-1]!=-1){
            res=nums[tempResult[size-1]];
        }
        for(int i=size-2;i>=0;i--){
            res=res*10+nums[tempResult[i]];
        }
        return res;
    }

    private int[] init(int size) {
        int[] res = new int[size];
        for(int i=0;i<size;i++){
            res[i]=2;
        }
        return res;
    }

    @Test
    public void test(){
        int[] bitNum = {99,552,52222,222,532};
        for(int num : bitNum){
            System.out.println(findCurrentDigital(num));
        }

    }
}
