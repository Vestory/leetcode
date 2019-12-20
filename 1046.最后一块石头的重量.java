/*
 * @lc app=leetcode.cn id=1046 lang=java
 *
 * [1046] 最后一块石头的重量
 */

// @lc code=start
class Solution {
    /**
     * 70 / 70, 1ms(99.2%), 34MB(100%)
     */
    public int lastStoneWeight(int[] stones) {
        Node root = new Node(stones[0], null), cur;
        int len = stones.length;
        for (int i = 1; i < len; ++i) {
            if (root.val > stones[i]) {
                cur = root;
                while (cur.next != null && cur.next.val > stones[i]) {
                    cur = cur.next;
                }
                if (cur.next == null) {
                    cur.next = new Node(stones[i], null);
                } else {
                    cur.next = new Node(stones[i], cur.next);
                }
            } else {
                cur = new Node(stones[i], root);
                root = cur;
            }
        }
        while (root != null && root.next != null) {
            len = root.val - root.next.val;
            root = root.next.next;
            if (len != 0) {
                cur = root;
                if (root == null) {
                    return len;
                } else {
                    if (root.val > len) {
                        while (cur.next != null && cur.next.val > len) {
                            cur = cur.next;
                        }
                        if (cur.next == null) {
                            cur.next = new Node(len, null);
                        } else {
                            cur.next = new Node(len, cur.next);
                        }
                    } else {
                        cur = new Node(len, root);
                        root = cur;
                    }
                }
            }
        }
        return root == null ? 0 : root.val;
    }

    /**
     * 其他解法
     * 最大堆
     * https://leetcode-cn.com/problems/last-stone-weight/solution/zui-hou-yi-kuai-shi-tou-de-zhong-liang-c-by-shao-s/
     * 排序
     * https://leetcode-cn.com/problems/last-stone-weight/solution/mei-yong-tan-xin-suan-fa-ke-shi-shuang-100-by-gu-x/
     * 三种方法
     * https://leetcode-cn.com/problems/last-stone-weight/solution/san-chong-fang-fa-de-javashi-xian-by-markey92/
     */
}
class Node {
    int val;
    Node next;
    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}
// @lc code=end

