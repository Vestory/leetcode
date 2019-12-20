/*
 * @lc app=leetcode.cn id=746 lang=java
 *
 * [746] 使用最小花费爬楼梯
 */

// @lc code=start
class Solution {
    /**
     * 暴力法
     * 超时
     */
    // private int[] cost;
    // private int len;
    // public int minCostClimbingStairs(int[] cost) {
    //     this.cost = cost;
    //     this.len = cost.length - 2;
    //     return Math.min(mccs(0), mccs(1));
    // }
    // private int mccs(int idx) {
    //     return (idx < len ? Math.min(mccs(idx + 1), mccs(idx + 2)) : 0) + cost[idx];
    // }

    /**
     * 动态规划
     * https://leetcode-cn.com/problems/min-cost-climbing-stairs/solution/shi-yong-zui-xiao-hua-fei-pa-lou-ti-by-leetcode/
     * 276 / 276, 1ms(100%), 38MB(82.77%)
     */
    public int minCostClimbingStairs(int[] cost) {
        int c0 = 0, c1 = 0, ct;
        for (int i = cost.length - 1; i >= 0; --i) {
            ct = cost[i] + Math.min(c0, c1);
            c0 = c1;
            c1 = ct;
        }
        return Math.min(c0, c1);
    }
}
// @lc code=end

