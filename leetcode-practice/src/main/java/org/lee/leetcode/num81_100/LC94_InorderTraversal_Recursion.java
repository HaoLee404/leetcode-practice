package org.lee.leetcode.num81_100;

import org.lee.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class LC94_InorderTraversal_Recursion {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        inorderTraversal(root, res);
        return res;
    }

    private void inorderTraversal(TreeNode n, List<Integer> res) {
        if (n == null)
            return;
        inorderTraversal(n.left, res);
        res.add(n.val);
        inorderTraversal(n.right, res);
    }


}
