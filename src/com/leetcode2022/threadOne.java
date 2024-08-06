package com.leetcode2022;

public class threadOne extends Thread{
    private LockNum lockNum = new LockNum();
    @Override
    public void run() {
        System.out.println("1开始");
        synchronized (lockNum){
            while (lockNum.getNum()!=1){
                try {
                    lockNum.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("1111");
            lockNum.setNum(2);
            lockNum.notifyAll();
        }
        System.out.println("1结束");
    }
}
