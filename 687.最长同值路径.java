/*
 * @lc app=leetcode.cn id=687 lang=java
 *
 * [687] 最长同值路径
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
     * 71 / 71, 6ms(50.64%), 40.5MB(96.51%)
     */
    // public int longestUnivaluePath(TreeNode root) {
    //     if (root == null) {
    //         return 0;
    //     }
    //     return itera(root, -1024)[1] - 1;
    // }
    // private int[] itera(TreeNode root, int pval) {
    //     // 对于一个子树A，需要返回2个值，一是A中与父节点值相同的并能连接成同一路径的节点数量；二是A中最长同值路径的节点数量
    //     int[] res = new int[2], l = new int[2], r = new int[2];
    //     if (root.left != null) {
    //         l = itera(root.left, root.val);
    //     }
    //     if (root.right != null) {
    //         r = itera(root.right, root.val);
    //     }
    //     res[0] = l[0] + r[0] + 1;
    //     res[1] = l[1] > r[1] ? l[1] : r[1];
    //     res[1] = res[0] > res[1] ? res[0] : res[1];
    //     if (root.val == pval) {
    //         res[0] = (l[0] > r[0] ? l[0] : r[0]) + 1;
    //     } else {
    //         res[0] = 0;
    //     }
    //     return res;
    // }

    /**
     * 官方解题
     * https://leetcode-cn.com/problems/longest-univalue-path/solution/zui-chang-tong-zhi-lu-jing-by-leetcode/
     * 71 / 71, 5ms(69.65%), 40.1MB(96.51%)
     */
    int ans;
    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        arrowLength(root);
        return ans;
    }

    public int arrowLength(TreeNode node) {
        if (node == null)
            return 0;
        int left = arrowLength(node.left);
        int right = arrowLength(node.right);
        int arrowLeft = 0, arrowRight = 0;
        if (node.left != null && node.left.val == node.val) {
            arrowLeft += left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            arrowRight += right + 1;
        }
        ans = Math.max(ans, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }
}
// @lc code=end

