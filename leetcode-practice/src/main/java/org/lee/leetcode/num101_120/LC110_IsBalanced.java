package org.lee.leetcode.num101_120;

import org.lee.leetcode.common.TreeNode;

public class LC110_IsBalanced {

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int leftHeight = height(root.left);
        if (leftHeight < 0)
            return false;
        int rightHeight = height(root.right);
        if (rightHeight < 0)
            return false;
        return Math.abs(leftHeight - rightHeight) < 2;
    }

    private int height(TreeNode n) {
        if (n == null)
            return 0;
        int leftHeight = height(n.left);
        if (leftHeight < 0)
            return leftHeight;
        int rightHeight = height(n.right);
        if (rightHeight < 0)
            return rightHeight;
        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        else
            return Math.max(leftHeight, rightHeight) + 1;
    }

}
