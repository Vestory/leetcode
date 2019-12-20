/*
 * @lc app=leetcode.cn id=342 lang=java
 *
 * [342] 4的幂
 */

// @lc code=start
class Solution {
    /**
     * 迭代
     * 1060 / 1060, 1ms(100%), 33.7MB(12.89%)
     */
    // public boolean isPowerOfFour(int num) {
    //     if (num < 1) {
    //         return false;
    //     }
    //     while (num != 1) {
    //         if (num % 4 != 0) {
    //             return false;
    //         }
    //         num /= 4;
    //     }
    //     return true;
    // }

    /**
     * https://leetcode-cn.com/problems/power-of-four/solution/wei-shi-yao-xian-pan-duan-shi-fou-wei-2de-mi-by-va/
     * https://leetcode-cn.com/problems/power-of-four/solution/e-you-shi-yi-dao-zhuang-bi-jie-fa-de-suan-fa-ti-2/
     * 1060 / 1060, 1ms(100%), 33.6MB(12.89%)
     */
    public boolean isPowerOfFour(int num) {
        if (num < 0 || (num & (num - 1)) != 0) {
            return false;
        }
        return (num & (0x55555555)) != 0;
    }
}
// @lc code=end

