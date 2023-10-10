package org.lee.leetcode.num101_120;

import org.lee.leetcode.common.TreeNode;
import java.util.LinkedList;
import java.util.List;

public class LC113_PathSum_DFS {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        dfs(root, 0, targetSum, path, res);
        return res;
    }

    private void dfs(TreeNode n, int sum, int targetSum, LinkedList<Integer> path,
                     List<List<Integer>> res) {
        if (n == null)
            return;
        sum += n.val;
        path.add(n.val);
        if (n.left == null && n.right == null) {
            if (sum == targetSum)
                res.add(new LinkedList<>(path));
        } else {
            dfs(n.left, sum, targetSum, path, res);
            dfs(n.right, sum, targetSum, path, res);
        }
        path.removeLast();
    }

}
