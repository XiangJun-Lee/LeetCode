package com.leetcode2022;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author leelixiangjun
 * @date 2021/10/13 11:01
 */
public class DestCity {
    public String destCity(List<List<String>> paths) {
        Set<String> citiesA = new HashSet<String>();
        for (List<String> path : paths) {
            citiesA.add(path.get(0));
        }
        for (List<String> path : paths) {
            if (!citiesA.contains(path.get(1))) {
                return path.get(1);
            }
        }
        return "";
    }
}
