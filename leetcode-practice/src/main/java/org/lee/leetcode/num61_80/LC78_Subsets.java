package org.lee.leetcode.num61_80;

import java.util.LinkedList;
import java.util.List;

public class LC78_Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        backtrace(nums, 0, new LinkedList<>(), res);
        return res;
    }

    private void backtrace(int[] nums, int i, LinkedList<Integer> list, List<List<Integer>> res) {
        if (i >= nums.length) {
            res.add(new LinkedList<>(list));
            return;
        }
        list.add(nums[i]);
        backtrace(nums, i + 1, list, res);
        list.removeLast();
        backtrace(nums, i + 1, list, res);
    }

}
