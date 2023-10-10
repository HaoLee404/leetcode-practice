package org.lee.leetcode.num21_40;

import java.util.LinkedList;
import java.util.List;

public class LC39_CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        backtrace(candidates, target, 0, 0, new LinkedList<>(), res);
        return res;
    }

    private void backtrace(int[] candidates, int target, int sum, int begin,
                           LinkedList<Integer> path, List<List<Integer>> res) {
        if (sum > target)
            return;
        else if (sum == target) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            sum += candidates[i];
            path.add(candidates[i]);
            backtrace(candidates, target, sum, i, path, res);
            sum -= candidates[i];
            path.removeLast();
        }
    }

}
