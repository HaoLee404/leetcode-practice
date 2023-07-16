package org.lee.leetcode.num41_60;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC46_Permute_Array {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> permute = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res,
                     LinkedList<Integer> permute, boolean[] used) {
        if (permute.size() == nums.length) {
            res.add(new ArrayList<>(permute));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                permute.add(nums[i]);
                used[i] = true;
                dfs(nums, res, permute, used);
                permute.removeLast();
                used[i] = false;
            }
        }
    }

}
