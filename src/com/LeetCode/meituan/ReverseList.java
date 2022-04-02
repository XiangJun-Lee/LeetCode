package com.LeetCode.meituan;

/**
 * @author leelixiangjun
 * @date 2022/3/30 22:23
 */
public class ReverseList {
    // 双指针
    public ListNode reverseList(ListNode head) {
        // 前置节点
        ListNode pre = null;
        // 当前节点
        ListNode curr = head;
        while (curr != null) {
            // 先暂存下一个节点
            ListNode next = curr.next;
            // 让当前节点的下一个节点指向前面的节点
            curr.next = pre;
            // 前置节点向前移动一个
            pre = curr;
            // 当前节点向前移动一个
            curr = next;
        }
        return pre;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
