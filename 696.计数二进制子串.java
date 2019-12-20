/*
 * @lc app=leetcode.cn id=696 lang=java
 *
 * [696] 计数二进制子串
 */

// @lc code=start
class Solution {
    /**
     * 90 / 90, 12ms(83.4%), 37.8MB(88.61%)
     */
    // public int countBinarySubstrings(String s) {
    //     int len = s.length(), idx = -1, l = 0, r = 1, last = 0, temp;
    //     int[] arr = new int[len];
    //     char[] chs = s.toCharArray();
    //     while (r < len) {
    //         if (chs[r] != chs[l]) {
    //             temp = r - l;
    //             if (last != 0) {
    //                 arr[++idx] = temp < last ? temp : last;
    //             }
    //             last = temp;
    //             l = r;
    //         }
    //         ++r;
    //     }
    //     if (last != 0) {
    //         temp = r - l;
    //         arr[++idx] = temp < last ? temp : last;
    //     }
    //     int res = 0;
    //     for (int i = 0; i <= idx; ++i) {
    //         res += arr[i];
    //     }
    //     return res;
    // }

    /**
     * 90 / 90, 8ms(99.8%), 37.9MB(88.61%)
     */
    public int countBinarySubstrings(String s) {
        int l = -1, r = 1, res = 0, len = s.length();
        char[] chs = s.toCharArray();
        while (r < len) {
            if (chs[r] != chs[r - 1]) {
                l = r;
                break;
            }
            ++r;
        }
        if (r == len - 1) {
            return 1;
        } else if (r == len) {
            return 0;
        }
        for (int i = r + 1; i < len; ++i) {
            if (chs[i] != chs[i - 1]) {
                r = i - r;
                res += l < r ? l : r;
                l = r;
                r = i;
            }
        }
        r = len - r;
        res += l < r ? l : r;
        return res;
    }
}
// @lc code=end

