/*
 * @lc app=leetcode.cn id=669 lang=java
 *
 * [669] 修剪二叉搜索树
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
     * 77 / 77, 0ms(100%), 37MB(95.97%)
     */
    private int l, r;
    public TreeNode trimBST(TreeNode root, int L, int R) {
        l = L;
        r = R;
        return trim(root);
    }
    private TreeNode trim(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.val < l) {
            return trim(root.right);
        } else if (root.val > r) {
            return trim(root.left);
        }
        root.left = trim(root.left);
        root.right = trim(root.right);
        return root;
    }
}
// @lc code=end

