/*
 * @lc app=leetcode.cn id=897 lang=java
 *
 * [897] 递增顺序查找树
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
     * 2156 / 2156, 3ms(97.05%), 39.7MB(96.5%)
     */
    private TreeNode newRoot = null;
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        getNewRoot(root);
        itera(root, null);
        return newRoot;
    }
    private void getNewRoot(TreeNode root) {
        if (root.left != null) {
            getNewRoot(root.left);
        } else {
            newRoot = root;
        }
    }
    private TreeNode itera(TreeNode root, TreeNode parent) {
        if (root.left != null) {
            TreeNode temp = itera(root.left, parent);
            temp.right = root;
            root.left = null;
        } else if (parent != null) {
            parent.right = root;
        }
        if (root.right != null) {
            return itera(root.right, root);
        }
        return root;
    }
}
// @lc code=end

