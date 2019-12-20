import java.util.List;
import java.util.Queue;
import java.util.Stack;

import javax.swing.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
/*
 * @lc app=leetcode.cn id=107 lang=java
 *
 * [107] 二叉树的层次遍历 II
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
     * 利用队列实现二叉树层次遍历
     * 34 / 34, 2ms(91.31%), 36.4MB(42.43%)
     */
    // public List<List<Integer>> levelOrderBottom(TreeNode root) {
    //     if (root == null) {
    //         return new ArrayList<>();
    //     }
    //     Queue<TreeNode> queue = new LinkedList();
    //     List<List<Integer>> res = new ArrayList<>();
    //     ArrayList<Integer> list = new ArrayList<>();
    //     int count = 1;
    //     queue.add(root);
    //     while (!queue.isEmpty()) {
    //         root = queue.poll();
    //         list.add(root.val);
    //         if (root.left != null) {
    //             queue.add(root.left);
    //         }
    //         if (root.right != null) {
    //             queue.add(root.right);
    //         }
    //         if (--count == 0) {
    //             count = queue.size();
    //             res.add(list);
    //             list = new ArrayList<>();
    //         }
    //     }
    //     Collections.reverse(res);;
    //     return res;
    // }

    /**
     * 递归
     * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/solution/107er-cha-shu-de-ceng-ci-bian-li-iidui-lie-fa-he-d/
     * 34 / 34, 1ms(100%), 36.2MB(49.45%)
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, 0, res);
        Collections.reverse(res);
        return res;
    }
    private void helper(TreeNode root, int depth, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (depth + 1 > res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(depth).add(root.val);
        if (root.left != null) {
            helper(root.left, depth + 1, res);
        }
        if (root.right != null) {
            helper(root.right, depth + 1, res);
        }
    }

    // 其他解法
    // https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--23/
}
// @lc code=end

