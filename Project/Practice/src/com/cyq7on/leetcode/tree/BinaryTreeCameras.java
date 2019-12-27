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
        return minCameraCover(root, 0);
    }

    private int minCameraCover(TreeNode root,int parentVal) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return parentVal == 0 ? 1 : 0;
        }


        if (root.val == 0) {
            if (root.left != null && root.right != null) {
                root.val = 1;
                return 1 + minCameraCover(root.left,root.val) + minCameraCover(root.right,root.val);
            }
            if (root.left != null) {
                root.left.val = 1;
            }

            if (root.right != null) {
                root.right.val = 1;
            }
            return minCameraCover(root.left,root.val) + minCameraCover(root.right,root.val);
        }

        return 1 + minCameraCover(root.left,root.val) + minCameraCover(root.right,root.val);
    }



    private TreeNode minCamera(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            if (root.val == 0) {
                count++;
                root.val ++;
            }
            return root;
        }
        if (root.val == 0) {
            if (root.left != null) {
                root.left.val = 1;
                count ++ ;
            }
            if (root.right != null) {
                root.right.val = 1;
                if (count == 0) {
                    count ++;
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
                count ++;
            } else if (parent.val == 1) {
                count ++;
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
            count ++;
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
        root.left = new TreeNode(0);
        System.out.println(binaryTreeCameras.minCameraCover(root));
    }
}
