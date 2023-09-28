package org.lee.leetcode.num101_120;

import org.lee.leetcode.common.TreeNode;

public class LC101_IsSymmetric_Recursion {

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null)
            return true;
        else if (n1 == null && n2 != null)
            return false;
        else if (n1 != null && n2 == null)
            return false;
        else if (n1.val != n2.val)
            return false;
        else {
            if (!isSymmetric(n1.left, n2.right))
                return false;
            return isSymmetric(n1.right, n2.left);
        }
    }

}
