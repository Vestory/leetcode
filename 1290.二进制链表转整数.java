/*
 * @lc app=leetcode.cn id=1290 lang=java
 *
 * [1290] 二进制链表转整数
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
     * 102 / 102, 0ms(100%), 34.1MB(100%)
     */
    public int getDecimalValue(ListNode head) {
        int[] arr = new int[30];
        int res = 0, len = 0;
        while (head != null) {
            arr[len] = head.val;
            ++len;
            head = head.next;
        }
        int mul = 1;
        for (int i = len - 1; i > -1; --i) {
            if (arr[i] != 0) {
                res += mul;
            }
            mul *= 2;
        }
        return res;
    }
}
// @lc code=end

