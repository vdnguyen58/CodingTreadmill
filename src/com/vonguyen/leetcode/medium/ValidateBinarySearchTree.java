package com.vonguyen.leetcode.medium;

import com.vonguyen.leetcode.common.TreeNode;

public class ValidateBinarySearchTree {

    private boolean isBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        return (min < root.val && root.val < max
                        && isBST(root.left, min, root.val)
                        && isBST(root.right, root.val, max));
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        long max = Long.MAX_VALUE;
        long min = -Long.MAX_VALUE;
        return isBST(root, min, max);
    }
}
