package com.LeetCode;

/**
 * @author leelixiangjun
 * @date 2021/10/11 19:57
 * @desciption 并查集
 */
public class DisjointSet {
    private static final int MAX = Integer.MAX_VALUE;
    private final int[] set;

    public DisjointSet() {
        this.set = new int[MAX];
    }

    public void init() {
        for (int i = 0; i < MAX; i++) {
            set[i] = i;
        }
    }

    public int find(int x) {
        return set[x] == x ? x : (set[x] = find(set[x]));
    }

    public void merge(int x, int y) {
        // 先找到两个节点的根节点
        int rootX = find(x);
        int rootY = find(y);
        // 将x的根节点的父节点设置为y的根节点
        set[rootX] = rootY;
    }
}
