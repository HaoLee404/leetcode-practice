package org.lee.leetcode.num221_240;

import org.lee.leetcode.common.TreeNode;

public class LC226_InvertTree_DFS {

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode dummy = root.left;
        root.left = root.right;
        root.right = dummy;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}
