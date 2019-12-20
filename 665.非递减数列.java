/*
 * @lc app=leetcode.cn id=665 lang=java
 *
 * [665] 非递减数列
 */

// @lc code=start
class Solution {
    /**
     * https://leetcode-cn.com/problems/non-decreasing-array/solution/wang-xiao-kan-qi-yu-dao-ni-xu-de-xian-he-shang-yi-/
     * 325 / 325, 1ms(100%), 40.6MB(90.82%)
     */
    public boolean checkPossibility(int[] nums) {
        int len = nums.length - 1, count = 0;
        for (int i = 0; i < len; ++i) {
            if (nums[i] > nums[i + 1]) {
                if (i > 0) {
                    if (nums[i - 1] > nums[i + 1]) {
                        nums[i + 1] = nums[i];
                    } else {
                        nums[i] = nums[i - 1];
                    }
                } else {
                    nums[i] = nums[i + 1];
                }
                if (++count == 2) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 其他解法
     * https://leetcode-cn.com/problems/non-decreasing-array/solution/fei-di-jian-shu-lie-by-leetcode/
     * https://leetcode-cn.com/problems/non-decreasing-array/solution/javafei-di-jian-shu-lie-by-but-2/
     */
}
// @lc code=end

