package com.LeetCode;

/**
 * @author leelixiangjun
 * @date 2021/9/24 10:22
 * @link https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/
 * @point 深度遍历 递归
 */
public class Flatten {
    public Node flatten(Node head) {
        dsf(head);
        return head;
    }

    public Node dsf(Node head) {
        // 记录连边最后一个非空节点
        Node last = null;
        // 遍历主干节点
        while (head != null) {
            // 如果存在子节点，则先处理子节点
            if (head.child != null) {
                // 递归，得到子链表的最后一个非空节点
                Node childEnd = dsf(head.child);
                // 保存主干链表的下一个节点
                Node next = head.next;
                // 将主链表和子链表进行连接
                head.next = head.child;
                head.child.prev = head;
                //如果之前保存的主干链表的下一个节点不为空，则重新连接到新主干的末端
                if (next != null) {
                    childEnd.next = next;
                    next.prev = childEnd;
                }
                // 将子节点置空
                head.child = null;
            }
            last = head;
            head = head.next;

        }
        return last;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}
