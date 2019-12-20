import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=637 lang=java
 *
 * [637] 二叉树的层平均值
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
     * 65 / 65, 4ms(64.26%), 41.7MB(93.71%)
     */
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 1, curr = 1;
        double sum = 0;
        while (!queue.isEmpty()) {
            root = queue.poll();
            --curr;
            sum += root.val;
            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
            if (curr == 0) {
                res.add(sum / count);
                sum = 0;
                curr = queue.size();
                count = curr;
            }
        }
        return res;
    }
}
// @lc code=end

