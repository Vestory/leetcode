import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=703 lang=java
 *
 * [703] 数据流中的第K大元素
 */

// @lc code=start
/**
 * 链表
 * 10 / 10, 995ms(5.02%), 56.9MB(50.32%)
 */
// class KthLargest {

//     private Node head = null;
//     private Node target = null;
//     private int k = 0;
//     private int cur = 0;

//     public KthLargest(int k, int[] nums) {
//         this.k = k;
//         this.cur = k;
//         for (int i : nums) {
//             add(i);
//         }
//     }

//     public int add(int val) {
//         if (head == null) {
//             head = new Node(val, null);
//             target = head;
//             --cur;
//         } else if (head.val < val) {
//             head = new Node(val, head);
//             if (cur > 0) {
//                 --cur;
//             } else {
//                 val = k;
//                 target = head;
//                 while (--val > 0) {
//                     target = target.next;
//                 }
//             }
//         } else {
//             int count = 1;
//             Node node = head;
//             while (node.next != null) {
//                 if (node.next.val < val) {
//                     break;
//                 }
//                 node = node.next;
//                 ++count;
//             }
//             node.next = new Node(val, node.next);
//             if (cur > 0) {
//                 --cur;
//                 if (target.next != null) {
//                     target = target.next;
//                 }
//             } else if (k > count) {
//                 count = k - count;
//                 target = node.next;
//                 while (--count > 0) {
//                     target = target.next;
//                 }
//             }
//         }
//         return target.val;
//     }
// }
// class Node {
//     public int val = 0;
//     public Node next = null;
//     public Node(int val, Node next) {
//         this.val = val;
//         this.next = next;
//     }
// }

/**
 * 10 / 10, 528ms(7.53%), 62.7MB(12.95%)
 */
// class KthLargest {

//     private List<Integer> list;
//     private int k = 0;

//     public KthLargest(int k, int[] nums) {
//         this.k = k;
//         this.list = new ArrayList<>();
//         Arrays.sort(nums);
//         for (int i : nums) {
//             list.add(i);
//         }
//     }

//     public int add(int val) {
//         list.add(val);
//         Collections.sort(list);
//         return list.get(list.size() - k);
//     }
// }

/**
 * 最小堆，小顶堆
 * https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/solution/javashi-yong-zui-xiao-dui-lai-shi-xian-shi-yong-ne/
 * 10 / 10, 30ms(73.79%), 47.7MB(93.74%)
 */
class KthLargest {

    private PriorityQueue<Integer> queue;
    private int limit;

    public KthLargest(int k, int[] nums) {
        limit = k;
        queue = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (queue.size() < limit) {
            queue.add(val);
        } else if (val > queue.peek()) {
            queue.poll();
            queue.add(val);
        }
        return queue.peek();
    }

}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
// @lc code=end

