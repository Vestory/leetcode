/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution {
    /**
     * 动态规划
     * https://leetcode-cn.com/problems/house-robber/solution/da-jia-jie-she-by-leetcode/
     * 69 / 69, 0ms(100%), 33.9MB(90.38%)
     */
    public int rob(int[] num) {
        int prevMax = 0;
        int currMax = 0;
        for (int x : num) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
    }
}
// @lc code=end

