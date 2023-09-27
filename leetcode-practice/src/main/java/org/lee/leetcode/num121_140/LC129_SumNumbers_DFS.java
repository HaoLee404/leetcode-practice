package org.lee.leetcode.num121_140;

import org.lee.leetcode.common.TreeNode;

public class LC129_SumNumbers_DFS {

    private int sum;

    public int sumNumbers(TreeNode root) {
        sum = 0;
        sumNumbers(root, 0);
        return sum;
    }

    private void sumNumbers(TreeNode n, int num) {
        if (n != null) {
            num += n.val;
            if (n.left == null && n.right == null)
                sum += num;
            else {
                sumNumbers(n.left, num * 10);
                sumNumbers(n.right, num * 10);
            }
        }
    }

}
