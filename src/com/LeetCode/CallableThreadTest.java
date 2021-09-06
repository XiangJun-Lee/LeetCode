import java.util.concurrent.Callable;

public class CallableThreadTest implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int i=1;
        for(;i<11;i++){
            System.out.println(Thread.currentThread().getName()+" "+i);
        }

        return i;
    }
}
