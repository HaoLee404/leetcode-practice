package org.lee.leetcode.num81_100;

import org.lee.leetcode.common.TreeNode;

public class LC98_IsValidBST_InOrderTraversal {

    private long prevVal = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        return inOrderTraversal(root);
    }

    private boolean inOrderTraversal(TreeNode n) {
        if (n == null)
            return true;
        if (!inOrderTraversal(n.left))
            return false;
        if (n.val <= prevVal)
            return false;
        prevVal = n.val;
        return inOrderTraversal(n.right);
    }

}
