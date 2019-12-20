import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=1089 lang=java
 *
 * [1089] 复写零
 */

// @lc code=start
class Solution {
    /**
     * 30 / 30, 5ms(47.79%), 37.4MB(100%)
     */
    // public void duplicateZeros(int[] arr) {
    //     Queue<Integer> queue = new LinkedList<>();
    //     int len = arr.length;
    //     for (int i = 0; i < len; ++i) {
    //         if (!queue.isEmpty()) {
    //             if (arr[i] == 0) {
    //                 queue.add(0);
    //                 queue.add(0);
    //             } else {
    //                 queue.add(arr[i]);
    //             }
    //             arr[i] = queue.poll();
    //         } else {
    //             if (arr[i] == 0) {
    //                 queue.add(0);
    //             }
    //         }
    //     }
    // }

    /**
     * 30 / 30, 1ms(99.87%), 37.3MB(100%)
     */
    public void duplicateZeros(int[] arr) {
        int len = arr.length, l = 0, r = 0;
        int[] queue = new int[len];
        for (int i = 0; i < len; ++i) {
            if (l != r) {
                if (r < len) {
                    if (arr[i] == 0) {
                        ++r;
                    } else {
                        queue[r] = arr[i];
                    }
                    ++r;
                }
                arr[i] = queue[l];
                ++l;
            } else {
                if (arr[i] == 0) {
                    ++r;
                }
            }
        }
    }
}
// @lc code=end

