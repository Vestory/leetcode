/*
 * @lc app=leetcode.cn id=796 lang=java
 *
 * [796] 旋转字符串
 */

// @lc code=start
class Solution {
    /**
     * 45 / 45, 0ms(100%), 34MB(90.1%)
     */
    public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A + A).indexOf(B) != -1;
    }
}
// @lc code=end

