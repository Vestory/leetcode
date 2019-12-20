/*
 * @lc app=leetcode.cn id=538 lang=java
 *
 * [538] 把二叉搜索树转换为累加树
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
     * 212 / 212, 1ms(99.93%), 37.1MB(96.85%)
     */
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convert(root);
        return root;
    }
    private void convert(TreeNode root) {
        if (root.right != null) {
            convert(root.right);
        }
        sum += root.val;
        root.val = sum;
        if (root.left != null) {
            convert(root.left);
        }
    }

    /**
     * 官方解题
     * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/solution/ba-er-cha-sou-suo-shu-zhuan-huan-wei-lei-jia-shu-3/
     */
}
// @lc code=end

