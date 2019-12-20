/*
 * @lc app=leetcode.cn id=263 lang=java
 *
 * [263] 丑数
 */

// @lc code=start
class Solution {
    /**
     * 1012 / 1012, 1ms(100%), 33.4MB(13.49%)
     */
    // public boolean isUgly(int num) {
    //     if (num < 1) {
    //         return false;
    //     }
    //     while (num != 1) {
    //         if (num % 5 == 0) {
    //             num /= 5;
    //             continue;
    //         }
    //         if (num % 3 == 0) {
    //             num /= 3;
    //             continue;
    //         }
    //         if (num % 2 == 0) {
    //             num /= 2;
    //             continue;
    //         }
    //         return false;
    //     }
    //     return true;
    // }

    /**
     * 1012 / 1012, 1ms(100%), 33.4MB(13.49%)
     */
    public boolean isUgly(int num) {
        if (num < 1) {
            return false;
        }
        while (num != 1) {
            if (num % 5 == 0) {
                num /= 5;
            } else if (num % 3 == 0) {
                num /= 3;
            } else if (num % 2 == 0) {
                num /= 2;
            } else {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

