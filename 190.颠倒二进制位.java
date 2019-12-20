/*
 * @lc app=leetcode.cn id=190 lang=java
 *
 * [190] 颠倒二进制位
 */

// @lc code=start
public class Solution {
    // you need treat n as an unsigned value
    /**
     * https://leetcode-cn.com/problems/reverse-bits/solution/javajie-fa-by-sh1tge/
     * 600 / 600, 1ms(100%), 30.3MB(5.27%)
     */
    public int reverseBits(int n) {
        int res = 0, temp;
        for (int i = 0; i < 32; ++i) {
            // 将给定的二进制数，由低位到高位逐个取出
            // 然后右移一位
            temp = n >> i;
            // 取有效位
            temp &= 1;
            // 然后通过位运算将其放置到反转后的位置
            temp = temp << (31 - i);
            // 将上述结果再次通过运算结合到一起
            res |= temp;
        }
        return res;
    }
}
// @lc code=end

