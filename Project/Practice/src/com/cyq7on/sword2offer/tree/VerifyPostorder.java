package com.cyq7on.sword2offer.tree;

/**
 * @author cyq7on
 * @description 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * <p>
 *  
 * <p>
 * 参考以下这颗二叉搜索树：
 * <p>
 * 5
 * / \
 * 2   6
 * / \
 * 1   3
 * 示例 1：
 * <p>
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 * <p>
 * 输入: [1,3,2,6,5]
 * 输出: true
 *  
 * <p>
 * 提示：
 * <p>
 * 数组长度 <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @create 2020/2/25
 **/
public class VerifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return true;
        }
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    private boolean verifyPostorder(int[] postorder, int left, int right) {
        if (right - left <= 0) {
            return true;
        }
        int root = postorder[right];
        int i = left;
        int index;
        while (i <= right && postorder[i] < root) {
            i++;
        }
        boolean l = true;
        index = i - 1;
        if (index > left) {
            l = verifyPostorder(postorder, left, index);
        }
        while (i < right) {
            if (postorder[i] < root) {
                return false;
            }
            i++;
        }
        boolean r = true;
        if (i == right) {
            r =  verifyPostorder(postorder, index + 1, right - 1);
        }
        return l && r;
    }

    public static void main(String[] args) {
        VerifyPostorder verifyPostorder = new VerifyPostorder();
        System.out.println(verifyPostorder.verifyPostorder(new int[] {3,10,6,9,2}));
        System.out.println(verifyPostorder.verifyPostorder(new int[] {5, 2, -17, -11, 25, 76, 62, 98, 92, 61}));
        System.out.println(verifyPostorder.verifyPostorder(new int[] {7, 4, 6, 5}));
        System.out.println(verifyPostorder.verifyPostorder(new int[] {4, 6,7,5}));
        System.out.println(verifyPostorder.verifyPostorder(new int[] {1, 2, 3, 4, 5}));
    }
}
