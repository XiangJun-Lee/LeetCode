import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CorpFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];
        for (int[] booking : bookings) {
            int start = booking[0];
            int last = booking[1];
            int seat = booking[2];
            for (int i = start-1;i<last;i++){
                result[i]+=seat;
            }
        }
        return result;
    }

    // 考察点：差分数组，用于求多次进行区间同时增加或减少相同的数的情况
    public int[] corpFlightBookingsOfficial(int[][] bookings, int n) {
        int[] nums = new int[n];
        for (int[] booking : bookings) {
            nums[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                nums[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    @Test
    public void test(){
        int[][] bookings = {{1,2,10},{2,3,20},{2,5,25}};
        int n = 5;
        int[] result = corpFlightBookingsOfficial(bookings, n);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
