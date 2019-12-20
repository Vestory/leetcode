/*
 * @lc app=leetcode.cn id=521 lang=java
 *
 * [521] 最长特殊序列 Ⅰ
 */

// @lc code=start
class Solution {
    /**
     * 41 / 41, 0ms(100%), 34MB(86.64%)
     */
    // public int findLUSlength(String a, String b) {
    //     int la = a.length(), lb = b.length();
    //     if (la == lb) {
    //         return a.equals(b) ? -1 : la;
    //     } else {
    //         return Math.max(la, lb);
    //     }
    // }

    /**
     * 41 / 41, 0ms(100%), 34.1MB(84.91%)
     */
    // public int findLUSlength(String a, String b) {
    //     if (a.length() == b.length()) {
    //         return a.equals(b) ? -1 : a.length();
    //     }
    //     return a.length() > b.length() ? a.length() : b.length();
    // }

    /**
     * 41 / 41, 0ms(100%), 33.8MB(87.5%)
     */
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : (a.length() > b.length() ? a.length() : b.length());
    }
}
// @lc code=end

