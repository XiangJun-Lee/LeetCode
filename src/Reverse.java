import org.junit.Test;

public class Reverse {
    public int reverse(int x) {
        int max = Integer.MAX_VALUE;
        if(x<0){
            return -reverse(-x);
        }
        int res = 0;
        while(x>9){
            if(res>max/10||(res==max/10&&x%10>7)){
                return 0;
            }
            res*=10;
            res+=x%10;
            x/=10;
        }
        if(x>0){
            if(res>max/10||(res==max/10&&x>7)){
                StringBuffer sb = new StringBuffer(String.valueOf(res));
                sb.append(x);
                System.out.println("入参的翻转越界,结果为："+sb.toString());
                return 0;
            }
            res*=10;
            res+=x;
        }
        return res;
    }

    @Test
    public void test(){
        int x = 1000000003;
        System.out.println(reverse(x));
    }
}