/*
 * @lc app=leetcode.cn id=942 lang=java
 *
 * [942] 增减字符串匹配
 */

// @lc code=start
class Solution {
    /**
     * 95 / 95, 2ms(99.34%), 38.3MB(92.42%)
     */
    // public int[] diStringMatch(String S) {
    //     char[] chs = S.toCharArray();
    //     int len = chs.length, size = 0, l = 0, r = 1;
    //     int[] cmds = new int[len];
    //     while (r < len) {
    //         while (r < len) {
    //             if (chs[r - 1] != chs[r]) {
    //                 break;
    //             }
    //             ++r;
    //         }
    //         cmds[size] = chs[l] == 'I' ? (r - l) : (l - r);
    //         ++size;
    //         l = r;
    //         ++r;
    //     }
    //     if (l < len) {
    //         cmds[size] = chs[l] == 'I' ? (r - l) : (l - r);
    //     }
    //     ++size;
    //     int[] res = new int[len + 1];
    //     int idx = 0, i = 1;
    //     if (cmds[0] > 0) {
    //         l = 0;
    //         r = 0;
    //         ++cmds[0];
    //         while (i < size) {
    //             l -= cmds[i];
    //             r = l - 1;
    //             for (int j = cmds[i - 1]; j > 0; --j) {
    //                 res[idx] = l;
    //                 ++idx;
    //                 ++l;
    //             }
    //             for (int j = cmds[i]; j < 0; ++j) {
    //                 res[idx] = r;
    //                 ++idx;
    //                 --r;
    //             }
    //             r = l;
    //             i += 2;
    //         }
    //     } else {
    //         --cmds[0];
    //         l = len;
    //         r = len;
    //         while (i < size) {
    //             l -= cmds[i];
    //             r = l + 1;
    //             for (int j = cmds[i - 1]; j < 0; ++j) {
    //                 res[idx] = l;
    //                 ++idx;
    //                 --l;
    //             }
    //             for (int j = cmds[i]; j > 0; --j) {
    //                 res[idx] = r;
    //                 ++idx;
    //                 ++r;
    //             }
    //             r = l;
    //             i += 2;
    //         }
    //     }
    //     if (i == size) {
    //         --i;
    //         if (cmds[i] > 0) {
    //             for (int j = cmds[i]; j > 0; --j) {
    //                 res[idx] = l;
    //                 ++idx;
    //                 ++l;
    //             }
    //         } else {
    //             for (int j = cmds[i]; j < 0; ++j) {
    //                 res[idx] = l;
    //                 ++idx;
    //                 --l;
    //             }
    //         }
    //     }
    //     return res;
    // }

    /**
     * 官方解题
     * https://leetcode-cn.com/problems/di-string-match/solution/zeng-jian-zi-fu-chuan-pi-pei-by-leetcode/
     * 95 / 95, 3ms(76.99%), 37.9MB(93.84%)
     */
    // public int[] diStringMatch(String S) {
    //     int N = S.length();
    //     int lo = 0, hi = N;
    //     int[] ans = new int[N + 1];
    //     for (int i = 0; i < N; ++i) {
    //         if (S.charAt(i) == 'I')
    //             ans[i] = lo++;
    //         else
    //             ans[i] = hi--;
    //     }
    //     ans[N] = lo;
    //     return ans;
    // }

    /**
     * https://leetcode-cn.com/problems/di-string-match/solution/zheng-jie-zhi-xing-yong-shi-3-ms-zai-suo-you-java-/
     * 95 / 95, 2ms(99.34%), 38.6MB(87.83%)
     */
    public int[] diStringMatch(String S) {
        int sLen = S.length();
        int[] arr = new int[sLen + 1];
        int max = sLen;
        int min = 0;
        for (int i = 0; i < sLen; i++) {
            if ('D' == S.charAt(i)) {
                arr[i] = max--;
            } else {
                arr[i] = min++;
            }
        }
        arr[sLen] = max;
        return arr;
    }
}
// @lc code=end