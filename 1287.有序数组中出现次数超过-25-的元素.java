/*
 * @lc app=leetcode.cn id=1287 lang=java
 *
 * [1287] 有序数组中出现次数超过25%的元素
 */

// @lc code=start
class Solution {
    /**
     * 18 / 18, 1ms(79.29%), 39.7MB(100%)
     */
    // public int findSpecialInteger(int[] arr) {
    //     int len = arr.length, cnt = len / 4, cur = 1;
    //     for (int i = 1; i < len; ++i) {
    //         if (arr[i] == arr[i - 1]) {
    //             if (++cur > cnt) {
    //                 return arr[i - 1];
    //             }
    //         } else {
    //             cur = 1;
    //         }
    //     }
    //     return arr[0];
    // }

    /**
     * 18 / 18, 0ms(100%), 39.9MB(100%)
     */
    public int findSpecialInteger(int[] arr) {
        int len = arr.length, cnt = len / 4, i = 0;
        len -= cnt;
        while (i < len) {
            if (arr[i] == arr[i + cnt]) {
                return arr[i];
            }
            ++i;
            while (arr[i] == arr[i - 1]) {
                ++i;
            }
        }
        return arr[0];
    }
}
// @lc code=end
