package com.cyq7on.sword2offer.tree;

import com.cyq7on.leetcode.tree.TreeNode;

import java.util.*;
import java.util.function.Function;

/**
* @description
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
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
 * 返回：
 *
 * [3,9,20,15,7]
 *  
 *
 * 提示：
 *
 * 节点总数 <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* @author cyq7on
* @create 2020/2/24
**/
public class BinaryTreeLevelOrderTraversal {
    //LeetCode测试1ms，比第一个方法快了1ms，优化的地方在于不额外存储val
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        int i = 0;
        while (i < queue.size()) {
            TreeNode node = queue.get(i);
            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
            i++;
        }
        int[] arr = new int[queue.size()];
        for (i = 0; i < queue.size(); i++) {
            arr[i] = queue.get(i).val;
        }
        return arr;
    }

    public int[] levelOrder0(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
