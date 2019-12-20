import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
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
     * 209 / 209, 2ms(87.86%), 36.6MB(97.17%)
     */
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        btp(root, res, new StringBuilder());
        return res;
    }

    public void btp(TreeNode root, List<String> list, StringBuilder sb) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            list.add(sb.toString());
        } else {
            sb.append(root.val + "->");
            btp(root.left, list, new StringBuilder(sb));
            btp(root.right, list, new StringBuilder(sb));
        }
    }
}
// @lc code=end

