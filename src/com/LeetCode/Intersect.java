import java.util.ArrayList;
import java.util.HashMap;

public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length) return intersect(nums2,nums1);
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> nums = new HashMap<>();
        for(int num :nums1){
            int n = nums.getOrDefault(num,1);
            nums.put(num,n+1);
        }
        for(int num :nums2){
            if(nums.containsKey(num)) {
                int n = nums.getOrDefault(num, 0);
                if (n > 0) {
                    nums.put(num, n - 1);
                    list.add(num);
                }
            }
        }
        int[] intersection = new int[list.size()];
        for(int i=0;i<list.size();i++){
            intersection[i] = list.get(i);
        }
        return intersection;
    }
}
