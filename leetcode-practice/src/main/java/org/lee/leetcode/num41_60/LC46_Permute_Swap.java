package org.lee.leetcode.num41_60;

import java.util.ArrayList;
import java.util.List;

public class LC46_Permute_Swap {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, int first) {
        if (first == nums.length) {
            res.add(toList(nums));
            return;
        }
        for (int i = first; i < nums.length; i++) {
            swap(nums, first, i);
            dfs(res, nums, first + 1);
            swap(nums, first, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int d = nums[i];
        nums[i] = nums[j];
        nums[j] = d;
    }

    private List<Integer> toList(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length);
        for (int num : nums)
            list.add(num);
        return list;
    }

}
