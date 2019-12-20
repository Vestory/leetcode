/*
 * @lc app=leetcode.cn id=605 lang=java
 *
 * [605] 种花问题
 */

// @lc code=start
class Solution {
    /**
     * 123 / 123, 1ms(100%), 39.1MB(93.33%)
     */
    // public boolean canPlaceFlowers(int[] flowerbed, int n) {
    //     if (n == 0) {
    //         return true;
    //     }
    //     int i = -1, len = flowerbed.length, count = 1;
    //     while (++i < len) {
    //         if (flowerbed[i] == 0) {
    //             if (++count == 3) {
    //                 if (--n == 0) {
    //                     return true;
    //                 }
    //                 count = 1;
    //             }
    //         } else {
    //             count = 0;
    //         }
    //     }
    //     return count == 2 ? (--n == 0) : false;
    // }

    // #region [0] 官方解题
    // https://leetcode-cn.com/problems/can-place-flowers/solution/chong-hua-wen-ti-by-leetcode/
    /**
     * 贪心
     * n, 1
     * 123, 1ms(100%), 38.8MB(94.13%)
     */
    // public boolean canPlaceFlowers(int[] flowerbed, int n) {
    //     int i = 0, count = 0;
    //     while (i < flowerbed.length) {
    //         if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0)
    //                 && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
    //             flowerbed[i] = 1;
    //             count++;
    //         }
    //         i++;
    //     }
    //     return count >= n;
    // }
    /**
     * 贪心 + 常数优化
     * n, 1
     * 123, 2ms(84.56%), 39.2MB(92.8%)
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0, count = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0)
                    && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i++] = 1;
                count++;
            }
            if (count >= n)
                return true;
            i++;
        }
        return false;
    }
    // #endregion
}
// @lc code=end

