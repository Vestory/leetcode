import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=1029 lang=java
 *
 * [1029] 两地调度
 */

// @lc code=start
class Solution {
    /**
     * 49 / 49, 2ms(65.83%), 35.1MB(100%)
     */
    // public int twoCitySchedCost(int[][] costs) {
    //     int len = costs.length, l = 0, r = 0, half = len / 2, diff, aim;
    //     Node root = null;
    //     for (int i = 0; i < len; ++i) {
    //         diff = costs[i][0] - costs[i][1];
    //         if (diff < 0) {
    //             aim = 0;
    //             diff = -diff;
    //             if (l < half) {
    //                 root = add(root, new Node(diff, aim, i, null));
    //                 ++l;
    //             } else {
    //                 root = adjust(root, new Node(diff, aim, i, null));
    //                 ++r;
    //             }
    //         } else {
    //             aim = 1;
    //             if (r < half) {
    //                 root = add(root, new Node(diff, aim, i, null));
    //                 ++r;
    //             } else {
    //                 root = adjust(root, new Node(diff, aim, i, null));
    //                 ++l;
    //             }
    //         }
    //     }
    //     aim = 0;
    //     while (root != null) {
    //         aim += costs[root.idx][root.aim];
    //         root = root.next;
    //     }
    //     return aim;
    // }
    // private Node add(Node root, Node node) {
    //     Node head = node;
    //     if (root != null) {
    //         if (root.diff >= node.diff) {
    //             node.next = root;
    //         } else {
    //             head = root;
    //             while (root.next != null) {
    //                 if (root.next.diff >= node.diff) {
    //                     node.next = root.next;
    //                     break;
    //                 }
    //                 root = root.next;
    //             }
    //             root.next = node;
    //         }
    //     }
    //     return head;
    // }
    // private Node adjust(Node root, Node node) {
    //     Node head = root;
    //     while (root.aim != node.aim) {
    //         root = root.next;
    //     }
    //     if (root.diff < node.diff) {
    //         root.aim = root.aim == 0 ? 1 : 0;
    //     } else {
    //         node.aim = node.aim == 0 ? 1 : 0;
    //     }
    //     return add(head, node);
    // }
    // class Node {
    //     int diff = 0;
    //     int aim = 0;
    //     int idx = 0;
    //     Node next = null;
    //     public Node(int diff, int aim, int idx, Node next) {
    //         this.diff = diff;
    //         this.aim = aim;
    //         this.idx = idx;
    //         this.next = next;
    //     }
    // }

    /**
     * 官方解题
     * 49 / 49, 2ms(65.83%), 38MB(100%)
     */
    public int twoCitySchedCost(int[][] costs) {
        // Sort by a gain which company has
        // by sending a person to city A and not to city B
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o1[1] - (o2[0] - o2[1]);
            }
        });

        int total = 0;
        int n = costs.length / 2;
        // To optimize the company expenses,
        // send the first n persons to the city A
        // and the others to the city B
        for (int i = 0; i < n; ++i)
            total += costs[i][0] + costs[i + n][1];
        return total;
    }
}
// @lc code=end

