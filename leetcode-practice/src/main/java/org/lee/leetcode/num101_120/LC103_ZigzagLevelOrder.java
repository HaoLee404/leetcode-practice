package org.lee.leetcode.num101_120;

import org.lee.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC103_ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        boolean l2r = true;
        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> level = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        while (!queue.isEmpty()) {
            TreeNode n = queue.poll();
            if (n != null) {
                if (l2r)
                    level.add(n.val);
                else
                    level.addFirst(n.val);
                if (n.left != null)
                    queue.offer(n.left);
                if (n.right != null)
                    queue.offer(n.right);
            } else {
                res.add(level);
                if (queue.isEmpty())
                    break;
                queue.offer(null);
                level = new LinkedList<>();
                l2r = !l2r;
            }
        }
        return res;
    }

}
