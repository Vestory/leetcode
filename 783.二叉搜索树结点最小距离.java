import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=783 lang=java
 *
 * [783] 二叉搜索树结点最小距离
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
     * 45 / 45, 0ms(100%), 34.4MB(77.38%)
     */
    // public int minDiffInBST(TreeNode root) {
    //     return itera(root, null, null, false);
    // }
    // private int itera(TreeNode self, TreeNode parent, TreeNode grand, boolean isleft) {
    //     int min = Integer.MAX_VALUE;
    //     if (parent != null) {
    //         min = Math.min(min, Math.abs(self.val - parent.val));
    //     }
    //     if (grand != null) {
    //         min = Math.min(min, Math.abs(self.val - grand.val));
    //     }
    //     if (self.left != null) {
    //         if (isleft) {
    //             min = Math.min(min, itera(self.left, self, grand, true));
    //         } else {
    //             min = Math.min(min, itera(self.left, self, parent, true));
    //         }
    //     }
    //     if (self.right != null) {
    //         if (isleft) {
    //             min = Math.min(min, itera(self.right, self, parent, false));
    //         } else {
    //             min = Math.min(min, itera(self.right, self, grand, false));
    //         }
    //     }
    //     return min;
    // }

    /**
     * 官方解题
     * 数组排序
     * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/solution/er-cha-sou-suo-shu-jie-dian-zui-xiao-ju-chi-by-lee/
     * 45 / 45, 2ms(17.68%), 34.6MB(74.41%)
     */
    // List<Integer> vals;
    // public int minDiffInBST(TreeNode root) {
    //     vals = new ArrayList<>();
    //     dfs(root);
    //     Collections.sort(vals);
    //     int ans = Integer.MAX_VALUE;
    //     for (int i = 0; i < vals.size() - 1; ++i)
    //         ans = Math.min(ans, vals.get(i + 1) - vals.get(i));
    //     return ans;
    // }
    // public void dfs(TreeNode node) {
    //     if (node == null)
    //         return;
    //     vals.add(node.val);
    //     dfs(node.left);
    //     dfs(node.right);
    // }

    /**
     * 官方解题
     * 中序遍历
     * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/solution/er-cha-sou-suo-shu-jie-dian-zui-xiao-ju-chi-by-lee/
     * 45 / 45, 0ms(100%), 34.4MB(76.19%)
     */
    Integer prev, ans;
    public int minDiffInBST(TreeNode root) {
        prev = null;
        ans = Integer.MAX_VALUE;
        dfs(root);
        return ans;
    }
    public void dfs(TreeNode node) {
        if (node == null)
            return;
        dfs(node.left);
        if (prev != null)
            ans = Math.min(ans, node.val - prev);
        prev = node.val;
        dfs(node.right);
    }
}
// @lc code=end

