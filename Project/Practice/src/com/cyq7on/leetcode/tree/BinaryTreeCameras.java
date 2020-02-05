package com.cyq7on.leetcode.tree;


/**
 * @author cyq7on
 * @description Given a binary tree, we install cameras on the nodes of the tree.
 * <p>
 * Each camera at a node can monitor its parent, itself, and its immediate children.
 * <p>
 * Calculate the minimum number of cameras needed to monitor all nodes of the tree.
 * <p>
 * <p>
 * Example 1:
 *
 * <img src="https://assets.leetcode.com/uploads/2018/12/29/bst_cameras_01.png"/>
 * <p>
 * Input: [0,0,null,0,0]
 * Output: 1
 * Explanation: One camera is enough to monitor all nodes if placed as shown.
 * <p>
 * Example 2:
 * <img src="https://assets.leetcode.com/uploads/2018/12/29/bst_cameras_02.png"/>
 * <p>
 * Input: [0,0,null,0,null,0,null,null,0]
 * Output: 2
 * Explanation: At least two cameras are needed to monitor all nodes of the tree. The above image shows one of the valid configurations of camera placement.
 * <p>
 * Note:
 * <p>
 * The number of nodes in the given tree will be in the range [1, 1000].
 * Every node has value 0.
 * @create 2019/12/26
 **/
public class BinaryTreeCameras {
    private int count = 0;

    public int minCameraCover(TreeNode root) {
        /*int[] dp = dp(root);
        int min = Math.min(dp[0], dp[1]);
        return Math.min(min, dp[2]);*/
        if (root == null) {
            return 0;
        }

        int install = 1;
        if (root.left != null){
            install += minCameraCover(root.left.left) + minCameraCover(root.left.right);
        }

        if (root.right != null) {
            install += minCameraCover(root.right.left) + minCameraCover(root.right.right);
        }

        if (install == 1) {
            return 1;
        }

        int notInstall = minCameraCover(root.left) + minCameraCover(root.right);
        return Math.min(install, notInstall);
    }

    /**
     * @param root
     * @return arr[0]表示root需要安装摄像头需要的最少数量，
     * arr[1]表示root没安装但是被监控，arr[2]表示没安装没监控
     */
    private int[] dp(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] left = dp(root.left);
        int[] right = dp(root.right);
        //父亲要安装，儿子被监控
        int count0 = 1;
        if (root.left != null) {
        }
        //父亲不安装被监控，儿子可以安装或者不安装
        int count1 = Math.min(left[0] + right[0],left[2] + right[2]);
        //父亲不安装没被监控，儿子必须安装
        int count2 = left[0] + right[0];

        return new int[]{count0, count1,count2};
    }

    private int minCameraCover(TreeNode root, int parentVal) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return parentVal == 0 ? 1 : 0;
        }


        if (root.val == 0) {
            if (root.left != null && root.right != null) {
                root.val = 1;
                return 1 + minCameraCover(root.left, root.val) + minCameraCover(root.right, root.val);
            }
            if (root.left != null) {
                root.left.val = 1;
            }

            if (root.right != null) {
                root.right.val = 1;
            }
            return minCameraCover(root.left, root.val) + minCameraCover(root.right, root.val);
        }

        return 1 + minCameraCover(root.left, root.val) + minCameraCover(root.right, root.val);
    }


    private TreeNode minCamera(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            if (root.val == 0) {
                count++;
                root.val++;
            }
            return root;
        }
        if (root.val == 0) {
            if (root.left != null) {
                root.left.val = 1;
                count++;
            }
            if (root.right != null) {
                root.right.val = 1;
                if (count == 0) {
                    count++;
                }
            }
        }

        TreeNode node = minCamera(root.left);
        if (node != null) {
            root = node;
            count += node.val;
        }
        node = minCamera(root.right);
        if (node != null) {
            count += node.val;
        }
        return root;
    }

    private TreeNode minCameraCover(TreeNode parent, TreeNode child) {

        if (child == null) {
            if (parent.val == 0) {
                parent.val = 1;
                count++;
            } else if (parent.val == 1) {
                count++;
            }
            return parent;
        }
        int childVal = 0;
        //parent有camera
        if (parent.val == 2) {
            childVal = 1;
        } else if (parent.val == 0) {
            parent.val = 1;
            childVal = 2;
            count++;
        }
        child.val = childVal;
        int nextVal = 0;
        if (childVal == 2) {
            nextVal = 1;
        } else if (childVal == 0) {
            nextVal = 2;
        }
        if (child.left == null && child.right == null) {
            count++;
            return parent;
        }
        if (child.left != null) {
            child.left.val = nextVal;
            child = minCameraCover(child, child.left);
        }
        if (child.right != null) {
            child.right.val = nextVal;
            parent = minCameraCover(child, child.right);
        }
        return parent;
//        return count + minCameraCover(child, child.left) + minCameraCover(child, child.right);
    }

    public static void main(String[] args) {
        BinaryTreeCameras binaryTreeCameras = new BinaryTreeCameras();

//        TreeNode root = new TreeNode(0);
//        root.left = new TreeNode(0);
//        root.left.left = new TreeNode(0);
//        root.left.left.left = new TreeNode(0);
//        root.left.left.right = new TreeNode(0);

//        TreeNode root = new TreeNode(0);

        TreeNode root = new TreeNode(0);
//        root.left = new TreeNode(0);
        System.out.println(binaryTreeCameras.minCameraCover(root));
    }
}
