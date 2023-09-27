package org.lee.leetcode.num101_120;

import org.lee.leetcode.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class LC104_MaxDepth_BFS {

    public int maxDepth(TreeNode root) {
        int depth = 0;
        if (root == null)
            return depth;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        while (!queue.isEmpty()) {
            TreeNode n = queue.poll();
            if (n != null) {
                if (n.left != null)
                    queue.offer(n.left);
                if (n.right != null)
                    queue.offer(n.right);
            } else {
                depth++;
                if (queue.isEmpty())
                    break;
                queue.add(null);
            }
        }
        return depth;
    }

}
