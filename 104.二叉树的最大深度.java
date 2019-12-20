import java.util.Queue;

/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
 */
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
     * 递归遍历二叉树
     * 39 / 39, 1ms(98.69%), 37.5MB(44.97%)
     */
    // public int maxDepth(TreeNode root) {
    //     if (root == null) {
    //         return 0;
    //     } else {
    //         return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    //     }
    // }

    /**
     * 递归，深度优先搜索DFS（深度优先搜索）
     * 官方解题，思路和上一种一致
     * 39 / 39, 1ms(98.69%), 37.4MB(45.91%)
     * 时间复杂度O(n)，空间复杂度：在最糟糕的情况下，树是完全不平衡的，例如每个结点只剩下左子结点，递归将会被调用 N 次（树的高度），因此保持调用栈的存储将是 O(N)。但在最好的情况下（树是完全平衡的），树的高度将是log(N)。因此，在这种情况下的空间复杂度将是 O(\log(N))，作者：LeetCode
     */
    // public int maxDepth(TreeNode root) {
    //     if (root == null) {
    //         return 0;
    //     } else {
    //         int left = maxDepth(root.left);
    //         int right = maxDepth(root.right);
    //         return Math.max(left, right) + 1;
    //     }
    // }

    /**
     * 迭代
     * 时间和空间复杂度均为O(n)
     */
    // public int maxDeptH(TreeNode root) {
    //     Queue<Pair<TreeNode, Integer>> stack = new LinkedList<>();
    //     if (root != null) {
    //         stack.add(new Pair(root, 1));
    //     }

    //     int depth = 0;
    //     while (!stack.isEmpty()) {
    //         Pair<TreeNode, Integer> curr = stack.poll();
    //         root = curr.getKey();
    //         int curr_depth = curr.getValue();
    //         if (root != null) {
    //             depth = Math.max(depth, curr_depth);
    //             stack.add(new Pair(root.left, curr_depth + 1));
    //             stack.add(new Pair(root.right, curr_depth + 1));
    //         }
    //     }
    //     return depth;
    // }
}

