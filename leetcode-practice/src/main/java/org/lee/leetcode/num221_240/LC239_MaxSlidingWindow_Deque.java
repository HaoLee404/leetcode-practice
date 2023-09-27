package org.lee.leetcode.num221_240;

import java.util.Deque;
import java.util.LinkedList;

public class LC239_MaxSlidingWindow_Deque {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int l = 0, r = 0, i = 0; r < len; r++) {
            while (!deque.isEmpty() && nums[r] >= nums[deque.peekLast()])
                deque.pollLast();
            deque.offerLast(r);
            if (r - l + 1 == k) {
                int head = deque.peek();
                res[i++] = nums[head];
                if (head <= l++)
                    deque.poll();
            }
        }
        return res;
    }

}
