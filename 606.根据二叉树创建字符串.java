/*
 * @lc app=leetcode.cn id=606 lang=java
 *
 * [606] 根据二叉树创建字符串
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
     * 162 / 162, 2ms(100%), 42.4MB(77.22%)
     */
    private StringBuilder sb = new StringBuilder();
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        ts(t);
        return sb.toString();
    }
    private void ts(TreeNode root) {
        sb.append(root.val);
        // 有左子树
        if (root.left != null) {
            sb.append('(');
            ts(root.left);
            sb.append(')');
        // 没有左子树但有右子树
        } else if (root.right != null) {
            sb.append("()");
        }
        // 有右子树
        if (root.right != null) {
            sb.append('(');
            ts(root.right);
            sb.append(')');
        }
    }
}
// @lc code=end

