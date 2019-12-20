/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
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
     * 208 / 208, 1ms(99.8%), 37.5MB(77.07%)
     */
    // public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    //     if (l1 == null) {
    //         return l2;
    //     }
    //     if (l2 == null) {
    //         return l1;
    //     }
    //     ListNode ln;
    //     ListNode ls;
    //     if (l1.val <= l2.val) {
    //         ln = l1;
    //         l1 = l1.next;
    //     } else {
    //         ln = l2;
    //         l2 = l2.next;
    //     }
    //     ls = ln;
    //     while (l1 != null && l2 != null) {
    //         if (l1.val <= l2.val) {
    //             ln.next = l1;
    //             ln = l1;
    //             l1 = l1.next;
    //         } else {
    //             ln.next = l2;
    //             ln = l2;
    //             l2 = l2.next;
    //         }
    //     }
    //     if (l1 != null) {
    //         ln.next = l1;
    //     }
    //     if (l2 != null) {
    //         ln.next = l2;
    //     }
    //     return ls;
    // }

    /**
     * 递归
     * 时间复杂度O(n + m)，因为每次调用递归都会去掉 l1 或者 l2 的头元素（直到至少有一个链表为空），函数mergeTwoList中只会遍历每个元素一次。所以，时间复杂度与合并后的链表长度为线性关系
     * 空间复杂度O(n + m)，调用 mergeTwoLists退出时 l1 和 l2 中每个元素都一定已经被遍历过了，所以 n + mn+m 个栈帧会消耗 O(n + m)O(n+m) 的空间。
     *  208 / 208, 1ms(99.8%), 35.9MB(87.63%)
     */
    // public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    //     if (l1 == null) {
    //         return l2;
    //     }
    //     if (l2 == null) {
    //         return l1;
    //     }
    //     if (l1.val < l2.val) {
    //         l1.next = mergeTwoLists(l1.next, l2);
    //         return l1;
    //     } else {
    //         l2.next = mergeTwoLists(l1, l2.next);
    //         return l2;
    //     }
    // }

    /**
     * 迭代，和第一种方法类似，但是更加简洁
     * 208 / 208, 1ms(99.8%), 35.7MB(87.76%)
     * 时间复杂度O(n + m)，空间复杂度O(1)
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return prehead.next;
    }
}