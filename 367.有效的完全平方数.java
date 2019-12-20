/*
 * @lc app=leetcode.cn id=367 lang=java
 *
 * [367] 有效的完全平方数
 */

// @lc code=start
class Solution {
    // #region [0] 其他解法
    // https://leetcode-cn.com/problems/valid-perfect-square/solution/you-xiao-de-wan-quan-ping-fang-shu-by-gpe3dbjds1/
    /**
     * 递增判断
     * 超时
     */
    // public boolean isPerfectSquare(int num) {
    //     int i = 1;
    //     long n = i * i;
    //     while (n <= num) {
    //         if (n == num) {
    //             return true;
    //         }
    //         ++i;
    //         n = i * i;
    //     }
    //     return false;
    // }

    /**
     * 二分法
     * 超时
     */
    // public boolean isPerfectSquare(int num) {
    //     int start = 1;
    //     int end = num;
    //     int mid = start + (end - start) / 2;
    //     while (start <= end) {
    //         if (mid * mid > num) {
    //             end = mid - 1;
    //         } else if (mid * mid < num) {
    //             start = mid + 1;
    //         } else {
    //             return true;
    //         }
    //         mid = (end - start) / 2 + start;
    //     }
    //     return false;
    // }

    /**
     * 公式法
     * 68 / 68, 1ms(85.58%), 33.2MB(11.05%)
     */
    // public boolean isPerfectSquare(int num) {
    //     int i = 1;
    //     while (num > 0) {
    //         num -= i;
    //         i += 2;
    //     }
    //     return num == 0;
    // }

    /**
     * 牛顿迭代法
     * 68 / 68, 0ms(100%), 33MB(11.44%)
     */
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        int i = num / 2;
        while ((double)i * i > num) {
            i = (i + num / i) / 2;
        }
        return i * i == num;
    }
    // #endregion
}
// @lc code=end

