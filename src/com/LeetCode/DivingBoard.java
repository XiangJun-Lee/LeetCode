import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DivingBoard {
     public int[] divingBoard(int shorter, int longer, int k) {
         if (k == 0) return new int[0];
         if (shorter == longer) return new int[]{shorter * k};
         int[] res = new int[k + 1];
         for (int i = 0; i <= k; i++) {
             res[i] = shorter * (k - i) + longer * i;
         }
         return res;
     }

    @Test
    public void test(){
        System.out.println(divingBoard(1,2,3));
    }
}
