package com.LeetCode.March;

import org.junit.Test;

/**
 * @author leeixiangjun
 * @date 2022/3/13 11:02 上午
 */
public class March13 {
    public boolean validUtf8(int[] data) {
        return validUtf8(data, 0);
    }

    private boolean validUtf8(int[] data, int index) {
        if (index >= data.length) {
            return true;
        }
        String binary = toBinaryString(data[index]);
        if (binary.charAt(0) == '0') {
            return validUtf8(data, index + 1);
        }
        int count = 0;
        for (char c : binary.toCharArray()) {
            if (c != '1') {
                break;
            }
            count++;
        }
        if (count <=1 || count > 4 || count + index > data.length) {
            return false;
        }
        for (int i = 0; i < count-1; i++) {
            String nextBinary = toBinaryString(data[index + 1 + i]);
            if (!nextBinary.startsWith("10")) {
                return false;
            }
        }

        return validUtf8(data, index + count);
    }

    private String toBinaryString(int num) {
        StringBuilder binaryBuilder = new StringBuilder();
        String binary = Integer.toBinaryString(num);
        for (int i = binary.length(); i < 8; i++) {
            binaryBuilder.append(0);
        }
        binaryBuilder.append(binary);
        return binaryBuilder.toString();
    }

    @Test
    public void test() {
        int[] data = {145};
        System.out.println(validUtf8(data));
    }

}
