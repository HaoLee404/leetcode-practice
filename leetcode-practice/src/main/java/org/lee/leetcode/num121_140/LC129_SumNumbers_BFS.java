package org.lee.leetcode.num121_140;

import org.lee.leetcode.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class LC129_SumNumbers_BFS {

    public int sumNumbers(TreeNode root) {
        int sum = 0;
        Deque<TreeNode> nodeQueue = new LinkedList<>();
        Deque<Integer> numQueue = new LinkedList<>();
        nodeQueue.offer(root);
        numQueue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode n = nodeQueue.poll();
            int num = numQueue.poll();
            if (n.left == null && n.right == null)
                sum += num;
            else {
                int num1 = num * 10;
                if (n.left != null) {
                    nodeQueue.offer(n.left);
                    numQueue.offer(num1 + n.left.val);
                }
                if (n.right != null) {
                    nodeQueue.offer(n.right);
                    numQueue.offer(num1 + n.right.val);
                }
            }
        }
        return sum;
    }

}
