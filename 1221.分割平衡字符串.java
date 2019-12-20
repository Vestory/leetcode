/*
 * @lc app=leetcode.cn id=1221 lang=java
 *
 * [1221] 分割平衡字符串
 */

// @lc code=start
class Solution {
    /**
     * 40 / 40, 0ms(100%), 34.2MB(100%)
     */
    public int balancedStringSplit(String s) {
        int count = 0, cur = 0;
        for (char c : s.toCharArray()) {
            if (c == 'L') {
                ++cur;
            } else {
                --cur;
            }
            if (cur == 0) {
                ++count;
            }
        }
        return count;
    }
}
// @lc code=end

