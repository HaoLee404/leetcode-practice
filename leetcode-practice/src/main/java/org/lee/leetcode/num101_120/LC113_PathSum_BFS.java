package org.lee.leetcode.num101_120;

import org.lee.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC113_PathSum_BFS {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new LinkedList<>();
        if (root != null) {
            Queue<TreeNode> nodeQueue = new LinkedList<>();
            Queue<List<Integer>> pathQueue = new LinkedList<>();
            nodeQueue.offer(root);
            pathQueue.offer(new LinkedList<>());
            while (!nodeQueue.isEmpty()) {
                TreeNode n = nodeQueue.poll();
                List<Integer> path = pathQueue.poll();
                path.add(n.val);
                if (n.left == null && n.right == null) {
                    if (sum(path) == targetSum)
                        res.add(path);
                } else {
                    if (n.left != null) {
                        nodeQueue.offer(n.left);
                        pathQueue.offer(path);
                    }
                    if (n.right != null) {
                        nodeQueue.offer(n.right);
                        pathQueue.offer(new LinkedList<>(path));
                    }
                }
            }
        }
        return res;
    }

    private int sum(List<Integer> path) {
        int sum = 0;
        for (Integer i : path)
            sum += i;
        return sum;
    }

}
