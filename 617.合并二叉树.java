/*
 * @lc app=leetcode.cn id=617 lang=java
 *
 * [617] 合并二叉树
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
     * 183 / 183, 1ms(97.77%), 38.4MB(99.2%)
     */
    // public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    //     if (t1 == null) {
    //         return t2;
    //     }
    //     if (t2 == null) {
    //         return t1;
    //     }
    //     merge(t1, t2);
    //     return t1;
    // }
    // private void merge(TreeNode t1, TreeNode t2) {
    //     if (t1 != null && t2 != null) {
    //         t1.val += t2.val;
    //         if (t1.left == null && t2.left != null) {
    //             t1.left = t2.left;
    //         } else {
    //             merge(t1.left, t2.left);
    //         }
    //         if (t1.right == null && t2.right != null) {
    //             t1.right = t2.right;
    //         } else {
    //             merge(t1.right, t2.right);
    //         }
    //     }
    // }

    /**
     * 183 / 183, 1ms(97.77%), 39.7MB(96.01%)
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        if (t1 != null && t2 != null) {
            t1.val += t2.val;
            if (t1.left == null && t2.left != null) {
                t1.left = t2.left;
            } else {
                mergeTrees(t1.left, t2.left);
            }
            if (t1.right == null && t2.right != null) {
                t1.right = t2.right;
            } else {
                mergeTrees(t1.right, t2.right);
            }
        }
        return t1;
    }
}
// @lc code=end

