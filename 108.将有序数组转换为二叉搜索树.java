import java.util.HashSet;
import java.util.Queue;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=108 lang=java
 *
 * [108] 将有序数组转换为二叉搜索树
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
    // #region [0] 解法
    // https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-24/
    /**
     * 递归
     * 32 / 32, 1ms(99.73%), 36.8MB(98.89%)
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return sat(nums, 0, nums.length);
    }
    private TreeNode sat(int[] nums, int start, int end) {
        if (start == end) {
            return null;
        }
        int mid = (start + end) >>> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sat(nums, start, mid);
        root.right = sat(nums, mid + 1, end);
        return root;
    }

    /**
     * 迭代，栈，DFS
     * 32 / 32, 7ms(7.4%), 35.9MB(98.98%)
     */
    // class MyTreeNode {
    //     TreeNode root;
    //     int start;
    //     int end;

    //     MyTreeNode(TreeNode root, int start, int end) {
    //         this.root = root;
    //         this.start = start;
    //         this.end = end;
    //     }
    // }
    // public TreeNode sortedArrayToBST(int[] nums) {
    //     if (nums.length == 0) {
    //         return null;
    //     }
    //     Stack<MyTreeNode> stack = new Stack<>();
    //     int start = 0;
    //     int end = nums.length;
    //     int mid = (start + end) >>> 1;
    //     TreeNode root = new TreeNode(nums[mid]);
    //     TreeNode currRoot = root;
    //     stack.push(new MyTreeNode(root, start, end));
    //     while (end - start > 1 || !stack.isEmpty()) {
    //         // 考虑左子树
    //         while (end - start > 1) {
    //             mid = (start + end) >>> 1; // 当前根节点
    //             end = mid; // 左子树的结尾
    //             mid = (start + end) >>> 1; // 左子树的中点
    //             currRoot.left = new TreeNode(nums[mid]);
    //             currRoot = currRoot.left;
    //             stack.push(new MyTreeNode(currRoot, start, end));
    //         }
    //         // 出栈考虑右子树
    //         MyTreeNode myNode = stack.pop();
    //         // 当前作为根节点的start end以及mid
    //         start = myNode.start;
    //         end = myNode.end;
    //         mid = (start + end) >>> 1;
    //         start = mid + 1; // 右子树的start
    //         currRoot = myNode.root; // 当前根节点
    //         if (start < end) { // 判断当前范围内是否有数
    //             mid = (start + end) >>> 1; // 右子树的mid
    //             currRoot.right = new TreeNode(nums[mid]);
    //             currRoot = currRoot.right;
    //             stack.push(new MyTreeNode(currRoot, start, end));
    //         }
    //     }
    //     return root;
    // }

    /**
     * 队列 BFS
     * 32 / 32, 4ms(7.4%), 36.6MB(98.89%)
     */
    // class MyTreeNode {
    //     TreeNode root;
    //     int start;
    //     int end;

    //     MyTreeNode(TreeNode root, int start, int end) {
    //         this.root = root;
    //         this.start = start;
    //         this.end = end;
    //     }
    // }
    // public TreeNode sortedArrayToBST(int[] nums) {
    //     if (nums.length == 0) {
    //         return null;
    //     }
    //     Queue<MyTreeNode> queue = new LinkedList<>();
    //     TreeNode root = new TreeNode(0);
    //     queue.offer(new MyTreeNode(root, 0, nums.length));
    //     while (!queue.isEmpty()) {
    //         MyTreeNode myRoot = queue.poll();
    //         int start = myRoot.start;
    //         int end = myRoot.end;
    //         int mid = (start + end) >>> 1;
    //         TreeNode currRoot = myRoot.root;
    //         currRoot.val = nums[mid];
    //         if (start < mid) {
    //             currRoot.left = new TreeNode(0);
    //             queue.offer(new MyTreeNode(currRoot.left, start, mid));
    //         }
    //         if (mid + 1 < end) {
    //             currRoot.right = new TreeNode(0);
    //             queue.offer(new MyTreeNode(currRoot.right, mid + 1, end));
    //         }
    //     }
    //     return root;
    // }

    // #endregion
}
// @lc code=end

