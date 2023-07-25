package org.lee.leetcode.num41_60;

import java.util.LinkedList;

public class LC42_Trap_Stack {

    public int trap(int[] height) {
        LinkedList<Integer> stack = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty())
                    break;
                int left = stack.peek();
                int width = i - left - 1;
                int h = Math.min(height[left], height[i]) - height[top];
                res += width * h;
            }
            stack.push(i);
        }
        return res;
    }

}
