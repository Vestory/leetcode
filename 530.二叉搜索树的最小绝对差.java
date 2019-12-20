import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=530 lang=java
 *
 * [530] 二叉搜索树的最小绝对差
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
     * 186 / 186, 4ms(23.34%), 39.6MB(85.09%)
     */
    // public int getMinimumDifference(TreeNode root) {
    //     if (root == null) {
    //         return 0;
    //     }
    //     return gmd(root, new ArrayList<Integer>(), -1);
    // }

    // private int gmd(TreeNode root, ArrayList<Integer> list, int dir) {
    //     int min = Integer.MAX_VALUE, temp = min;
    //     for (int i = 0; i < list.size(); ++i) {
    //         temp = Math.abs(root.val - list.get(i));
    //         if (min > temp) {
    //             min = temp;
    //         }
    //     }
    //     ArrayList<Integer> mList;
    //     if (root.left != null) {
    //         mList = new ArrayList<>();
    //         if (list.size() == 1) {
    //             if (dir == 1) {
    //                 mList.add(list.get(0));
    //             }
    //         } else if (list.size() == 2) {
    //             mList.add(list.get(dir));
    //         }
    //         mList.add(root.val);
    //         temp = gmd(root.left, mList, 0);
    //         if (min > temp) {
    //             min = temp;
    //         }
    //     }
    //     if (root.right != null) {
    //         mList = new ArrayList<>();
    //         if (list.size() == 1) {
    //             if (dir == 0) {
    //                 mList.add(list.get(0));
    //             }
    //         } else if (list.size() == 2) {
    //             mList.add(list.get(dir == 0 ? 1 : 0));
    //         }
    //         mList.add(root.val);
    //         temp = gmd(root.right, mList, 1);
    //     }
    //     return min > temp ? temp : min;
    // }

    /**
     * 186 / 186, 1ms(100%), 39.2MB(87.72%)
     */
    // public int getMinimumDifference(TreeNode root) {
    //     if (root == null) {
    //         return 0;
    //     }
    //     return gmd(root, new int[0], -1);
    // }

    // private int gmd(TreeNode root, int[] array, int dir) {
    //     int min = Integer.MAX_VALUE, temp = min;
    //     for (int i = 0; i < array.length; ++i) {
    //         temp = Math.abs(root.val - array[i]);
    //         if (min > temp) {
    //             min = temp;
    //         }
    //     }
    //     int[] mArray;
    //     if (root.left != null) {
    //         if (array.length == 1) {
    //             if (dir == 1) {
    //                 mArray = new int[] {array[0], root.val};
    //             } else {
    //                 mArray = new int[] {root.val};
    //             }
    //         } else if (array.length == 2) {
    //             mArray = new int[] {array[dir], root.val};
    //         } else {
    //             mArray = new int[] {root.val};
    //         }
    //         temp = gmd(root.left, mArray, 0);
    //         if (min > temp) {
    //             min = temp;
    //         }
    //     }
    //     if (root.right != null) {
    //         if (array.length == 1) {
    //             if (dir == 0) {
    //                 mArray = new int[] {array[0], root.val};
    //             } else {
    //                 mArray = new int[] {root.val};
    //             }
    //         } else if (array.length == 2) {
    //             mArray = new int[] {array[1 - dir], root.val};
    //         } else {
    //             mArray = new int[] { root.val };
    //         }
    //         temp = gmd(root.right, mArray, 1);
    //     }
    //     return min > temp ? temp : min;
    // }

    /**
     * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/solution/java-zhong-xu-bian-li-by-zxy0917-2/
     * 186 / 186, 1ms(100%), 38.9MB(88.6%)
     */
    TreeNode pre = null;
    int res = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if (root == null)
            return 0;
        helper(root);
        return res;
    }

    private void helper(TreeNode root) {
        if (root == null)
            return;
        helper(root.left);
        if (pre != null) {
            // 求相邻节点的差值
            res = Math.min(res, Math.abs(root.val - pre.val));
        }
        pre = root;
        helper(root.right);
    }
}
// @lc code=end

