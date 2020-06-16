package com.cyq7on.sword2offer.tree;

import com.cyq7on.leetcode.tree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


/**
* @description
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 示例: 
 *
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 *
 * 通过次数15,165提交次数33,862
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* @author cyq7on
* @create 2020/2/28
**/
public class Codec2 {
    // Encodes a tree to a single string.
    //使用层序遍历
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("null").append(",");
            }else {
                sb.append(node.val).append(",");
                TreeNode left = node.left;
                TreeNode right = node.right;

                queue.offer(left);
                queue.offer(right);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] split = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!split[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(split[i]));
                queue.add(node.left);
            }
            i++;
            if (!split[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(split[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3, new TreeNode(4), new TreeNode(5));
        Codec2 codec = new Codec2();
        String serialize = codec.serialize(root);
        System.out.println(serialize);
        System.out.println(codec.deserialize(serialize));
    }
}
