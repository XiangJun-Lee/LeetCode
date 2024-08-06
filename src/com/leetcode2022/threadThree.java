package com.leetcode2022;

public class threadThree extends Thread {
    private LockNum lockNum = new LockNum();
    @Override
    public void run() {
        System.out.println("3开始");
        synchronized (lockNum){
            while (lockNum.getNum()!=3){
                System.out.println(lockNum.getNum()+"   3");
                try {
                    lockNum.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("33333");
            lockNum.notifyAll();
        }
        System.out.println("3结束");
    }
}
