package com.cyq7on.sword2offer.tree;

import com.cyq7on.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


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
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.substring(0,sb.length() - 1);
    }

    private void preOrder(TreeNode root,StringBuilder sb) {
        if (root == null) {
            sb.append("null").append(",");
            return;
        }
        sb.append(root.val).append(",");
        preOrder(root.left,sb);
        preOrder(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return preOrder(new LinkedList<>(Arrays.asList(data.split(","))));
    }

    private TreeNode preOrder(LinkedList<String> list) {
        if (list.isEmpty()) {
            return null;
        }
        String val = list.remove(0);
        if (val.equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = preOrder(list);
        root.right = preOrder(list);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3, new TreeNode(4), new TreeNode(5));
        Codec codec = new Codec();
        String serialize = codec.serialize(root);
        System.out.println(serialize);
        System.out.println(codec.deserialize(serialize));
    }
}
