package com.cyq7on.leetcode.tree;

/**
 * @author cyq7on
 * @description 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 * <p>
 * 示例 :
 * 给定二叉树
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 * <p>
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @create 2020/3/10
 **/
public class DiameterOfBinaryTree {
    private int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        treeHeight(root);
        return diameter;
    }

    private int treeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = treeHeight(root.left);
        int right = treeHeight(root.right);
        int sum = left + right;
        if (diameter < sum) {
            diameter = sum;
        }
        return 1 + Math.max(left, right);
    }
}
