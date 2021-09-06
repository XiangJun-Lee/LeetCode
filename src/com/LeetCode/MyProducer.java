package com.LeetCode;

import sun.awt.windows.ThemeReader;

public class MyProducer implements Runnable{
    private MyObject object;

    public MyProducer(MyObject object){
        super();
        this.object = object;
    }

    @Override
    public void run() {
        try {
            synchronized (object){
               for (int i=0;i<100;i++){
                    object.add(System.currentTimeMillis()+"  "+i);
                    Thread.sleep(500);
                    if(MyObject.size()==5){
                        object.notify();
                        System.out.println("生产者已生产5条消息，消息ID为:"+i);
                        object.wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
