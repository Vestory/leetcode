/*
 * @lc app=leetcode.cn id=1217 lang=java
 *
 * [1217] 玩筹码
 */

// @lc code=start
class Solution {
    /**
     * 50 / 50, 0ms(100%), 35.1MB(100%)
     */
    public int minCostToMoveChips(int[] chips) {
        int odd = 0, even = 0;
        for (int num : chips) {
            if (num % 2 == 1) {
                ++odd;
            } else {
                ++even;
            }
        }
        return odd < even ? odd : even;
    }
}
// @lc code=end

