package org.lee.leetcode.num141_160;

import java.util.LinkedList;

public class LC155_MinStack {

    public static class MinStack {

        private final LinkedList<int[]> stack = new LinkedList<>();

        public MinStack() {}

        public void push(int val) {
            LinkedList<int[]> l = stack;
            if (l.isEmpty())
                l.push(new int[] {val, val});
            else {
                int[] top = l.peek();
                int[] n = new int[] {val, Math.min(val, top[1])};
                l.push(n);
            }
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek()[0];
        }

        public int getMin() {
            return stack.peek()[1];
        }
    }

}
