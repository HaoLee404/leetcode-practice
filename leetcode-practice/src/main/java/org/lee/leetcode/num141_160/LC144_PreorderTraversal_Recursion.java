package org.lee.leetcode.num141_160;

import org.lee.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class LC144_PreorderTraversal_Recursion {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        preorderTraversal(root, res);
        return res;
    }

    private void preorderTraversal(TreeNode n, List<Integer> res) {
        if (n != null) {
            res.add(n.val);
            preorderTraversal(n.left, res);
            preorderTraversal(n.right, res);
        }
    }

}
