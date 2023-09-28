package org.lee.leetcode.num81_100;

import org.lee.leetcode.common.TreeNode;

public class LC98_IsValidBST_Recursion {

    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode n, long lower, long upper) {
        if (n == null)
            return true;
        if (n.val <= lower || n.val >= upper)
            return false;
        if (!dfs(n.left, lower, n.val))
            return false;
        return dfs(n.right, n.val, upper);
    }

}
