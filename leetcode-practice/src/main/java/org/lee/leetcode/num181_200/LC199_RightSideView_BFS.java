package org.lee.leetcode.num181_200;

import org.lee.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC199_RightSideView_BFS {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr != null) {
                if (queue.peek() == null)
                    res.add(curr.val);
                if (curr.left != null)
                    queue.offer(curr.left);
                if (curr.right != null)
                    queue.offer(curr.right);
            } else {
               if (queue.isEmpty())
                   break;
               queue.offer(null);
            }
        }
        return res;
    }

}
