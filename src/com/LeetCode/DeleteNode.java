package com.LeetCode;

/**
 * @author leelixiangjun
 * @date 2021/11/2 11:10
 */
public class DeleteNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
