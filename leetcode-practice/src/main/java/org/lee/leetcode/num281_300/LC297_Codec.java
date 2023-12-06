package org.lee.leetcode.num281_300;

import org.lee.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LC297_Codec {

    public static class Codec {
        public String serialize(TreeNode root) {
            if (root == null)
                return null;
            StringBuilder res = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            res.append(root.val);
            while (!queue.isEmpty()) {
                TreeNode n = queue.poll();
                res.append(',');
                if (n.left != null) {
                    queue.offer(n.left);
                    res.append(n.left.val);
                } else
                    res.append('n');
                res.append(',');
                if (n.right != null) {
                    queue.offer(n.right);
                    res.append(n.right.val);
                } else
                    res.append('n');
            }
            return res.toString();
        }

        public TreeNode deserialize(String data) {
            if (data == null)
                return null;
            String[] arr = data.split(",");
            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
            queue.offer(root);
            int index = 1;
            while (!queue.isEmpty()) {
                TreeNode n = queue.poll();
                if (!arr[index].equals("n")) {
                    n.left = new TreeNode(Integer.parseInt(arr[index]));
                    queue.offer(n.left);
                }
                index++;
                if (!arr[index].equals("n")) {
                    n.right = new TreeNode(Integer.parseInt(arr[index]));
                    queue.offer(n.right);
                }
                index++;
            }
            return root;
        }
    }

}
