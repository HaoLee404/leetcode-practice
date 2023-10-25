package org.lee.leetcode.num661_680;

import org.lee.leetcode.common.TreeNode;

import java.util.*;

public class LC662_WidthOfBinaryTree_BFS {

    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        nodeQueue.offer(null);
        Queue<Integer> numQueue = new LinkedList<>();
        numQueue.offer(1);
        int maxWidth = 0, begin = 0, width = 0;
        boolean beginAbsent = true;
        while (!nodeQueue.isEmpty()) {
            TreeNode n = nodeQueue.poll();
            if (n != null) {
                int num = numQueue.poll();
                if (beginAbsent) {
                    begin = num;
                    beginAbsent = false;
                }
                width = num - begin + 1;
                if (n.left != null) {
                    nodeQueue.offer(n.left);
                    numQueue.offer(num << 1);
                }
                if (n.right != null) {
                    nodeQueue.offer(n.right);
                    numQueue.offer((num << 1) + 1);
                }
            } else {
                maxWidth = Math.max(maxWidth, width);
                if (nodeQueue.isEmpty())
                    break;
                nodeQueue.offer(null);
                beginAbsent = true;
            }
        }
        return maxWidth;
    }

}
