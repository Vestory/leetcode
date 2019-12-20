import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    /**
     * 判断是否已经存在，这个方法不如标记法，但更加通用
     * 也可以用set，从而判断加入一个节点时，set的大小是否改变（重复节点加入时set大小不变）
     * 17 / 17, 9ms(23.84%), 39MB(53.69%)
     */
    // public boolean hasCycle(ListNode head) {
    //     if (head == null) {
    //         return false;
    //     }
    //     HashMap<ListNode, Integer> map = new HashMap<>();
    //     map.put(head, 0);
    //     head = head.next;
    //     while (head != null) {
    //         if (map.containsKey(head)) {
    //             return true;
    //         }
    //         map.put(head, 0);
    //         head = head.next;
    //     }
    //     return false;
    // }

    /**
     * 和上一个方法一样的思路，不过实现不一样
     * 时间复杂度和空间复杂度均为O(n)
     * 17 /17, 6ms(25.61%0), 38.1MB(93.78%)
     */
    // public boolean hasCycle(ListNode head) {
    //     Set<ListNode> set = new HashSet<>();
    //     while (head != null) {
    //         if (set.contains(head)) {
    //             return true;
    //         } else {
    //             set.add(head);
    //         }
    //         head = head.next;
    //     }
    //     return false;
    // }

    /**
     * 双指针，一个快，一个慢，见
     * https://leetcode-cn.com/problems/linked-list-cycle/solution/huan-xing-lian-biao-by-leetcode/
     * 时间复杂度O(n)，空间复杂度O(1)
     * 17 / 17, 0ms(100%), 37MB(97.08%)
     */
    // public boolean hasCycle(ListNode head) {
    //     if (head == null || head.next == null) {
    //         return false;
    //     }
    //     ListNode slow = head;
    //     ListNode fast = head.next;
    //     while (slow != fast) {
    //         if (fast == null || fast.next == null) {
    //             return false;
    //         }
    //         slow = slow.next;
    //         fast = fast.next.next;
    //     }
    //     return true;
    // }

    /**
     * 置空法，标记法
     * 将已经遍历过的节点的值设置为一个原本不会有的值，表示这个节点已经被遍历过
     * 不过存在一定的问题，如果找不到这么一个值，那么结果可能会是错的
     * 17 / 17, 0ms(100%), 37.2MB(97.05%)
     */
    public boolean hasCycle(ListNode head) {
        int temp = -1024;
        while (head != null && head.val != temp) {
            head.val = temp;
            head = head.next;
        }
        return head != null;
    }
}

