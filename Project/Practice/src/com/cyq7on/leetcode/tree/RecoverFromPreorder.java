package com.cyq7on.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
* @description
 * 我们从二叉树的根节点 root 开始进行深度优先搜索。
 *
 * 在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。
 *
 * 如果节点只有一个子节点，那么保证该子节点为左子节点。
 *
 * 给出遍历输出 S，还原树并返回其根节点 root。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入："1-2--3--4-5--6--7"
 * 输出：[1,2,5,3,4,6,7]
 * 示例 2：
 *
 *
 *
 * 输入："1-2--3---4-5--6---7"
 * 输出：[1,2,5,3,null,6,null,4,null,7]
 * 示例 3：
 *
 *
 *
 * 输入："1-401--349---90--88"
 * 输出：[1,401,null,349,88,90]
 *  
 *
 * 提示：
 *
 * 原始树中的节点数介于 1 和 1000 之间。
 * 每个节点的值介于 1 和 10 ^ 9 之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/recover-a-tree-from-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* @author cyq7on
* @create 2020/6/18
**/
public class RecoverFromPreorder {
    public TreeNode recoverFromPreorder(String S) {
        String[] valus = S.split("-");
        List<TreeNode> list = new ArrayList<>();
        //根节点添加到list中
        list.add(new TreeNode(Integer.valueOf(valus[0])));
        int level = 1;
        for (int i = 1; i < valus.length; i++) {
            if (!valus[i].isEmpty()) {
                TreeNode node = new TreeNode(Integer.valueOf(valus[i]));
                //因为是前序遍历，每层我们只需要存储一个结点即可，这个节点值有可能
                //会被覆盖，如果被覆盖了说明这个节点以及他的子节点都以及遍历过了，
                //所以我们不用考虑被覆盖问题
                list.add(level, node);
                //获取父节点
                TreeNode parent = list.get(level - 1);
                if (parent.left == null) {
                    parent.left = node;
                } else {
                    parent.right = node;
                }
                //重新赋值
                level = 1;
            } else {
                //加一层
                level++;
            }
        }
        return list.get(0);

    }

    public static void main(String[] args) {
        RecoverFromPreorder recoverFromPreorder = new RecoverFromPreorder();
        System.out.println(recoverFromPreorder.recoverFromPreorder("1-2--3---4-5--6---7"));
    }
}
