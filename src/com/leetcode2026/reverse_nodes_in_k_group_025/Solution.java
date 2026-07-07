package com.leetcode2026.reverse_nodes_in_k_group_025;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dump = new ListNode(0, head);
        // 上一个翻转的尾
        ListNode prevGroupEnd = dump;
        while (true) {
            // 定义本次翻转的尾
            ListNode groupEnd = prevGroupEnd;
            // 循环k次，找到本次翻转的尾，不够长则直接返回。
            for (int i = 0; i < k; i++) {
                groupEnd = groupEnd.next;
                if (groupEnd == null) {
                    return dump.next;
                }
            }
            // 找到本次翻转的头 = 上一次翻转的尾.next
            ListNode groupStart = prevGroupEnd.next;
            // 暂存下一次翻转的头 = 本次翻转的头.next
            ListNode nextGroupStart = groupEnd.next;

            //断开本次需要翻转的list的头尾，使之成为一个孤链
            groupEnd.next = null;
            prevGroupEnd.next = null;

            // 链表翻转，
            // ⚠️⚠️⚠️：返回的是翻转后链表的头，并且groupStart变成了反转后链表的尾。
            ListNode reverseHead = reverseList(groupStart);
            ListNode reverseEnd = groupStart;
            // 重新链接链表
            // 1. 将上一个翻转的尾.next = 本次翻转后的头
            prevGroupEnd.next =reverseHead;
            // 2. 将本次翻转后的尾.next = 下一次翻转的头
            reverseEnd.next = nextGroupStart;

            // 上一次翻转的尾 后移 到 本次翻转的尾。
            prevGroupEnd = reverseEnd;
        }

    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }


}

class ListNode {
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
