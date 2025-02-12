package com.leetcode2025.february;

/**
 * @author leelixiangjun
 * @date 2025/2/12 09:01
 * @desc 递归翻转链表
 */
public class RecursionReverseList extends ReverseList {

    @Override
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newListNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newListNode;
    }
}
