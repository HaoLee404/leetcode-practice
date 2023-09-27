package org.lee.leetcode.num101_120;

import org.lee.leetcode.common.TreeNode;

import java.util.HashMap;

public class LC105_BuildTree_Recursion {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxIndex = inorder.length - 1;
        for (int i = 0; i <= maxIndex; i++)
            map.put(inorder[i], i);
        return buildTree(preorder, 0, maxIndex, map, 0, maxIndex);
    }

    private TreeNode buildTree(int[] preorder, int preorderLo, int preorderHi,
                               HashMap<Integer, Integer> inorder, int inorderLo, int inorderHi) {
        if (preorderLo > preorderHi || inorderLo > inorderHi)
            return null;
        TreeNode root = new TreeNode(preorder[preorderLo]);
        int rootIndex = inorder.get(preorder[preorderLo]);

        int rightCount = inorderHi - rootIndex, leftCount = rootIndex - inorderLo;

        int preorderBegin = preorderLo + 1, preorderEnd = preorderLo + leftCount;
        root.left = buildTree(preorder, preorderBegin, preorderEnd, inorder, inorderLo, rootIndex - 1);

        preorderBegin = preorderEnd + 1;
        preorderEnd = preorderEnd + rightCount;
        root.right = buildTree(preorder, preorderBegin, preorderEnd, inorder, rootIndex + 1, inorderHi);

        return root;
    }

}
