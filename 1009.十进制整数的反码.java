/*
 * @lc app=leetcode.cn id=1009 lang=java
 *
 * [1009] 十进制整数的反码
 */

// @lc code=start
class Solution {
    /**
     * https://leetcode-cn.com/problems/complement-of-base-10-integer/solution/-bi-mian-xun-huan-by-hareyukai/
     * 128 / 128, 1ms(79.94%), 33.2MB(5.17%)
     */
    public int bitwiseComplement(int N) {
        if (N == 0) {
            return 1;
        }
        int msb = (int)(Math.log(N) / Math.log(2));
        int mask = (1 << msb) - 1;
        return (~N) & mask;
    }
}
// @lc code=end

