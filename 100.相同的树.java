import java.util.ArrayDeque;

/*
 * @lc app=leetcode.cn id=100 lang=java
 *
 * [100] 相同的树
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
     * 递归，遍历二叉树并比较是否相同
     * 时间复杂度O(n), n是节点数；空间复杂度：最优情况（完全平衡二叉树）时为 O(\log(N))O(log(N))，最坏情况下（完全不平衡二叉树）时为 {O}(N)O(N)，用于维护递归栈
     * 57 / 57, 0ms(100%), 34MB(86.18%)
     */
    // public boolean isSameTree(TreeNode p, TreeNode q) {
    //     if (p != null && q != null) {
    //         if (p.val == q.val) {
    //             return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    //         } else {
    //             return false;
    //         }
    //     } else if (p == q) {
    //         return true;
    //     } else {
    //         return false;
    //     }
    // }

    // #region [0] 迭代
    /**
     * 迭代
     * 时间复杂度O(n)，空间复杂度，最优情况（完全平衡二叉树）时为 O(\log(N))O(log(N))，最坏情况下（完全不平衡二叉树）时为 {O}(N)O(N)，用于维护双向队列
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (!check(p, q)) {
            return false;
        }
        // 初始化双队列
        ArrayDeque<TreeNode> deqP = new ArrayDeque<TreeNode>();
        ArrayDeque<TreeNode> deqQ = new ArrayDeque<TreeNode>();
        deqP.addLast(p);
        deqQ.addLast(q);
        while (!deqP.isEmpty()) {
            p = deqP.removeFirst();
            q = deqQ.removeFirst();
            if (!check(p, q)) {
                return false;
            }
            if (p != null) {
                if (!check(p.left, q.left)) {
                    return false;
                }
                if (p.left != null) {
                    deqP.addLast(p.left);
                    deqQ.addLast(q.left);
                }
                if (!check(p.right, q.right)) {
                    return false;
                }
                if (p.right != null) {
                    deqP.addLast(p.right);
                    deqQ.addLast(q.right);
                }
            }
        }
        return true;
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (q == null || p == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return true;
    }
    // #endregion
}

