/*
 * @lc app=leetcode.cn id=671 lang=java
 *
 * [671] 二叉树中第二小的节点
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
     * 35 / 35, 0ms(100%), 34.1MB(72.92%)
     */
    private int min, res = -1;
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        min = root.val;
        fsmv(root);
        return res;
    }
    private void fsmv(TreeNode root) {
        if (root.val > min) {
            if (res == -1) {
                res = root.val;
            } else if (root.val < res) {
                res = root.val;
            }
        }
        if (root.left != null) {
            fsmv(root.left);
            fsmv(root.right);
        }
    }
}
// @lc code=end

