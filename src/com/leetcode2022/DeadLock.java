public class DeadLock {
    public static Object resource1 = new Object();
    public static Object resource2 = new Object();
    public static void main(String[] args){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
        new Thread(()->{
            synchronized (resource1){
                System.out.println(Thread.currentThread().getName()+"get resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"waiting resource2");
                synchronized (resource2){
                    System.out.println(Thread.currentThread().getName()+"get resource2");
                }
            }
        },"Thread 1").start();

        new Thread(()->{
            synchronized (resource2){
                System.out.println(Thread.currentThread().getName()+"get resource2");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"waiting resource1");
                synchronized (resource1){
                    System.out.println(Thread.currentThread().getName()+"get resource1");
                }
            }
        },"Thread 2").start();

    }
}
