/*
 * @lc app=leetcode.cn id=724 lang=java
 *
 * [724] 寻找数组的中心索引
 */

// @lc code=start
class Solution {
    /**
     * 741 / 741, 2ms(99.87%), 40.1MB(95.37%)
     */
    public int pivotIndex(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return -1;
        }
        int[] sums = new int[len];
        sums[0] = nums[0];
        for (int i = 1; i < len; ++i) {
            sums[i] = sums[i - 1] + nums[i];
        }
        int sum = sums[len - 1];
        if (nums[0] == sum) {
            return 0;
        }
        for (int i = 1; i < len; ++i) {
            if (sums[i - 1] * 2 + nums[i] == sum) {
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end

