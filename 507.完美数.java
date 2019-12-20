/*
 * @lc app=leetcode.cn id=507 lang=java
 *
 * [507] 完美数
 */

// @lc code=start
class Solution {
    /**
     * 156 / 156, 639ms(22.73%), 33.1MB(77.31%)
     */
    // public boolean checkPerfectNumber(int num) {
    //     if (num == 1) {
    //         return false;
    //     }
    //     int count = 1, x = 2, y = num;
    //     while (y > x) {
    //         if (num % x == 0) {
    //             y = num / x;
    //             count += x;
    //             count += y;
    //         }
    //         ++x;
    //     }
    //     if (x * x == num) {
    //         count += x;
    //     }
    //     return count == num;
    // }

    /**
     * https://leetcode-cn.com/problems/perfect-number/solution/wan-mei-shu-by-leetcode/
     * 时间和空间复杂度均为O(1)
     * 156 / 156, 1ms(98.33%), 33.2MB(76.85%)
     */
    public int pn(int p) {
        return (1 << (p - 1)) * ((1 << p) - 1);
    }

    public boolean checkPerfectNumber(int num) {
        int[] primes = new int[] { 2, 3, 5, 7, 13, 17, 19, 31 };
        for (int prime : primes) {
            if (pn(prime) == num)
                return true;
        }
        return false;
    }
}
// @lc code=end

