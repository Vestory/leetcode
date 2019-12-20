import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    /**
     * 227 / 227, 2ms(60.03%), 39.6MB(21.91% )
     */
    // public boolean isBalanced(TreeNode root) {
    //     if (root == null) {
    //         return true;
    //     }
    //     Queue<TreeNode> queue = new LinkedList<>();
    //     queue.add(root);
    //     while (queue.size() > 0) {
    //         root = queue.poll();
    //         int l = getMaxDepth(root.left);
    //         int r = getMaxDepth(root.right);
    //         if (Math.abs(l - r) > 1) {
    //             return false;
    //         }
    //         if (root.left != null) {
    //             queue.add(root.left);
    //         }
    //         if (root.right != null) {
    //             queue.add(root.right);
    //         }
    //     }
    //     return true;
    // }

    // private int getMaxDepth(TreeNode root) {
    //     if (root == null) {
    //         return 0;
    //     }
    //     return Math.max(getMaxDepth(root.left), getMaxDepth(root.right)) + 1;
    // }

    /**
     * 227 / 227, 1ms(100%), 39.6MB(20.59%)
     */
    // public boolean isBalanced(TreeNode root) {
    //     int res = iter(root);
    //     return res > -1;
    // }

    // public int iter(TreeNode root) {
    //     if (root == null) {
    //         return 0;
    //     }
    //     int l = iter(root.left);
    //     int r = iter(root.right);
    //     if (l == -1 || r == -1 || Math.abs(l - r) > 1) {
    //         return -1;
    //     } else {
    //         return Math.max(l, r) + 1;
    //     }
    // }

    /**
     * https://leetcode-cn.com/problems/balanced-binary-tree/solution/balanced-binary-tree-di-gui-fang-fa-by-jin40789108/
     */
    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }

    private int depth(TreeNode root) {
        if (root == null)
            return 0;
        int left = depth(root.left);
        if (left == -1)
            return -1;
        int right = depth(root.right);
        if (right == -1)
            return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}