import java.util.Stack;

/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
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
     * 26 / 26, 2ms(91.77%), 40.6MB(97.7%)
     */
    // public boolean isPalindrome(ListNode head) {
    //     if (head == null || head.next == null) {
    //         return true;
    //     }
    //     int length = 1;
    //     ListNode temp = head;
    //     while (temp.next != null) {
    //         ++length;
    //         temp = temp.next;
    //     }
    //     int half = length / 2;
    //     temp = head;
    //     Stack<Integer> stack = new Stack<>();
    //     for (int i = 0; i < half; ++i) {
    //         stack.add(temp.val);
    //         temp = temp.next;
    //     }
    //     if (length % 2 != 0) {
    //         temp = temp.next;
    //         ++half;
    //     }
    //     for (int i = half; i < length; ++i) {
    //         if (temp.val != stack.pop()) {
    //             return false;
    //         }
    //         temp = temp.next;
    //     }
    //     return true;
    // }

    /**
     * https://leetcode-cn.com/problems/palindrome-linked-list/solution/ji-bai-liao-bai-fen-zhi-97de-javayong-hu-by-reedfa/
     * 快慢指针找到链表中点
     * 翻转链表前半部分
     * 回文校验
     * 26 / 26, 1ms(99.89%), 42.2MB(91.28%)
     */
    // public boolean isPalindrome(ListNode head) {
    //     if (head == null || head.next == null) {
    //         return true;
    //     }
    //     // 快慢指针找到链表中点
    //     ListNode fast = head.next.next;
    //     ListNode slow = head.next;
    //     while (fast != null && fast.next != null) {
    //         fast = fast.next.next;
    //         slow = slow.next;
    //     }
    //     // 翻转链表的前半部分
    //     ListNode pre = null;
    //     ListNode next = null;
    //     while (head != slow) {
    //         next = head.next;
    //         head.next = pre;
    //         pre = head;
    //         head = next;
    //     }
    //     // 如果是奇数个节点，去掉后半部分的第一个节点
    //     if (fast != null) {
    //         slow = slow.next;
    //     }
    //     // 回文校验
    //     while (pre != null) {
    //         if (pre.val != slow.val) {
    //             return false;
    //         }
    //         pre = pre.next;
    //         slow = slow.next;
    //     }
    //     return true;
    // }

    /**
     * https://leetcode-cn.com/problems/palindrome-linked-list/solution/java-yi-dong-yi-jie-xiao-lu-gao-by-spirit-9-48/
     * 26 / 26, 1ms(99.89%), 40.6MB(97.7%)
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            ++len;
            cur = cur.next;
        }
        // 反转前半段链表
        cur = head;
        ListNode pre = null, temp = null;
        for (int i = 0; i < len / 2; ++i) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        // 奇数个链表节点则cur往后移动一位
        if ((len & 1) == 1) {
            cur = cur.next;
        }
        // 遍历比较pre和cur的值是否相等
        while (cur != null && pre != null) {
            if (cur.val != pre.val) {
                return false;
            }
            cur = cur.next;
            pre = pre.next;
        }
        return true;
    }
}
// @lc code=end

