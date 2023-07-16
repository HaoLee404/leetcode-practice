package org.lee.leetcode.num221_240;

import org.lee.leetcode.common.TreeNode;

public class LC236_LowestCommonAncestor {

    private TreeNode res;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        res = null;
        find(root, p, q);
        return res;
    }

    private boolean find(TreeNode n, TreeNode p, TreeNode q) {
        if (res != null)
            return true;
        if (n == null)
            return false;
        boolean leftFound = find(n.left, p, q);
        boolean rightFound = find(n.right, p, q);
        if (leftFound && rightFound) {
            if (res == null)
                res = n;
            return true;
        }
        boolean found = false;
        if (n == p || n == q) {
            found = true;
            if (leftFound || rightFound) {
                res = n;
                return true;
            }
        }
        return leftFound || rightFound || found;
    }

}
