package com.cyq7on.sword2offer.tree;

import com.cyq7on.leetcode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author cyq7on
 * @description
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 *
 *  
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *  
 *
 * 提示：
 *
 * 节点总数 <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @create 2020/2/24
 **/
public class BinaryTreeLevelOrderTraversal3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }
        List<List<Integer>> res = new ArrayList<>();
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        boolean b = true;
        int i = 0;
        while (i < queue.size()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            int k = 0;
            for (; i < size; i++,k++) {
                TreeNode node = queue.get(i);
                if (b) {
                    list.add(node.val);
                }else {
                    list.add(queue.get(size - 1 - k).val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            b = !b;
            res.add(list);
        }
        return res;
    }
}
