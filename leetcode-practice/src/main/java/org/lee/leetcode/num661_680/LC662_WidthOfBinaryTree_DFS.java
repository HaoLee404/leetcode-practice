package org.lee.leetcode.num661_680;

import org.lee.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class LC662_WidthOfBinaryTree_DFS {

    Map<Integer, Integer> levelMinNum = new HashMap<>();

    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 1, 1);
    }

    private int dfs(TreeNode n, int depth, int num) {
        if (n == null)
            return 0;
        levelMinNum.putIfAbsent(depth, num);
        int nextDepth = depth + 1, num1 = num << 1;
        return Math.max(num - levelMinNum.get(depth) + 1, Math.max(dfs(n.left, nextDepth, num1), dfs(n.right, nextDepth, num1 + 1)));
    }

}
