import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=501 lang=java
 *
 * [501] 二叉搜索树中的众数
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    /**
     * 25 / 25, 21ms(16.22%), 40.4MB(80%)
     */
    // public int[] findMode(TreeNode root) {
    // if (root == null) {
    // return new int[0];
    // }
    // HashMap<Integer, Integer> map = new HashMap<>();
    // Queue<TreeNode> queue = new LinkedList<>();
    // queue.add(root);
    // while (!queue.isEmpty()) {
    // root = queue.poll();
    // map.put(root.val, map.getOrDefault(root.val, 0) + 1);
    // if (root.left != null) {
    // queue.add(root.left);
    // }
    // if (root.right != null) {
    // queue.add(root.right);
    // }
    // }
    // Iterator<Integer> iterator = map.keySet().iterator();
    // int max = 0, key, value;
    // ArrayList<Integer> list = new ArrayList<>();
    // while (iterator.hasNext()) {
    // key = iterator.next();
    // value = map.get(key);
    // if (max < value) {
    // max = value;
    // list.clear();
    // list.add(key);
    // } else if (max == value) {
    // list.add(key);
    // }
    // }
    // return list.stream().mapToInt(Integer::valueOf).toArray();
    // }

    /**
     * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/solution/zhong-xu-bian-li-listcun-zhong-shu-by-nuan/
     * 25 / 25, 1ms(100%), 38.4MB(95.38%)
     */
    int maxTimes = 0;
    int thisTimes = 0;
    List<Integer> res = new LinkedList<Integer>();
    TreeNode pre = null;

    public int[] findMode(TreeNode root) {
        inOrder(root);
        int length = res.size();
        int[] rr = new int[length];
        for (int i = 0; i < length; i++) {
            rr[i] = res.get(i);
        }
        return rr;
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (pre != null && pre.val == root.val) {
            thisTimes++;
        } else {
            thisTimes = 1;
        }
        if (thisTimes == maxTimes) {
            res.add(root.val);
        } else if (thisTimes > maxTimes) {
            maxTimes = thisTimes;
            res.clear();
            res.add(root.val);
        }
        pre = root;
        inOrder(root.right);
    }
}
// @lc code=end
