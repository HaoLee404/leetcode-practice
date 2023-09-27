package org.lee.leetcode.num221_240;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC239_MaxSlidingWindow_PriorityQueue {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length, size = len - k + 1;
        PriorityQueue<int[]> queue = new PriorityQueue<>(size, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        int[] res = new int[size];
        for (int l = 0, r = 0, i = 0; r < len; r++) {
            queue.offer(new int[] {nums[r], r});
            if (r - l + 1 == k) {
                int[] ele = queue.peek();
                for (; ele[1] < l; ele = queue.peek())
                    queue.poll();
                res[i++] = ele[0];
                l++;
            }
        }
        return res;
    }

}
