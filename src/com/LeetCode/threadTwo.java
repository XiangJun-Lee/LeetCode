package com.LeetCode;

public class threadTwo extends Thread{
    private LockNum lockNum = new LockNum();
    @Override
    public void run() {
        System.out.println("2开始");
        synchronized (lockNum){
            while (lockNum.getNum()!=2){
                System.out.println(lockNum.getNum()+"   2");
                try {
                    lockNum.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("22222");
            lockNum.setNum(3);
            lockNum.notifyAll();
        }
        System.out.println("2结束");
    }
}
