/*
 * @lc app=leetcode.cn id=559 lang=java
 *
 * [559] N叉树的最大深度
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    /**
     * 36 / 36, 1ms(99.54%), 43.9MB(96.8%)
     */
    private int max = 0;
    public int maxDepth(Node root) {
        if (root == null) {
            return max;
        }
        md(root, 0);
        return max;
    }

    public void md(Node root, int d) {
        ++d;
        max = Math.max(d, max);
        for (int i = 0; i < root.children.size(); ++i) {
            md(root.children.get(i), d);
        }
    }
}
// @lc code=end

