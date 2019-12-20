/*
 * @lc app=leetcode.cn id=231 lang=java
 *
 * [231] 2的幂
 */

// @lc code=start
class Solution {
    /**
     * 一直除以2
     * 1108 / 1108, 1ms(100%), 33.4MB(15.06%)
     */
    // public boolean isPowerOfTwo(int n) {
    //     if (n == 1) {
    //         return true;
    //     }
    //     while (n != 0 && n % 2 == 0) {
    //         n /= 2;
    //         if (n == 1) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    /**
     * 位操作
     * https://leetcode-cn.com/problems/power-of-two/solution/power-of-two-er-jin-zhi-ji-jian-by-jyd/
     * 1108 / 1108, 1ms(100%), 33.4MB(13.52%)
     */
    // public boolean isPowerOfTwo(int n) {
    //     return n > 0 && (n & (n - 1)) == 0;
    // }

    // #region [0]
    // https://leetcode-cn.com/problems/power-of-two/solution/bao-li-wei-yun-suan-by-powcai/
    /**
     * 递归除2
    //  */
    // public boolean isPowerOfTwo(int n) {
    //     if (n <= 0) {
    //         return false;
    //     }
    //     if (n == 1) {
    //         return true;
    //     }
    //     if (n % 2 == 0) {
    //         return isPowerOfTwo(n / 2);
    //     }
    //     return false;
    // }

    /**
     * 迭代除2
     */
    // public boolean isPowerOfTwo(int n) {
    //     if (n == 0) {
    //         return false;
    //     }
    //     while (n % 2 == 0) {
    //         n /= 2;
    //     }
    //     return n == 1;
    // }

    /**
     * 位计数，如果是2的幂，那么其2进制只有一个1
     * python实现如下
     */
    // def isPowerOfTwo(self, n: int) -> bool:
    //     return n > 0 and bin(n).count("1") == 1
    // #endregion
}
// @lc code=end

