/*
 * @lc app=leetcode.cn id=1022 lang=java
 *
 * [1022] 从根到叶的二进制数之和
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
     * 63 / 63, 0ms(100%), 36.8MB(86.92%)
     */
    private int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        itera(root, 0);
        return sum % 1000000007;
    }
    private void itera(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        val = val << 1 | root.val;
        if (root.left == null && root.right == null) {
            sum += val;
        } else {
            itera(root.left, val);
            itera(root.right, val);
        }
    }
}
// @lc code=end

