package com.LeetCode.April;

import org.junit.Test;

/**
 * @author leelixiangjun
 * @date 2022/4/9 23:11
 */
public class April9 {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (sx > tx || sy > ty) {
            return false;
        }
        if (sx == tx) {
            return (ty - sy) % sx == 0;
        }
        if (sy == ty) {
            return (tx - sx) % sy == 0;
        }
        return tx > ty ? reachingPoints(sx, sy, tx % ty, ty) : reachingPoints(sx, sy, tx, ty % tx);
    }

}
