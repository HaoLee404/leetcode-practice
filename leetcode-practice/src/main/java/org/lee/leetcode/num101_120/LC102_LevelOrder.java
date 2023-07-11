package org.lee.leetcode.num101_120;

import org.lee.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC102_LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        List<Integer> level = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode n = queue.poll();
            if (n != null) {
                level.add(n.val);
                if (n.left != null)
                    queue.offer(n.left);
                if (n.right != null)
                    queue.offer(n.right);
            } else {
                res.add(level);
                if (queue.isEmpty())
                    break;
                level = new ArrayList<>();
                queue.offer(null);
            }
        }
        return res;
    }

}
