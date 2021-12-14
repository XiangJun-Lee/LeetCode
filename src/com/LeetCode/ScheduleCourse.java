package com.LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author leeixiangjun
 * @date 2021/12/14 11:27 下午
 */
public class ScheduleCourse {
    public int scheduleCourse(int[][] courses) {
        // 按照课程结束时间，升序排序
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        // 创建队列，按照降序存储上课的时间长短
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int total = 0;
        for (int[] course : courses) {
            int ti = course[0], di = course[1];
            // 如果当前课程时间不冲突，将该课程加入队列
            if (total + ti <= di) {
                total += ti;
                queue.offer(ti);
            } else if (!queue.isEmpty() && queue.peek() > ti) {
                // 课程时间冲突，且有选过其他课，这时我们找到最长时间的课程，用当前的短课替换了，余出了更多的空区间
                // 所以这里我们余出的时间其实就是两者的持续时间之差，课程变短了，day会前移，这样我们相当于变相给后面的课程增加了选择的区间
                total -= queue.poll() - ti;
                queue.offer(ti);
            }
        }
        return queue.size();
    }
}
