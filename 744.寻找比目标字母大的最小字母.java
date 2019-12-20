/*
 * @lc app=leetcode.cn id=744 lang=java
 *
 * [744] 寻找比目标字母大的最小字母
 */

// @lc code=start
class Solution {
    /**
     * 165 / 165, 1ms(53.35%), 39.3MB(95.7%)
     */
    // public char nextGreatestLetter(char[] letters, char target) {
    //     for (int i = letters.length - 1; i >= 0; --i) {
    //         if (target >= letters[i]) {
    //             return letters[(i + 1) % letters.length];
    //         }
    //     }
    //     return letters[0];
    // }

    /**
     * 165 / 165, 0ms(100%), 39.3MB(95.7%)
     */
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, r = letters.length - 1, m;
        if (letters[r] > target) {
            while (l <= r) {
                m = (l + r) / 2;
                if (letters[m] > target) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
            return letters[l];
        }
        return letters[0];
    }
}
// @lc code=end

