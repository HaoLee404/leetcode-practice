package org.lee.leetcode.num81_100;

import org.lee.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class LC94_InorderTraversal_Iteration {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null)
            return res;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.peek();
            if (top.left != null)
                stack.push(top.left);
            else {
                while (!stack.isEmpty()) {
                    TreeNode n = stack.pop();
                    res.add(n.val);
                    if (n.right != null) {
                        stack.push(n.right);
                        break;
                    }
                }
            }
        }

        return res;
    }
}
