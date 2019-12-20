/*
 * @lc app=leetcode.cn id=653 lang=java
 *
 * [653] 两数之和 IV - 输入 BST
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
     * 421 / 421, 1ms(100%), 44.3MB(89.45%)
     */
    private TreeNode t;
    public boolean findTarget(TreeNode root, int k) {
        t = root;
        return itera(root, k);
    }
    private boolean itera(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        int temp = k - root.val;
        if (temp < root.val && check(t, temp)) {
            return true;
        } else if (temp > root.val && check(t, temp)) {
            return true;
        }
        return itera(root.left, k) || itera(root.right, k);
    }
    private boolean check(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (root.val == k) {
            return true;
        }
        if (k < root.val) {
            return check(root.left, k);
        }
        return check(root.right, k);
    }
}
// @lc code=end

