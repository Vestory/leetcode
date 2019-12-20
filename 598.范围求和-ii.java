/*
 * @lc app=leetcode.cn id=598 lang=java
 *
 * [598] 范围求和 II
 */

// @lc code=start
class Solution {
    /**
     * 69 / 69, 1ms(85.36%), 36.1MB(92.44%)
     */
    // public int maxCount(int m, int n, int[][] ops) {
    //     int len = ops.length;
    //     if (len == 0) {
    //         return m * n;
    //     }
    //     int a = ops[0][0], b = ops[0][1];
    //     for (int i = 1; i < len; ++i) {
    //         if (ops[i][0] > 0) {
    //             if (a == 0 || ops[i][0] < a) {
    //                 a = ops[i][0];
    //             }
    //         }
    //         if (ops[i][1] > 0) {
    //             if (b == 0 || ops[i][1] < b) {
    //                 b = ops[i][1];
    //             }
    //         }
    //     }
    //     if (a == 0) {
    //         a = m;
    //     }
    //     if (b == 0) {
    //         b = n;
    //     }
    //     return a * b;
    // }

    /**
     * 69 / 69, 0ms(100%), 37.3MB(84.87%)
     */
    public int maxCount(int m, int n, int[][] ops) {
        int len = ops.length;
        if (len == 0) {
            return m * n;
        }
        int a = Integer.MAX_VALUE, b = a;
        for (int i = 0; i < len; ++i) {
            if (ops[i][0] > 0 && ops[i][0] < a) {
                a = ops[i][0];
            }
            if (ops[i][1] > 0 && ops[i][1] < b) {
                b = ops[i][1];
            }
        }
        if (a == 0) {
            a = m;
        }
        if (b == 0) {
            b = n;
        }
        return a * b;
    }
}
// @lc code=end

