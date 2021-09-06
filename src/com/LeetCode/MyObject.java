package com.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class MyObject {
    private static Queue<Object> queue = new LinkedList<>();

    public static void add(Object object){
        queue.add(object);
    }

    public static int size(){
        return queue.size();
    }

    public static void poll(){
        queue.poll();
    }

}
