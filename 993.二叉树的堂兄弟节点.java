/*
 * @lc app=leetcode.cn id=993 lang=java
 *
 * [993] 二叉树的堂兄弟节点
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
     * 103 / 103, 0ms(100%), 34.5MB(79.07%)
     */
    private int curParent = -1;
    private int curDepth = -1;
    private int x = -1;
    private int y = -1;
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        this.x = x;
        this.y = y;
        return itera(root, -1, 1);
    }
    private boolean itera(TreeNode root, int parent, int depth) {
        if (root.val == x || root.val == y) {
            if (curDepth == -1) {
                curParent = parent;
                curDepth = depth;
            } else {
                return curParent != parent && curDepth == depth;
            }
        }
        if (root.left != null) {
            if (itera(root.left, root.val, depth + 1)) {
                return true;
            }
        }
        if (root.right != null) {
            return itera(root.right, root.val, depth + 1);
        }
        return false;
    }
}
// @lc code=end

