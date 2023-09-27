package org.lee.leetcode.num21_40;

import java.util.LinkedList;

public class LC32_LongestValidParentheses_Stack {

    public int longestValidParentheses(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        int len = s.length();
        boolean[] arr = new boolean[len];
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            else {
                if (!stack.isEmpty()) {
                    int j = stack.pop();
                    arr[i] = true;
                    arr[j] = true;
                }
            }
        }
        int maxLen = 0;
        len = 0;
        for (boolean b : arr) {
            if (b)
                maxLen = Math.max(++len, maxLen);
            else
                len = 0;
        }

        return maxLen;
    }

}
