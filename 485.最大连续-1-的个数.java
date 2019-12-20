/*
 * @lc app=leetcode.cn id=485 lang=java
 *
 * [485] 最大连续1的个数
 */

// @lc code=start
class Solution {
    /**
     * 41 / 41, 3ms(89.14%), 39.6MB(92.19%)
     */
    // public int findMaxConsecutiveOnes(int[] nums) {
    //     int max = 0, curr = 0;
    //     for (int i = 0; i < nums.length; ++i) {
    //         if (nums[i] == 1) {
    //             ++curr;
    //         } else {
    //             if (curr > max) {
    //                 max = curr;
    //             }
    //             curr = 0;
    //         }
    //     }
    //     return max > curr ? max : curr;
    // }

    /**
     * 双指针法
     * https://leetcode-cn.com/problems/max-consecutive-ones/solution/shuang-zhi-zhen-fa-bi-jiao-chang-du-by-kington/
     * 41 / 41, 3ms(89.14%), 38.6MB(95.1%)
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int j = 0;
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 1) {
                len = len > (i - j) ? len : (i - j);
                j = i + 1;
            } else if ((i == nums.length - 1) && (nums[nums.length - 1] == 1)) {
                len = len > (i + 1 - j) ? len : (i + 1 - j);
            }
        }
        return len;
    }
}
// @lc code=end

