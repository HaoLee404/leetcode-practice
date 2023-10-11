package org.lee.leetcode.num101_120;

import org.lee.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LC112_HasPathSum_BFS {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();
        nodeQueue.offer(root);
        sumQueue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode n = nodeQueue.poll();
            Integer sum = sumQueue.poll();
            if (n.left == null && n.right == null) {
                if (sum == targetSum)
                    return true;
            } else {
                if (n.left != null) {
                    nodeQueue.offer(n.left);
                    sumQueue.offer(sum + n.left.val);
                }
                if (n.right != null) {
                    nodeQueue.offer(n.right);
                    sumQueue.offer(sum + n.right.val);
                }
            }
        }
        return false;
    }

}
