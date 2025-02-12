package com.leetcode2025.february;

/**
 * @author leelixiangjun
 * @date 2025/2/12 08:58
 * @desc 循环翻转链表
 */
public class WhileReverseList extends ReverseList {

    @Override
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

}
