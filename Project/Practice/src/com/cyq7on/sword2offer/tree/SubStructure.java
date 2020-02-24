package com.cyq7on.sword2offer.tree;

import com.cyq7on.leetcode.tree.TreeNode;

public class SubStructure {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null) {
            return false;
        }else if (B == null) {
            return false;
        }
        return isMatch(A, B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }

    private boolean isMatch(TreeNode A , TreeNode B) {
        if (A == null) {
            return false;
        }

        if (A.val == B.val) {
            boolean b = true;
            if (B.left != null) {
                b = isMatch(A.left,B.left);
            }
            if (B.right != null) {
                b = b && isMatch(A.right, B.right);
            }
            return b;
        }
        return false;
    }
}
