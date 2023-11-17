package org.lee.leetcode.num721_740;

import org.lee.leetcode.common.Array;

import java.util.LinkedList;

public class LC739_DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int idx = stack.pop();
                ans[idx] = i - idx;
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        testCase();
        testCase1();
        testCase2();
        testCase3();
    }

    public static void testCase() {
        int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };
        int[] ans = dailyTemperatures(temperatures);
        Array.print(ans);
    }

    public static void testCase1() {
        int[] temperatures = { 30, 40, 50, 60 };
        int[] ans = dailyTemperatures(temperatures);
        Array.print(ans);
    }

    public static void testCase2() {
        int[] temperatures = { 30, 60, 90 };
        int[] ans = dailyTemperatures(temperatures);
        Array.print(ans);
    }

    public static void testCase3() {
        int[] temperatures = { 30, 30, 90 };
        int[] ans = dailyTemperatures(temperatures);
        Array.print(ans);
    }

}
