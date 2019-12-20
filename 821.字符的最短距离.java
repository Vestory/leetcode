/*
 * @lc app=leetcode.cn id=821 lang=java
 *
 * [821] 字符的最短距离
 */

// @lc code=start
class Solution {
    /**
     * 76 / 76, 1ms(99.67%), 36.3MB(83.19%)
     */
    // public int[] shortestToChar(String S, char C) {
    //     char[] arr = S.toCharArray();
    //     int len = arr.length;
    //     int[] pos = new int[len];
    //     int size = 0;
    //     for (int i = 0; i < len; ++i) {
    //         if (arr[i] == C) {
    //             pos[size] = i;
    //             ++size;
    //         }
    //     }
    //     int[] res = new int[len];
    //     int i = 0;
    //     while (i <= pos[0]) {
    //         res[i] = pos[0] - i;
    //         ++i;
    //     }
    //     int l = pos[0], r = size > 1 ? pos[1] : -1, j = 2, temp;
    //     while (i < len) {
    //         res[i] = i - l;
    //         if (r != -1) {
    //             temp = r - i;
    //             if (res[i] > temp) {
    //                 res[i] = temp;
    //             }
    //         }
    //         if (res[i] == 0) {
    //             l = r;
    //             if (j < size) {
    //                 r = pos[j];
    //                 ++j;
    //             } else {
    //                 r = -1;
    //             }
    //         }
    //         ++i;
    //     }
    //     return res;
    // }

    /**
     * 76 / 76, 1ms(99.67%), 36.3MB(83.19%)
     */
    // public int[] shortestToChar(String S, char C) {
    //     char[] arr = S.toCharArray();
    //     int len = arr.length, l = -1, r = -1, j = 0, temp;
    //     int[] res = new int[len];
    //     for (int i = 0; i < len; ++i) {
    //         if (arr[i] == C) {
    //             if (r == -1) {
    //                 r = i;
    //                 while (j <= i) {
    //                     res[j] = r - j;
    //                     ++j;
    //                 }
    //             } else {
    //                 l = r;
    //                 r = i;
    //                 while (j <= i) {
    //                     res[j] = j - l;
    //                     temp = r - j;
    //                     if (res[j] > temp) {
    //                         res[j] = temp;
    //                     }
    //                     ++j;
    //                 }
    //             }
    //         }
    //     }
    //     while (j < len) {
    //         res[j] = j - r;
    //         ++j;
    //     }
    //     return res;
    // }

    /**
     * 76 / 76, 1ms(99.67%), 36.1MB(84.91%)
     */
    public int[] shortestToChar(String S, char C) {
        char[] arr = S.toCharArray();
        int len = arr.length, l = -1, r = -1, j = 0, max, cur;
        int[] res = new int[len];
        for (int i = 0; i < len; ++i) {
            if (arr[i] == C) {
                if (r == -1) {
                    r = i;
                    while (j < i) {
                        res[j] = r - j;
                        ++j;
                    }
                } else {
                    l = r;
                    r = i;
                    max = (r - l) / 2;
                    cur = 1;
                    res[i] = 0;
                    while (cur <= max) {
                        res[j + cur] = cur;
                        res[i - cur] = cur;
                        ++cur;
                    }
                    j = i;
                }
            }
        }
        while (j < len) {
            res[j] = j - r;
            ++j;
        }
        return res;
    }

    /**
     * 官方解题
     * 最小数组
     * https://leetcode-cn.com/problems/shortest-distance-to-a-character/solution/zi-fu-de-zui-duan-ju-chi-by-leetcode/
     * 76 / 76, 1ms(99.67%), 36MB(87.93%)
     */
    // public int[] shortestToChar(String S, char C) {
    //     int N = S.length();
    //     int[] ans = new int[N];
    //     int prev = Integer.MIN_VALUE / 2;
    //     for (int i = 0; i < N; ++i) {
    //         if (S.charAt(i) == C)
    //             prev = i;
    //         ans[i] = i - prev;
    //     }
    //     prev = Integer.MAX_VALUE / 2;
    //     for (int i = N - 1; i >= 0; --i) {
    //         if (S.charAt(i) == C)
    //             prev = i;
    //         ans[i] = Math.min(ans[i], prev - i);
    //     }
    //     return ans;
    // }
}
// @lc code=end

