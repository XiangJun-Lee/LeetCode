package com.leetcode2022.March;

import org.junit.Test;

/**
 * @author leelixiangjun
 * @date 2022/3/23 15:38
 */
public class March23 {
    /**
     * 题目中要求[1-n]个数，按照字典序排序，找到第k个数字并输出。
     * 如果将[1-n]插入到字典树中，然后按照前序遍历，得到的就是字典序。
     * 常规思路：将[1-n]插入到字典树中，按照前序遍历遍历到第k个数，数据即可。但这样，就需要花时间构建一个字典树。
     * <p>
     * 解题思路:按照某个前缀作为节点进行遍历。
     * 假如：n=1012,k=899
     * 1.计算字典树以1开头的节点个数：[1],[10-19],[100-199],[1000-1012] 一共1+10+100+13=124个节点 [first,last] = last-first +1
     * 2.以相同的方式计算2开头的节点个数：[2],[20-29],[200-299] 因为2000>1012,因此不会存在2000及以后的节点。一共111个节点
     * 3.以此类推当计算到124(1)+111(2)+111(3)+111(4)+111(5)+111(6)+111(7)=790+111(8)=901
     * 4.因此，第k个数肯定在前缀为8的节点中。
     * 以相同的方式，找下一个前缀为89
     * 最后得到 第k个数是897
     */
    public int findKthNumber(int n, int k) {
        // curr 遍历过程中，字典树当前节点的值
        // count 遍历过程中，字典序当前节点的位置
        int curr = 1, count = 1;
        while (count < k) {
            // 计算以curr为根节点，下方子节点的个数为steps
            int steps = getSteps(curr, n);
            if (steps + count <= k) {
                // 如果当前根节点的位置+子节点的个数≤k,则表示位置k在curr相邻的兄弟节点中
                // curr相邻的兄弟节点为curr+1
                // curr+1节点的字典序的位置为count+steps
                count += steps;
                curr++;
            } else {
                // 如果当前根节点的位置+子节点的个数＞k，则表示位置k在curr的子树中
                // curr最左孩子节点是 curr*10
                curr = curr * 10;
                // 选中下一个节点，当前位置+1
                count++;
            }
        }
        return curr;
    }

    // 计算以curr为根节点，其下方共有多少个子节点
    private int getSteps(int curr, long n) {
        // 统计的curr为根节点的子节点(叶子节点+非叶子节点)个数
        int steps = 0;
        // first为某一层节点的第一个节点，last为某一层节点的最后一个孩子
        long first = curr;
        long last = curr;
        // 每次迭代下沉一层。下沉一层后，first = first * 10，last = last * 10 + 9 。
        // 直到新的一层的第一个节点的位置>n
        while (first <= n) {
            // 累加这一层的节点个数
            steps += Math.min(last, n) - first + 1;
            first = first * 10;
            last = last * 10 + 9;
        }
        return steps;
    }

    @Test
    public void test() {
        int n = 1012, k = 899;
        System.out.println(findKthNumber(n, k));
    }
}
