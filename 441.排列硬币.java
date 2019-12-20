/*
 * @lc app=leetcode.cn id=441 lang=java
 *
 * [441] 排列硬币
 */

// @lc code=start
class Solution {
    /**
     * 公式法
     * 1336 / 1336, 2ms(90.19%), 33.7MB(75.12%)
     */
    // public int arrangeCoins(int n) {
    //     return (int)((Math.sqrt(1 + 8 * (double)n) - 1) / 2);
    // }

    /**
     * 公式法
     * https://leetcode-cn.com/problems/arranging-coins/solution/zhi-jie-qiu-kk1-2-nde-jie-ran-hou-qu-zheng-ji-ke-y/
     * 1336 / 1336, 2ms(90.19%), 33.7MB(75.12%)
     */
    public int arrangeCoins(int n) {
        return (int) (Math.sqrt(2) * Math.sqrt(n + 0.125) - 0.5);
    }
}
// @lc code=end

