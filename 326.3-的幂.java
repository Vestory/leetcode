/*
 * @lc app=leetcode.cn id=326 lang=java
 *
 * [326] 3的幂
 */

// @lc code=start
class Solution {
    /**
     * 迭代
     * 21038 / 21038, 15ms(96.35%), 35.9MB(86.35%)
     */
    // public boolean isPowerOfThree(int n) {
    //     if (n <= 0) {
    //         return false;
    //     }
    //     while (n != 1) {
    //         if (n % 3 != 0) {
    //             return false;
    //         }
    //         n /= 3;
    //     }
    //     return true;
    // }

    // #region [0] 官方解答
    /**
     * 迭代
     * 时间复杂度O(logn)，空间复杂度O(1)
     * 21038 / 21038, 15ms(96.35%), 35.9MB(86.35%)
     */
    // public boolean isPowerOfThree(int n) {
    //     if (n < 1) {
    //         return false;
    //     }
    //     while (n % 3 == 0) {
    //         n /= 3;
    //     }
    //     return n == 1;
    // }

    /**
     * 基准转换
     * 时间复杂度和空间复杂度均为O(log3 n)
     * 21038 / 21038, 39ms(47.76%), 39.2MB(28.27%)
     */
    // public boolean isPowerOfThree(int n) {
    //     return Integer.toString(n, 3).matches("^10*$");
    // }

    /**
     * 运算法
     * 时间复杂度未知，空间复杂度O(1)
     */
    // public boolean isPowerOfThree(int n) {
    //     return (Math.log(n) / Math.log(3) + epsilon) % 1 <= 2 * epsilon;
    // }

    /**
     * 整数限制
     * 时间复杂度和空间复杂度均为O(1)
     * 21038 / 21038, 14ms(98.87%), 36MB(86.35%)
     */
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
    // #endregion
}
// @lc code=end

