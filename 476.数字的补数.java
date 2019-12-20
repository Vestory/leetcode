/*
 * @lc app=leetcode.cn id=476 lang=java
 *
 * [476] 数字的补数
 */

// @lc code=start
class Solution {
    /**
     * https://leetcode-cn.com/problems/number-complement/solution/yi-huo-by-im-me/
     * 149 / 149, 1ms(78.83%), 32.9MB(76.7%)
     */
    public int findComplement(int num) {
        int temp = 1;
        while (temp < num) {
            temp <<= 1;
            temp += 1;
        }
        return (temp ^ num);
    }
}
// @lc code=end

