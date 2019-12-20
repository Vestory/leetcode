/*
 * @lc app=leetcode.cn id=203 lang=java
 *
 * [203] 移除链表元素
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
     * 65 / 65, 1ms(100%), 39.1MB(94.47%)
     */
    // public ListNode removeElements(ListNode head, int val) {
    //     while (head != null && head.val == val) {
    //         head = head.next;
    //     }
    //     ListNode curr = head;
    //     while (curr != null) {
    //         while (curr.next != null && curr.next.val == val) {
    //             curr.next = curr.next.next;
    //         }
    //         curr = curr.next;
    //     }
    //     return head;
    // }

    // #region [0] 三种解法
    // https://leetcode-cn.com/problems/remove-linked-list-elements/solution/java-yi-dong-yi-jie-xiao-lu-gao-by-spirit-9-52/
    /**
     * 找到第一个不为val的结点作为头结点,定义两个指针进行删除操作
     * 65 / 65, 1ms(100%), 38.7MB(95.06%)
     */
    // public ListNode removeElements(ListNode head, int val) {
    //     while (head != null) {
    //         if (head.val != val) {
    //             break;
    //         }
    //         head = head.next;
    //     }
    //     ListNode pre = head;
    //     ListNode cur = head;
    //     while (cur != null) {
    //         if (cur.val == val) {
    //             pre.next = cur.next;
    //         } else {
    //             pre = cur;
    //         }
    //         cur = cur.next;
    //     }
    //     return head;
    // }

    /**
     * 新链表上操作
     * 65 / 65, 1ms(100%), 39.5MB(94.42%)
     */
    // public ListNode removeElements(ListNode head, int val) {
    //     if (head == null) {
    //         return head;
    //     }
    //     ListNode pre = new ListNode(-1);
    //     pre.next = head;
    //     ListNode cur = pre;
    //     while (cur.next != null) {
    //         if (cur.next.val == val) {
    //             cur.next = cur.next.next;
    //         } else {
    //             cur = cur.next;
    //         }
    //     }
    //     return pre.next;
    // }

    /**
     * 递归
     * 65 / 65, 1ms(100%), 39.3MB(94.47%)
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);
        if (head.val == val) {
            return head.next;
        } else {
            return head;
        }
    }
    // #endregion
}
// @lc code=end

