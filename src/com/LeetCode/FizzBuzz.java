package com.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author leelixiangjun
 * @date 2021/10/13 10:19
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        return IntStream.range(1, n + 1)
                .mapToObj(i -> i % 15 == 0 ? "FizzBuzz" : i % 5 == 0 ? "Buzz" : i % 3 == 0 ? "Fizz" : String.valueOf(i))
                .collect(Collectors.toList());
    }
}
