package com.cyq7on.sword2offer.tree;

import com.cyq7on.leetcode.tree.TreeNode;

/**
* @description
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* @author cyq7on
* @create 2020/3/3
**/
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
