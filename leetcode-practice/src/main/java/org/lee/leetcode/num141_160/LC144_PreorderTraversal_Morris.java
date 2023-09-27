package org.lee.leetcode.num141_160;

import org.lee.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class LC144_PreorderTraversal_Morris {

    public List<Integer> preorderTraversal(TreeNode root) {
        TreeNode curr = root;
        List<Integer> res = new LinkedList<>();
        while (curr != null) {
            if (curr.left != null) {
                TreeNode mostRight = findMostRight(curr);
                if (mostRight.right == null) {
                    res.add(curr.val);
                    mostRight.right = curr;
                    curr = curr.left;
                } else if (mostRight.right == curr) {
                    mostRight.right = null;
                    curr = curr.right;
                }
            } else {
                res.add(curr.val);
                curr = curr.right;
            }
        }
        return res;
    }

    private TreeNode findMostRight(TreeNode n) {
        TreeNode curr = n.left;
        while (curr.right != null && curr.right != n)
            curr = curr.right;
        return curr;
    }

}
