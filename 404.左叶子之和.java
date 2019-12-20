import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=404 lang=java
 *
 * [404] 左叶子之和
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
     * 102 / 102, 0ms(100%), 35.7MB(79.59%)
     */
    // public int sumOfLeftLeaves(TreeNode root) {
    //     if (root == null) {
    //         return 0;
    //     }
    //     int res = 0;
    //     if (root.left != null && root.left.left == null && root.left.right == null) {
    //         res += root.left.val;
    //     }
    //     res += sumOfLeftLeaves(root.left);
    //     res += sumOfLeftLeaves(root.right);
    //     return res;
    // }

    /**
     * 102 / 102, 1ms(72.61%), 35.9MB(79.38%)
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while (queue.size() > 0) {
            root = queue.poll();
            if (root.left != null) {
                if (root.left.left == null && root.left.right == null) {
                    res += root.left.val;
                } else {
                    queue.add(root.left);
                }
            }
            if (root.right != null) {
                queue.add(root.right);
            }
        }
        return res;
    }
}
// @lc code=end

