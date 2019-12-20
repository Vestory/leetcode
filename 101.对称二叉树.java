import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {

    // #region [0] 递归
    /**
     * 递归，两棵树互为镜像需要满足： 1、两者的根节点相等 2、前者的左子树与后者的右子树镜像对称，前者的右子树与后者的左子树镜像对称
     * 时间复杂度O(n)，空间复杂度：递归调用的次数受树的高度限制。在最糟糕情况下，树是线性的，其高度为
     * O(n)O(n)。因此，在最糟糕的情况下，由栈上的递归调用造成的空间复杂度为 O(n)O(n)。
     */
    // public boolean isSymmetric(TreeNode root) {
    // return isMirror(root, root);
    // }

    // public boolean isMirror(TreeNode p, TreeNode q) {
    // if (p == null && q == null) {
    // return true;
    // }
    // if (p == null || q == null) {
    // return false;
    // }
    // return p.val == q.val && isMirror(p.left, q.right) && isMirror(p.right,
    // q.left);
    // }
    // #endregion

    /**
     * 迭代：队列中每两个连续的结点应该是相等的，而且它们的子树互为镜像。最初，队列中包含的是 root 以及 root。该算法的工作原理类似于
     * BFS，但存在一些关键差异。每次提取两个结点并比较它们的值。然后，将两个结点的左右子结点按相反的顺序插入队列中。当队列为空时，或者我们检测到树不对称（即从队列中取出两个不相等的连续结点）时，该算法结束。
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/symmetric-tree/solution/dui-cheng-er-cha-shu-by-leetcode/
     * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * 时间复杂度O(n)，空间复杂度：搜索队列需要额外的空间。在最糟糕情况下，我们不得不向队列中插入 O(n) 个结点。因此，空间复杂度为 O(n)
     */
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) {
                continue;
            }
            if (t1 == null || t2 == null) {
                return false;
            }
            if (t1.val != t2.val) {
                return false;
            }
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
}
