package com.LeetCode;

import java.util.ArrayList;
import java.util.Collections;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists,0,lists.length-1);
    }

    private ListNode merge(ListNode[] lists,int start,int end) {
        ListNode result = new ListNode(0);
        if(end-start>1){
            ListNode left = merge(lists,start,end/2);
            ListNode right = merge(lists, end/2+1,end);
            ListNode[] tempLists = new ListNode[2];
            tempLists[0] = left;
            tempLists[1] = right;
            result = merge(tempLists,0,1);

        }

        if(end-start==0){
            return lists[0];
        }

        if(end-start==1){
            ListNode list = new ListNode(0);
            ListNode temp =list;
            ListNode l1 = lists[start];
            ListNode l2 = lists[end];
            while(l1!=null&&l2!=null){
                int num1 = l1.val;
                int num2 = l2.val;
                if(num1>num2){
                    temp.next = new ListNode(num2);
                    l2 = l2.next;
                }else {
                    temp.next = new ListNode(num1);
                    l1 = l1.next;
                }
            }
            if(l1!=null){
                temp.next = l1;
            }
            if(l2!=null){
                temp.next = l2;
            }
            return list.next;
        }
        return result.next;

    }
}
