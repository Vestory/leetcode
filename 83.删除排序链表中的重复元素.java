/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
 */
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
     * 165 / 165, 1ms(99.88%), 36.2MB(80.4$)
     */
    // public ListNode deleteDuplicates(ListNode head) {
    //     if (head == null) {
    //         return head;
    //     }
    //     ListNode curr = head;
    //     ListNode pre = head.next;
    //     while (pre != null) {
    //         if (curr.val != pre.val) {
    //             curr.next = pre;
    //             curr = pre;
    //         }
    //         pre = pre.next;
    //     }
    //     curr.next = pre;
    //     return head;
    // }

    /**
     * 和上述思路一致
     * 165 / 165, 1ms(99.88%), 36.7MB(61.32%)
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}

