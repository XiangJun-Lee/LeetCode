package com.leetcode2022;

import java.util.Iterator;
import java.util.List;

public class Test {
    private  Integer age;
    private Integer getAge(){
        return age;
    }
    public void remove(List<Test> userList){
        Iterator<Test> it = userList.iterator();
        while (it.hasNext()){
            Test user = it.next();
            if (user.getAge() >20){
                it.remove();
            }
        }
    }
}
