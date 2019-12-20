/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * 迭代
     * 时间复杂度O(n)，空间复杂的O(1)
     * 27 / 27, 0ms(100%), 37MB(46.79%)
     */
    // public ListNode reverseList(ListNode head) {
    //     if (head == null) {
    //         return null;
    //     }
    //     ListNode pre = head.next;
    //     ListNode temp;
    //     head.next = null;
    //     while (pre != null) {
    //         temp = pre.next;
    //         pre.next = head;
    //         head = pre;
    //         pre = temp;
    //     }
    //     return head;
    // }

    // #region [0] 我的递归
    // 27 / 27, 0ms(100%), 37.2MB(35.06%)
    // private ListNode start = null;

    // public ListNode reverseList(ListNode head) {
    //     if (head == null) {
    //         return null;
    //     }
    //     rl(head);
    //     head.next = null;
    //     return start;
    // }

    // public ListNode rl(ListNode head) {
    //     if (head.next == null) {
    //         start = head;
    //     } else {
    //         ListNode pre = rl(head.next);
    //         pre.next = head;
    //     }
    //     return head;
    // }
    // #endregion

    /**
     * 官方递归
     * https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode/
     * 时间复杂度O(n)，空间复杂度O(n)
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
// @lc code=end

