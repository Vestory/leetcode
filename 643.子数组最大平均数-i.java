/*
 * @lc app=leetcode.cn id=643 lang=java
 *
 * [643] 子数组最大平均数 I
 */

// @lc code=start
class Solution {
    /**
     * 123 / 123, 4ms(93.77%), 42.1MB(86.96%)
     */
    public double findMaxAverage(int[] nums, int k) {
        int max = 0, next = 0, i = -1, len = nums.length;
        while (++i < k) {
            max += nums[i];
        }
        next = max;
        --i;
        while (++i < len) {
            next += nums[i] - nums[i - k];
            if (next > max) {
                max = next;
            }
        }
        return max / (double)k;
    }
}
// @lc code=end

