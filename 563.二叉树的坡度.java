/*
 * @lc app=leetcode.cn id=563 lang=java
 *
 * [563] 二叉树的坡度
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
     * 75 / 75, 1ms(100%), 37.9MB(97.4%)
     */
    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return ft(root)[1];
    }
    private int[] ft(TreeNode root) {
        int[] l;
        if (root.left != null && root.right != null) {
            l = ft(root.left);
            int[] r = ft(root.right);
            l[1] += r[1] + Math.abs(l[0] - r[0]);
            l[0] += root.val + r[0];
        } else if (root.left != null) {
            l = ft(root.left);
            l[1] += l[0] > 0 ? l[0] : -l[0];
            l[0] += root.val;
        } else if (root.right != null) {
            l = ft(root.right);
            l[1] += l[0] > 0 ? l[0] : -l[0];
            l[0] += root.val;
        } else {
            l = new int[] { root.val, 0 };
        }
        return l;
    }
}
// @lc code=end

