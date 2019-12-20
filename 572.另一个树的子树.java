import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=572 lang=java
 *
 * [572] 另一个树的子树
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
     * 176 / 176, 9ms(75.58%), 40.2MB(94.29%)
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            s = queue.poll();
            if (s.val == t.val) {
                if (check(s, t)) {
                    return true;
                }
            }
            if (s.left != null) {
                queue.add(s.left);
            }
            if (s.right != null) {
                queue.add(s.right);
            }
        }
        return false;
    }
    private boolean check(TreeNode s, TreeNode t) {
        if (s != null && t != null) {
            return s.val == t.val && check(s.left, t.left) && check(s.right, t.right);
        } else {
            return s == null && t == null;
        }
    }
}
// @lc code=end

