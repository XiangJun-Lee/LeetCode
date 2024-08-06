package com.leetcode2022;

public class MyConsumer implements Runnable{
    private MyObject object;

    public MyConsumer(MyObject object){
        super();
        this.object = object;
    }
    @Override
    public void run() {
        try {
            synchronized (object){
                while (true){
                    if(MyObject.size()!=5){
                        System.out.println("生产数据不足，消费者等待。"+System.currentTimeMillis());
                        object.wait();
                    }
                    System.out.println("消费开始，数据容量为："+ MyObject.size());
                    for(int i=0;i<5;i++){
                        MyObject.poll();
                    }
                    System.out.println("消费结束.");
                    object.notify();
                    object.wait();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
