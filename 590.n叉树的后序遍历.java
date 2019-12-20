import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.sun.corba.se.impl.orbutil.graph.Node;

/*
 * @lc app=leetcode.cn id=590 lang=java
 *
 * [590] N叉树的后序遍历
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    /**
     * 37 / 37, 1ms(100%), 40.1MB(100%)
     */
    private ArrayList<Integer> res = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if (root == null) {
            return res;
        }
        for (int i = 0; i < root.children.size(); ++i) {
            postorder(root.children.get(i));
        }
        res.add(root.val);
        return res;
    }
}
// @lc code=end

