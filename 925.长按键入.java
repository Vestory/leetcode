/*
 * @lc app=leetcode.cn id=925 lang=java
 *
 * [925] 长按键入
 */

// @lc code=start
class Solution {
    /**
     * 71 / 71, 1ms(85.61%), 34.2MB(92.67%)
     */
    public boolean isLongPressedName(String name, String typed) {
        char[] nc = name.toCharArray(), tc = typed.toCharArray();
        int ncount = 0, tcount = 0, ln = nc.length, lt = tc.length, j = 0;
        char c;
        for (int i = 0; i < ln; ++i) {
            ncount = i;
            c = nc[i];
            while (++i < ln) {
                if (nc[i] != c) {
                    break;
                }
            }
            ncount = i - ncount;
            --i;
            tcount = j;
            while (j < lt) {
                if (tc[j] != c) {
                    break;
                }
                ++j;
            }
            tcount = j - tcount;
            if (tcount < ncount) {
                return false;
            }
        }
        return j == lt;
    }
}
// @lc code=end

