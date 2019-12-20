/*
 * @lc app=leetcode.cn id=389 lang=java
 *
 * [389] 找不同
 */

// @lc code=start
class Solution {
    /**
     * 求和，相减
     * 54 / 54, 2ms(93.36%), 37.8MB(39.2%)
     */
    // public char findTheDifference(String s, String t) {
    //     int sum = 0;
    //     for (int i = 0; i < s.length(); ++i) {
    //         sum += s.charAt(i);
    //     }
    //     for (int i = 0; i < t.length(); ++i) {
    //         sum -= t.charAt(i);
    //     }
    //     return (char)(-sum);
    // }

    /**
     * 求和，相减
     * 54 / 54, 2ms(93.36%), 37.5MB(41.4%)
     */
    // public char findTheDifference(String s, String t) {
    //     int sum = 0, i = 0;
    //     while (i < s.length()) {
    //         sum += (s.charAt(i) - t.charAt(i));
    //         ++i;
    //     }
    //     sum -= t.charAt(i);
    //     return (char) (-sum);
    // }

    /**
     * 位运算
     * 54 / 54, 2ms(93.36%), 37.5MB(42.51%)
     */
    public char findTheDifference(String s, String t) {
        char res = 0, i = 0;
        while (i < s.length()) {
            res ^= s.charAt(i);
            res ^= t.charAt(i);
            ++i;
        }
        res ^= t.charAt(i);
        return res;
    }
}
// @lc code=end

