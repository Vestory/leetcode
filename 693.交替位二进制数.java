/*
 * @lc app=leetcode.cn id=693 lang=java
 *
 * [693] 交替位二进制数
 */

// @lc code=start
class Solution {
    /**
     * https://leetcode-cn.com/problems/binary-number-with-alternating-bits/solution/pythonduo-chong-fang-fa-by-zhu-xiao-xiao-xiao-xiao/
     * 204 / 204, 1ms(80.45%), 33MB(73.8%)
     */
    public boolean hasAlternatingBits(int n) {
        int temp = n ^ (n >> 1);
        return (temp & (temp + 1)) == 0;
    }
}
// @lc code=end

