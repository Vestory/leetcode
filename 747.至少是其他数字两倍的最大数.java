/*
 * @lc app=leetcode.cn id=747 lang=java
 *
 * [747] 至少是其他数字两倍的最大数
 */

// @lc code=start
class Solution {
    /**
     * 250 / 250, 1ms(99.83%), 34.9MB(88.78%)
     */
    public int dominantIndex(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len - 1;
        }
        int fir = 0, sec = 1;
        if (nums[fir] < nums[sec]) {
            fir = 1;
            sec = 0;
        }
        for (int i = 2; i < len; ++i) {
            if (nums[i] > nums[fir]) {
                sec = fir;
                fir = i;
            } else if (nums[i] > nums[sec]) {
                sec = i;
            }
        }
        return nums[fir] >= nums[sec] * 2 ? fir : -1;
    }
}
// @lc code=end

