import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=872 lang=java
 *
 * [872] 叶子相似的树
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
     * 36 / 36, 0ms(100%), 34.7MB(77.96%)
     * 128256512可能会导致问题，如果恰好有这个值，那么可能false也可能变成了true
     */
    // private ArrayList<Integer> list = new ArrayList<>();
    // public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    //     if (root1 == null || root2 == null) {
    //         return root1 == root2;
    //     }
    //     itera(root1);
    //     list.add(128256512);
    //     itera(root2);
    //     int len = list.size();
    //     if (len % 2 == 1) {
    //         int i = len / 2;
    //         if (list.get(i) == 128256512) {
    //             len = i;
    //             i = 0;
    //             int j = len + 1;
    //             while (i < len) {
    //                 if (list.get(i) != list.get(j)) {
    //                     break;
    //                 }
    //                 ++i;
    //                 ++j;
    //             }
    //             return i == len;
    //         }
    //     }
    //     return false;
    // }
    // private void itera(TreeNode root) {
    //     if (root.left == null && root.right == null) {
    //         list.add(root.val);
    //         return;
    //     }
    //     if (root.left != null) {
    //         itera(root.left);
    //     }
    //     if (root.right != null) {
    //         itera(root.right);
    //     }
    // }

    /**
     * 36 / 36, 0ms(100%), 34.6MB(83.67%)
     */
    private ArrayList<Integer> list1 = new ArrayList<>();
    private ArrayList<Integer> list2 = new ArrayList<>();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == root2;
        }
        itera1(root1);
        itera2(root2);
        int len = list1.size();
        if (len == list2.size()) {
            int i = 0;
            while (i < len) {
                if (list1.get(i) != list2.get(i)) {
                    break;
                }
                ++i;
            }
            return i == len;
        }
        return false;
    }
    private void itera1(TreeNode root) {
        if (root.left == null && root.right == null) {
            list1.add(root.val);
            return;
        }
        if (root.left != null) {
            itera1(root.left);
        }
        if (root.right != null) {
            itera1(root.right);
        }
    }
    private void itera2(TreeNode root) {
        if (root.left == null && root.right == null) {
            list2.add(root.val);
            return;
        }
        if (root.left != null) {
            itera2(root.left);
        }
        if (root.right != null) {
            itera2(root.right);
        }
    }
}
// @lc code=end

