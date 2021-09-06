package com.LeetCode;

public class SingleDemo {
    private static volatile SingleDemo singleDemo;

    public void setSingleDemo(){
        if (singleDemo==null){
            synchronized (SingleDemo.class){
                if (singleDemo==null){
                    singleDemo = new SingleDemo();
                }
            }
        }
    }

    public SingleDemo getSingleDemo(){
        if (singleDemo==null){
            setSingleDemo();
        }
        return singleDemo;
    }


}
