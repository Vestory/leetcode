import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.sun.corba.se.impl.orbutil.graph.Node;

/*
 * @lc app=leetcode.cn id=589 lang=java
 *
 * [589] N叉树的前序遍历
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
     * 37 / 37, 1ms(100%), 40.3MB(100%)
     */
    // private ArrayList<Integer> res = new ArrayList<>();
    // public List<Integer> preorder(Node root) {
    //     if (root == null) {
    //         return res;
    //     }
    //     int len = root.children.size(), i = 0;
    //     res.add(root.val);
    //     while (i < len) {
    //         preorder(root.children.get(i));
    //         ++i;
    //     }
    //     return res;
    // }

    /**
     * 37 / 37, 4ms(41.29%), 40.4MB(100%)
     */
    public List<Integer> preorder(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            res.add(root.val);
            for (int i = root.children.size() - 1; i >= 0; --i) {
                stack.push(root.children.get(i));
            }
        }
        return res;
    }
}
// @lc code=end

