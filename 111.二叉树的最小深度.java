import java.util.LinkedList;
import javafx.util.Pair;

/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
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
     * 递归
     * 时间复杂度O(N)，空间复杂度：最坏情况下，整棵树是非平衡的，例如每个节点都只有一个孩子，递归会调用N（树的高度）次，因此栈的空间开销是O(N) 。但在最好情况下，树是完全平衡的，高度只有log(N)，因此在这种情况下空间复杂度只有 O(log(N))，作者：LeetCode
     * 41 / 41, 1ms(99.7%), 37.2MB(70.71%)
     */
    // public int minDepth(TreeNode root) {
    //     if (root == null) {
    //         return 0;
    //     } else {
    //         if (root.left == null && root.right == null) {
    //             return 1;
    //         }
    //         if (root.left == null) {
    //             return minDepth(root.right) + 1;
    //         }
    //         if (root.right == null) {
    //             return minDepth(root.left) + 1;
    //         }
    //         return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    //     }
    // }

    /**
     * 深度优先搜索迭代
     * 时间复杂度O(N)，空间复杂度：最坏情况为O(N)
     */
    // public int minDepth(TreeNode root) {
    //     LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList();
    //     if (root == null) {
    //         return 0;
    //     } else {
    //         stack.add(new Pair(root, 0));
    //     }

    //     int min_depth = Integer.MAX_VALUE;
    //     while (!stack.isEmpty()) {
    //         Pair<TreeNode, Integer> curr = stack.pollLast();
    //         root = curr.getKey();
    //         int curr_depth = curr.getValue();
    //         if (root.left == null && root.right == null) {
    //             min_depth = Math.min(min_depth, curr_depth);
    //         }
    //         if (root.left != null) {
    //             stack.add(new Pair(root.left, curr_depth + 1));
    //         }
    //         if (root.right != null) {
    //             stack.add(new Pair(root.right, curr_depth + 1));
    //         }
    //     }
    //     return min_depth;
    // }

    /**
     * 广度优先搜索迭代
     * 时间复杂度，最差O(N)，空间复杂度O(N)
     */
    // public int minDepth(TreeNode root) {
    //     LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
    //     if (root == null) {
    //         return 0;
    //     } else {
    //         stack.add(new Pair(root, 1));
    //     }

    //     int curr_depth = 0;
    //     while (!stack.isEmpty()) {
    //         Pair<TreeNode, Integer> curr = stack.poll();
    //         root = curr.getKey();
    //         curr_depth = curr.getValue();
    //         if (root.left == null && root.right == null) {
    //             break;
    //         }
    //         if (root.left != null) {
    //             stack.add(new Pair(root.left, curr_depth + 1));
    //         }
    //         if (root.right != null) {
    //             stack.add(new Pair(root.right, curr_depth + 1));
    //         }
    //     }
    //     return curr_depth;
    // }
}

