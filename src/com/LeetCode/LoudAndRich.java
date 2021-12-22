package com.LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author leelixiangjun
 * @date 2021/12/15 15:45
 */
public class LoudAndRich {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int personSize = quiet.length;
        List<Integer>[] personList = new List[personSize];
        // 初始化richer列表
        for (int i = 0; i < personList.length; i++) {
            personList[i] = new ArrayList<>();
        }
        for (int[] person : richer) {
            personList[person[1]].add(person[0]);
        }
        int[] ans = new int[personSize];
        for (int i = 0; i < personList.length; i++) {
            ans[i] = quietest(dfs(i, personList).stream().distinct().collect(Collectors.toList()), quiet);
        }

        return ans;
    }

    private int quietest(List<Integer> personList, int[] quiet) {
        int ans = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (Integer i : personList) {
            if (min > quiet[i]) {
                min = quiet[i];
                ans = i;
            }
        }
        return ans;
    }

    private List<Integer> dfs(int person, List<Integer>[] personList) {
        if (personList[person].size() == 0) {
            return Collections.singletonList(person);
        }
        List<Integer> richerPerson = new ArrayList<>();
        richerPerson.addAll(personList[person]);
        richerPerson.add(person);
        for (Integer p : personList[person]) {
            richerPerson.addAll(dfs(p, personList));
        }
        return richerPerson.stream().distinct().collect(Collectors.toList());
    }

    @Test
    public void test() {
        int[][] richer = {{1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}};
        int[] quiet = {3, 2, 5, 4, 6, 1, 7, 0};
        System.out.println(Arrays.toString(loudAndRich(richer, quiet)));
    }
}
