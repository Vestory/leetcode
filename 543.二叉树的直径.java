/*
 * @lc app=leetcode.cn id=543 lang=java
 *
 * [543] 二叉树的直径
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
     * 106 / 106, 1ms(96.79%), 36.4MB(83.19%)
     */
    // public int diameterOfBinaryTree(TreeNode root) {
    //     if (root == null) {
    //         return 0;
    //     }
    //     return dobt(root, 0)[1];
    // }

    // private int[] dobt(TreeNode root, int depth) {
    //     ++depth;
    //     int[] l = null, r = null;
    //     if (root.left != null) {
    //         l = dobt(root.left, depth);
    //     }
    //     if (root.right != null) {
    //         r = dobt(root.right, depth);
    //     }
    //     if (l == null && r == null) {
    //         return new int[] {depth, 0};
    //     } else if (l != null && r != null) {
    //         l[1] = Math.max(l[1], l[0] + r[0] - 2 * depth);
    //         l[1] = Math.max(l[1], r[1]);
    //         l[0] = Math.max(l[0], r[0]);
    //         return l;
    //     } else if (l != null) {
    //         l[1] = l[0] - depth;
    //         return l;
    //     } else {
    //         r[1] = r[0] - depth;
    //         return r;
    //     }
    // }

    /**
     * 106 / 106, 1ms(96.79%), 36.4MB(83.19%)
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dobt(root, 0)[1];
    }

    private int[] dobt(TreeNode root, int depth) {
        ++depth;
        if (root.left != null && root.right != null) {
            int[] l = dobt(root.left, depth);
            int[] r = dobt(root.right, depth);
            l[1] = Math.max(l[1], l[0] + r[0] - 2 * depth);
            l[1] = Math.max(l[1], r[1]);
            l[0] = Math.max(l[0], r[0]);
            return l;
        } else if (root.left != null) {
            int[] l = dobt(root.left, depth);
            l[1] = l[0] - depth;
            return l;
        } else if (root.right != null) {
            int[] r = dobt(root.right, depth);
            r[1] = r[0] - depth;
            return r;
        }
        return new int[] { depth, 0 };
    }
}
// @lc code=end

