package org.lee.leetcode.num181_200;

import org.lee.leetcode.common.TreeNode;

import java.util.*;

public class LC199_RightSideView_DFS {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        Map<Integer, Integer> depthRightMostValue = new HashMap<>();
        int maxDepth = -1;
        Deque<TreeNode> nodeStack = new LinkedList<>();
        Deque<Integer> depthStack = new LinkedList<>();
        nodeStack.push(root);
        depthStack.push(0);
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            Integer depth = depthStack.pop();
            maxDepth = Math.max(maxDepth, depth);
            if (!depthRightMostValue.containsKey(depth))
                depthRightMostValue.put(depth, node.val);
            int depth1 = depth + 1;
            if (node.left != null) {
                nodeStack.push(node.left);
                depthStack.push(depth1);
            }
            if (node.right != null) {
                nodeStack.push(node.right);
                depthStack.push(depth1);
            }
        }
        List<Integer> res = new ArrayList<>(depthRightMostValue.size());
        for (int i = 0; i <= maxDepth; i++)
            res.add(depthRightMostValue.get(i));

        return res;
    }

}
