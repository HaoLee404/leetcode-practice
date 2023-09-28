package org.lee.leetcode.num541_560;

import org.lee.leetcode.common.TreeNode;

public class LC543_DiameterOfBinaryTree {

    private int diameter;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        dfs(root);
        return diameter;
    }

    private int dfs(TreeNode n) {
        if (n == null)
            return 0;
        int ld = dfs(n.left);
        int rd = dfs(n.right);
        diameter = Math.max(diameter, ld + rd);
        return Math.max(ld, rd) + 1;
    }

}
