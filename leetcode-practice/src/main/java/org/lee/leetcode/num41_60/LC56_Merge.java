package org.lee.leetcode.num41_60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class LC56_Merge {

    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2)
            return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        ArrayList<int[]> res = new ArrayList<>(intervals.length);
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] merged = res.get(res.size() - 1);
            if (merged[1] >= intervals[i][0])
                merged[1] = Math.max(merged[1], intervals[i][1]);
            else
                res.add(intervals[i]);
        }
        return res.toArray(new int[res.size()][]);
    }

}
