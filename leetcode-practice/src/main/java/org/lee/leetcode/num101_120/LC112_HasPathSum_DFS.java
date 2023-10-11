package org.lee.leetcode.num101_120;

import org.lee.leetcode.common.TreeNode;

public class LC112_HasPathSum_DFS {

    private int sum;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        sum = 0;
        return dfs(root, targetSum);
    }

    private boolean dfs(TreeNode n, int targetSum) {
        boolean res = false;
        if (n == null)
            return res;
        sum += n.val;
        if (n.left == null && n.right == null)
            res = sum == targetSum;
        else {
            res = dfs(n.left, targetSum);
            if (!res)
                res = dfs(n.right, targetSum);
        }
        sum -= n.val;

        return res;
    }

}
