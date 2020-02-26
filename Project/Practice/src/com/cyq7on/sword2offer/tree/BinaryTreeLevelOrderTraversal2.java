package com.cyq7on.sword2offer.tree;

import com.cyq7on.leetcode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author cyq7on
 * @description 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @create 2020/2/24
 **/
public class BinaryTreeLevelOrderTraversal2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }
        List<List<Integer>> res = new ArrayList<>();
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        int i = 0;
        while (i < queue.size()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (; i < size; i++) {
                TreeNode node = queue.get(i);
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
