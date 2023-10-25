package org.lee.leetcode.num221_240;

import org.lee.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LC226_InvertTree_BFS {

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode n = queue.poll();
            TreeNode dummy = n.left;
            n.left = n.right;
            n.right = dummy;
            if (n.left != null)
                queue.offer(n.left);
            if (n.right != null)
                queue.offer(n.right);
        }
        return root;
    }

}
