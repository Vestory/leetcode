import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=561 lang=java
 *
 * [561] 数组拆分 I
 */

// @lc code=start
class Solution {
    /**
     * 81 / 81, 18ms(93.5%), 40.4MB(95.79%)
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len; i += 2) {
            count += nums[i];
        }
        return count;
    }
}
// @lc code=end

