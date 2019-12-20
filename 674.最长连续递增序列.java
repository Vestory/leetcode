/*
 * @lc app=leetcode.cn id=674 lang=java
 *
 * [674] 最长连续递增序列
 */

// @lc code=start
class Solution {
    /**
     * 36 / 36, 1ms(100%), 37.4MB(95.12%)
     */
    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int cur = 1, max = 1;
        for (int i = 1; i < len; ++i) {
            if (nums[i] > nums[i - 1]) {
                ++cur;
            } else {
                if (max < cur) {
                    max = cur;
                }
                while (++i < len) {
                    if (nums[i] > nums[i - 1]) {
                        break;
                    }
                }
                cur = i == len ? 1 : 2;
                if (max < cur) {
                    max = cur;
                }
            }
        }
        if (max < cur) {
            max = cur;
        }
        return max;
    }
}
// @lc code=end

