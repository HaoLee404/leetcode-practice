package org.lee.leetcode.num21_40;

import java.util.LinkedList;
import java.util.List;

public class LC22_GenerateParenthesis {

    private int left;

    private int right;

    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        if (n <= 0)
            return res;
        left = n;
        right = n;
        char[] arr = new char[n << 1];
        backtrace(arr, 0, res);

        return res;
    }

    private void backtrace(char[] arr, int index, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(new String(arr));
            return;
        }
        if (left == right) {
            arr[index] = '(';
            --left;
            backtrace(arr, index + 1, res);
            ++left;
        } else {
            if (left > 0) {
                arr[index] = '(';
                --left;
                backtrace(arr, index + 1, res);
                ++left;
            }
            if (right > 0) {
                arr[index] = ')';
                --right;
                backtrace(arr, index + 1, res);
                ++right;
            }
        }
    }

    public static void testCase() {
        LC22_GenerateParenthesis ins = new LC22_GenerateParenthesis();
        List<String> res = ins.generateParenthesis(3);
        for (String str : res)
            System.out.println(str);
    }

    public static void main(String[] args) {
        testCase();
    }

}
