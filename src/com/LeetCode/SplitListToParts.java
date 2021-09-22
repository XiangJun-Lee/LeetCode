package com.LeetCode;

/**
 * @author leelixiangjun
 * @date 2021/9/22 20:38
 * @link https://leetcode-cn.com/problems/split-linked-list-in-parts/submissions/
 */
public class SplitListToParts {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int size = 0;
        ListNode tempHead = head;
        // 循环遍历链表，计算链表长度
        while (tempHead != null) {
            tempHead = tempHead.next;
            size++;
        }
        //得到链表的长度 size 之后，记 block = size/k, remain = size%k,则在k个分段中，前remain个分段中，长度为block+1，后面的则为block
        int block = size / k, remain = size % k;
        ListNode[] res = new ListNode[k];
        for (int i = 0; i < k && head != null; i++) {
            res[i] = head;
            int part = block + (i < remain ? 1 : 0);
            for (int j = 1; j < part; j++) {
                head = head.next;
            }
            // 将当前分段的尾置为null
            // 1.现用next去保存head.next
            // 2.将head.next置为null，断开链表
            // 3.将head = next，继续循环
            ListNode next = head.next;
            head.next = null;
            head = next;
        }
        return res;
    }
}
