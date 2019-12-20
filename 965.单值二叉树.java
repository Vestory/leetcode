/*
 * @lc app=leetcode.cn id=965 lang=java
 *
 * [965] 单值二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * 72 / 72, 0ms(100%), 34.2MB(85.16%)
     */
    private int value = -1;
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        value = root.val;
        return itera(root);
    }
    private boolean itera(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.val != value) {
            return false;
        }
        return itera(root.left) && itera(root.right);
    }

    /**
     * 72 / 72, 0ms(100%), 34.5MB(79.56%)
     */
    // public boolean isUnivalTree(TreeNode root) {
    //     if (root == null) {
    //         return true;
    //     }
    //     if (root.left != null && root.right != null) {
    //         if (root.val != root.left.val || root.val != root.right.val) {
    //             return false;
    //         }
    //         return isUnivalTree(root.left) && isUnivalTree(root.right);
    //     } else if (root.left != null) {
    //         if (root.val != root.left.val) {
    //             return false;
    //         }
    //         return isUnivalTree(root.left);
    //     } else if (root.right != null) {
    //         if (root.val != root.right.val) {
    //             return false;
    //         }
    //         return isUnivalTree(root.right);
    //     }
    //     return true;
    // }
}
// @lc code=end

