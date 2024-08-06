package com.leetcode2022;

import org.junit.Test;

public class GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode pre = head;
        ListNode result = head;
        for (int i=0;i<k-1;i++){
            if (pre.next==null){
                break;
            }
            pre = pre.next;
        }
        while (pre.next !=null){
            pre = pre.next;
            result = result.next;
        }
        return  result;
    }
    @Test
    public void test(){
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i=2;i<6;i++){
            ListNode node = new ListNode(i);
            temp.next = node;
            temp = temp.next;
        }
        System.out.println(getKthFromEnd(head,1).val);
    }
}
