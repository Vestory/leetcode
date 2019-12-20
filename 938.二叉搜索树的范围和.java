/*
 * @lc app=leetcode.cn id=938 lang=java
 *
 * [938] 二叉搜索树的范围和
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
     * 42 / 42, 1ms（87.47%), 45MB(91.06%)
     */
    // private int sum = 0, l, r;
    // public int rangeSumBST(TreeNode root, int L, int R) {
    //     if (root == null) {
    //         return 0;
    //     }
    //     l = L;
    //     r = R;
    //     itera(root);
    //     return sum;
    // }
    // private void itera(TreeNode root) {
    //     if (root.val >= l && root.val <= r) {
    //         sum += root.val;
    //     }
    //     if (root.left != null) {
    //         itera(root.left);
    //     }
    //     if (root.right != null) {
    //         itera(root.right);
    //     }
    // }

    /**
     * 42 / 42, 1ms(87.37%), 45.1MB(90.65%)
     */
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        if (root.val >= L && root.val <= R) {
            return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
        }
        return rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }
}
// @lc code=end

