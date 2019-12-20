import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
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
     * 穷举法
     * 时间复杂度O(mn)，空间复杂度O(1)
     * 45 / 45, 650ms(5.01%), 48MB(7.21%)
     */
    // public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //     ListNode temp = headB;
    //     while (headA != null) {
    //         while (temp != null) {
    //             if (headA == temp) {
    //                 return headA;
    //             }
    //             temp = temp.next;
    //         }
    //         headA = headA.next;
    //         temp = headB;
    //     }
    //     return null;
    // }

    /**
     * 由于本题中，原本节点无法被修改，所以，当前方法不可用
     */
    // public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //     int flag = -1024;
    //     while (headA != null) {
    //         headA.val = flag;
    //         headA = headA.next;
    //     }
    //     while (headB != null) {
    //         if (headB.val == flag) {
    //             return headB;
    //         }
    //         headB = headB.next;
    //     }
    //     return null;
    // }

    /**
     * 哈希表
     * 时间复杂度O(m + n)，空间复杂度O(m)或O(n)
     * 45 / 45, 9ms(19.44%), 39.1MB(83.71%)
     */
    // public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //     HashMap<ListNode, Integer> map = new HashMap<>();
    //     while (headA != null) {
    //         map.put(headA, 0);
    //         headA = headA.next;
    //     }
    //     while (headB != null) {
    //         if (map.containsKey(headB)) {
    //             return headB;
    //         }
    //         headB = headB.next;
    //     }
    //     return null;
    // }

    /**
     * 双指针法
     * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/xiang-jiao-lian-biao-by-leetcode/
     * 创建两个指针 pApA 和 pBpB，分别初始化为链表 A 和 B 的头结点。然后让它们向后逐结点遍历。 当 pApA 到达链表的尾部时，将它重定位到链表
     * B 的头结点 (你没看错，就是链表 B); 类似的，当 pBpB 到达链表的尾部时，将它重定位到链表 A 的头结点。 若在某一时刻 pApA 和 pBpB
     * 相遇，则 pApA/pBpB 为相交结点。 想弄清楚为什么这样可行, 可以考虑以下两个链表: A={1,3,5,7,9,11} 和
     * B={2,4,9,11}，相交于结点 9。 由于 B.length (=4) < A.length (=6)，pBpB 比 pApA 少经过 22
     * 个结点，会先到达尾部。将 pBpB 重定向到 A 的头结点，pApA 重定向到 B 的头结点后，pBpB 要比 pApA 多走 2
     * 个结点。因此，它们会同时到达交点。 如果两个链表存在相交，它们末尾的结点必然相同。因此当 pApA/pBpB 到达链表结尾时，记录下链表 A/B
     * 对应的元素。若最后元素不相同，则两个链表不相交。
     * 时间复杂度O(m + n)，空间复杂度O(1)
     * 45 / 45, 2ms(95.62%), 37.6MB(85.81%)
     */
    // public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //     ListNode p0 = headA;
    //     ListNode p1 = headB;
    //     boolean b0 = true;
    //     boolean b1 = true;
    //     while (p0 != null && p1 != null) {
    //         if (p0 == p1) {
    //             return p0;
    //         }
    //         if (p0.next == null && b0) {
    //             b0 = false;
    //             p0 = headB;
    //         } else {
    //             p0 = p0.next;
    //         }
    //         if (p1.next == null && b1) {
    //             b1 = false;
    //             p1 = headA;
    //         } else {
    //             p1 = p1.next;
    //         }
    //     }
    //     return null;
    // }

    /**
     * 双指针法，和上一种方法一样，不同的实现
     * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/tu-jie-xiang-jiao-lian-biao-by-user7208t/
     * 45 / 45, 1ms(100%), 37.9MB(85.2%)
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p0 = headA;
        ListNode p1 = headB;
        while (p0 != p1) {
            p0 = p0 == null ? headB : p0.next;
            p1 = p1 == null ? headA : p1.next;
        }
        return p0;
    }
}

