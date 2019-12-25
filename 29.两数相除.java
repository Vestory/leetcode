/*
 * @lc app=leetcode.cn id=29 lang=java
 *
 * [29] 两数相除
 */

// @lc code=start
class Solution {
    public int divide(int dividend, int divisor) {
        boolean negative = false;
        if (dividend < 0) {
            dividend = -dividend;
            negative = true;
        }
        if (divisor < 0) {
            divisor = -divisor;
            negative = !negative;
        }
        long a = dividend, b = divisor;
        int cnt = 0, step = divisor;
        while (b <= a) {
            ++cnt;
            b += step;
        }
        return negative ? -cnt : cnt;
    }
}
// @lc code=end

