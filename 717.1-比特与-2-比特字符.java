/*
 * @lc app=leetcode.cn id=717 lang=java
 *
 * [717] 1比特与2比特字符
 */

// @lc code=start
class Solution {
    /**
     * 93 / 93, 0ms(100%), 36.1MB(88.1%)
     */
    public boolean isOneBitCharacter(int[] bits) {
        int len = bits.length;
        if (len == 1 || (len > 1 && bits[len - 2] == 0)) {
            return true;
        }
        len -= 2;
        for (int i = 0; i < len; ++i) {
            if (bits[i] == 1) {
                if (++i == len) {
                    return true;
                }
            }
        }
        return false;
    }
}
// @lc code=end

