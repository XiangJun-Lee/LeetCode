package com.leetcode2022;

public class MyTest {

    public static void main(String[] args){
        MyObject object = new MyObject();
        MyProducer myProducer = new MyProducer(object);
        MyConsumer myConsumer = new MyConsumer(object);
        Thread thread = new Thread(myConsumer);
        Thread thread1 = new Thread(myProducer);
        thread.start();
        thread1.start();
    }
}
