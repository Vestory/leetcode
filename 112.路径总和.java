import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
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
     * 时间复杂度O(n)，空间复杂度：最坏情况下，整棵树是非平衡的，例如每个节点都只有一个孩子，递归会调用 NN 次（树的高度），因此栈的空间开销是 O(N)。但在最好情况下，树是完全平衡的，高度只有log(N)，因此在这种情况下空间复杂度只有 O(log(N))，作者：LeetCode
     * 114 / 114, 1ms(99.72%), 39.6MB(15.95%)
     */
    // public boolean hasPathSum(TreeNode root, int sum) {
    //     if (root == null) {
    //         return false;
    //     }
    //     if (root.left == null && root.right == null) {
    //         return (sum - root.val) == 0;
    //     }
    //     return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    // }

    /**
     * 迭代，深度优先
     * 114 / 114, 3ms(10.88%), 37.1MB(74.26%)
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        LinkedList<TreeNode> node_stack = new LinkedList<>();
        LinkedList<Integer> sum_stack = new LinkedList<>();
        node_stack.add(root);
        sum_stack.add(sum - root.val);
        TreeNode node;
        int curr_sum;
        while (!node_stack.isEmpty()) {
            node = node_stack.pollLast();
            curr_sum = sum_stack.pollLast();
            if (node.right == null && node.left == null && curr_sum == 0) {
                return true;
            }
            if (node.right != null) {
                node_stack.add(node.right);
                sum_stack.add(curr_sum - node.right.val);
            }
            if (node.left != null) {
                node_stack.add(node.left);
                sum_stack.add(curr_sum - node.left.val);
            }
        }
        return false;
    }
}

