package org.lee.leetcode.num121_140;

import org.lee.leetcode.common.TreeNode;

public class LC124_MaxPathSum {

    private int maxPathSum;

    public int maxPathSum(TreeNode root) {
        maxPathSum = root.val;
        dfs(root);
        return maxPathSum;
    }

    private int dfs(TreeNode n) {
        if (n == null)
            return 0;
        int maxSumLeft = dfs(n.left);
        int maxSumRight = dfs(n.right);
        int val = n.val;
        int sumWithLeft = maxSumLeft + val;
        int sumWithRight = maxSumRight + val;
        int sumWithBoth = sumWithLeft + maxSumRight;
        int res = Math.max(Math.max(val, sumWithLeft), sumWithRight);
        maxPathSum = Math.max(maxPathSum, Math.max(res, sumWithBoth));
        return res;
    }

}
