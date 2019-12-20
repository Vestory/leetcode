import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=437 lang=java
 *
 * [437] 路径总和 III
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    /**
     * 126 / 126, 26ms(6.84%), 43.6MB(20.60%) 这里使用了list来存储每个路径上经过的节点的value
     */
    // public int pathSum(TreeNode root, int sum) {
    // return ps(root, sum, new ArrayList<Integer>(), 0);
    // }

    // private int ps(TreeNode root, int sum, ArrayList<Integer> list, int currSum)
    // {
    // if (root == null) {
    // return 0;
    // }
    // list.add(root.val);
    // currSum += root.val;
    // int count = currSum == sum ? 1 : 0;
    // int temp = currSum;
    // int len = list.size() - 1;
    // for (int i = 0; i < len; ++i) {
    // temp -= list.get(i);
    // if (temp == sum) {
    // ++count;
    // }
    // }
    // return count + ps(root.left, sum, new ArrayList<Integer>(list), currSum) +
    // ps(root.right, sum, new ArrayList<Integer>(list), currSum);
    // }

    /**
     * 126 / 126, 42ms(5.07%), 48.1MB(6.50%) 这里使用了list来存储路径上节点之间的和，如有路径abcd，新加了e
     * 则list存储了abcd,bcd,cd,d对应的和，新增加e后，我们要计算的恰好是
     * abcde,bcde,cde,de,e这五个值，所以list直接存储上面的四个值而不是对应的a,b,c,d会更快 对比上一种方法来明白这一点
     * 然而，事实上貌似变的更慢了.................什么鬼？ 原因可能是list.set耗费了太多时间
     */
    // public int pathSum(TreeNode root, int sum) {
    // return ps(root, sum, new ArrayList<Integer>());
    // }

    // private int ps(TreeNode root, int sum, ArrayList<Integer> list) {
    // if (root == null) {
    // return 0;
    // }
    // int count = root.val == sum ? 1 : 0, temp;
    // for (int i = 0; i < list.size(); ++i) {
    // temp = list.get(i) + root.val;
    // list.set(i, temp);
    // if (temp == sum) {
    // ++count;
    // }
    // }
    // list.add(root.val);
    // return count + ps(root.left, sum, new ArrayList<Integer>(list))
    // + ps(root.right, sum, new ArrayList<Integer>(list));
    // }

    /**
     * 126 / 126, 16ms(87.24%), 40.3MB(56.64%)
     * https://leetcode-cn.com/problems/path-sum-iii/solution/leetcode-437-path-sum-iii-by-li-xin-lei/
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return paths(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int paths(TreeNode root, int sum) {

        if (root == null) {
            return 0;
        }

        int res = 0;
        if (root.val == sum) {
            res += 1;
        }
        res += paths(root.left, sum - root.val);
        res += paths(root.right, sum - root.val);
        return res;
    }
}
// @lc code=end