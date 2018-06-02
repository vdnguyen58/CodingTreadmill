package com.vonguyen.leetcode.medium;

import com.vonguyen.leetcode.common.TreeNode;

public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 != null || t2 != null) {
            if (t1 != null && t2 != null) {
                TreeNode t = new TreeNode(t1.val + t2.val);
                t.left = mergeTrees(t1.left, t2.left);
                t.right = mergeTrees(t1.right, t2.right);
                return t;
            } else if (t1 == null) {
                return t2;
            } else {
                return t1;
            }
        } else {
            return null;
        }
    }
}
