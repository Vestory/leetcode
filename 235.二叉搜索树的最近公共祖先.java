import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=235 lang=java
 *
 * [235] 二叉搜索树的最近公共祖先
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
     * 27 / 27, 7ms(98.98%), 36.1MB(82.38%)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (true) {
            root = queue.poll();
            if (root.val > p.val && root.val > q.val) {
                queue.add(root.left);
            } else if (root.val < p.val && root.val < q.val) {
                queue.add(root.right);
            } else {
                if (root.val == p.val) {
                    return p;
                }
                if (root.val == q.val) {
                    return q;
                }
                return root;
            }
        }
    }
}
// @lc code=end

