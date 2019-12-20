/*
 * @lc app=leetcode.cn id=344 lang=java
 *
 * [344] 反转字符串
 */

// @lc code=start
class Solution {
    /**
     * 双指针
     * 478 / 478, 1ms(100%), 51.8MB(78.62%)
     */
    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        char c;
        while (l < r) {
            if (s[l] != s[r]) {
                c = s[l];
                s[l] = s[r];
                s[r] = c;
            }
            ++l;
            --r;
        }
    }
}
// @lc code=end

