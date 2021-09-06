package com.LeetCode;

public class single implements Runnable {
    private static  volatile Object object;
    @Override
    public void run() {
        if (object==null){
            synchronized (object){
                if (object==null){
                    object = new Object();
                }
            }
        }
    }
}
