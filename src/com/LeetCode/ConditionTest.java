import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {
    private static final ReentrantLock lock = new ReentrantLock(true);
    //从锁中创建一个绑定条件
    private static final Condition condition = lock.newCondition();

    private static int count = 1;

    public static void main(String[] args) {

        Runnable r1 = new Runnable(){
            public void run(){
                lock.lock();
                try{
                    while(count<=5){
                        System.out.println(Thread.currentThread().getName()+"--"+count++);
                        Thread.sleep(1000);
                    }
                    condition.signal();		//线程r1释放条件信号，以唤醒r2中处于await的代码继续执行。
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally{
                    lock.unlock();
                }
            }
        };

        Runnable r2 = new Runnable(){
            public void run(){
                lock.lock();
                try{
                    if(count<=5){
                        System.out.println("----$$$---");
                        condition.await();	//但调用await()后，lock锁会被释放，让线程r1能获取到，与Object.wait()方法一样
                        System.out.println("----------");
                    }
                    while(count<=10){
                        System.out.println(Thread.currentThread().getName()+"--"+count++);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally{
                    lock.unlock();
                }
            }
        };

        new Thread(r2).start();	//让r2先执行，先获得lock锁，但条件不满足，让r2等待await。
        try {
            Thread.sleep(100);	//这里休眠主要是用于测试r2.await()会释放lock锁，被r1获取
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(r1).start();
    }
}