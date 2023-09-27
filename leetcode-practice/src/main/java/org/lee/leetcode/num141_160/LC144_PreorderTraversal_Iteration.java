package org.lee.leetcode.num141_160;

import org.lee.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class LC144_PreorderTraversal_Iteration {

    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();
            if (n != null) {
                res.add(n.val);
                stack.push(n.right);
                stack.push(n.left);
            }
        }
        return res;
    }

}
