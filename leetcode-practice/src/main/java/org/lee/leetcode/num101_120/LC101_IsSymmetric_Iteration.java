package org.lee.leetcode.num101_120;

import org.lee.leetcode.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class LC101_IsSymmetric_Iteration {

    public boolean isSymmetric(TreeNode root) {
        Deque<TreeNode> queue1 = new LinkedList<>();
        Deque<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root.left);
        queue2.offer(root.right);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode n1 = queue1.poll();
            TreeNode n2 = queue2.poll();
            if (n1 == null && n2 == null)
                continue;
            else if (n1 != null && n2 == null)
                return false;
            else if (n1 == null && n2 != null)
                return false;
            else if (n1.val != n2.val)
                return false;
            else {
               queue1.offer(n1.left);
               queue1.offer(n1.right);
               queue2.offer(n2.right);
               queue2.offer(n2.left);
            }
        }
        return queue1.isEmpty() && queue2.isEmpty();
    }

}
