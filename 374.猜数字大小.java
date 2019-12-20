/*
 * @lc app=leetcode.cn id=374 lang=java
 *
 * [374] 猜数字大小
 */

// @lc code=start
/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    /**
     * 二分查找
     * 25 / 25, 0ms(100%), 33MB(67.42%)
     */
    // public int guessNumber(int n) {
    //     int l = 1, m = l + (n - l) / 2, temp = guess(m);
    //     while (temp != 0) {
    //         if (guess(m) == 1) {
    //             l = m + 1;
    //         } else {
    //             n = m - 1;
    //         }
    //         m = l + (n - l) / 2;
    //         temp = guess(m);
    //     }
    //     return m;
    // }

    // #region [0] 官方解答
    // https://leetcode-cn.com/problems/guess-number-higher-or-lower/solution/cai-shu-zi-da-xiao-by-leetcode/
    /**
     * 暴力法
     * 时间复杂度O(n), 空间复杂度O(1)
     * 超时
     */
    // public int guessNumber(int n) {
    //     for (int i = 1; i < n; i++)
    //         if (guess(i) == 0)
    //             return i;
    //     return n;
    // }

    /**
     * 三分查找
     * 25 / 25, 0ms(100%), 32.8MB(69.09%)
     */
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid1 = low + (high - low) / 3;
            int mid2 = high - (high - low) / 3;
            int res1 = guess(mid1);
            int res2 = guess(mid2);
            if (res1 == 0)
                return mid1;
            if (res2 == 0)
                return mid2;
            else if (res1 < 0)
                high = mid1 - 1;
            else if (res2 > 0)
                low = mid2 + 1;
            else {
                low = mid1 + 1;
                high = mid2 - 1;
            }
        }
        return -1;
    }
    // #endregion
}
// @lc code=end

