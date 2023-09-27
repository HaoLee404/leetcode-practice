package org.lee.leetcode.num101_120;

import org.lee.leetcode.common.TreeNode;

public class LC104_MaxDepth_DFS {

    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
