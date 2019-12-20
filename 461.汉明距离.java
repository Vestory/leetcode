/*
 * @lc app=leetcode.cn id=461 lang=java
 *
 * [461] 汉明距离
 */

// @lc code=start
class Solution {
    /**
     * 149 / 149, 1ms(79.48%), 33.1MB(77.77%)
     */
    // public int hammingDistance(int x, int y) {
    //     x = x ^ y;
    //     y = 0;
    //     while (x > 0) {
    //         if (x % 2 != 0) {
    //             ++y;
    //         }
    //         x /= 2;
    //     }
    //     return y;
    // }

    /**
     * 149 / 149, 1ms(79.49%), 33.1MB(77.77%)
     */
    // public int hammingDistance(int x, int y) {
    //     x = x ^ y;
    //     y = 0;
    //     while (x != 0) {
    //         ++y;
    //         x = x & (x - 1);
    //     }
    //     return y;
    // }

    /**
     * 内置函数
     * 149 / 149, 1ms(79.49%), 33.3MB(77.38%)
     */
    // public int hammingDistance(int x, int y) {
    //     return Integer.bitCount(x ^ y);
    // }

    /**
     * https://leetcode-cn.com/problems/hamming-distance/solution/ge-chong-si-lu-du-you-shi-jian-fu-za-du-ke-yi-shuo/
     * 149 / 149, 1ms(79.49%), 33.2MB(77.77%)
     */
    public int hammingDistance(int x, int y) {
        int ans = 0;
        while (x != 0 || y != 0) {
            if ((x & 1) != (y & 1))
                ans++;
            x >>= 1;
            y >>= 1;
        }
        return ans;
    }
}
// @lc code=end

