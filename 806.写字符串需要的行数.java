/*
 * @lc app=leetcode.cn id=806 lang=java
 *
 * [806] 写字符串需要的行数
 */

// @lc code=start
class Solution {
    /**
     * 26 / 26, 0ms(100%), 34.9MB(80.71%)
     */
    public int[] numberOfLines(int[] widths, String S) {
        if (S.length() == 0) {
            return new int[] { 0, 0 };
        }
        int rest = 100, line = 1, space;
        for (char c : S.toCharArray()) {
            space = widths[c - 'a'];
            if (rest < space) {
                ++line;
                rest = 100;
            }
            rest -= space;
        }
        return new int[] { line, 100 - rest };
    }
}
// @lc code=end

